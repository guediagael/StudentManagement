package training.android.ui.studentmanagement.views.student;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.models.Student;
import training.android.ui.studentmanagement.presenters.StudentPresenter;
import training.android.ui.studentmanagement.presenters.StudentPresenterToView;
import training.android.ui.studentmanagement.views.BaseFragment;


public class StudentsFragment extends StudentViewToPresenter{

    private long mGroupId;
    private static final String GROUP_ID= "groupId";
    private OnFragmentInteractionListener mListener;
    private StudentPresenterToView presenterToView;
    private ArrayList<Student> students;
    private RecyclerView rvStudents;


    public StudentsFragment() {
        // Required empty public constructor
    }


    public static StudentsFragment newInstance(long groupId) {
        StudentsFragment fragment = new StudentsFragment();
        Bundle arg = new Bundle();
        arg.putLong(GROUP_ID,groupId);
        fragment.setArguments(arg);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null)
            mGroupId = getArguments().getLong(GROUP_ID);
        students = new ArrayList<>();
        presenterToView = new StudentPresenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_students, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rvStudents = view.findViewById(R.id.recycler_students);
        rvStudents.setAdapter(new StudentRVAdapter(students,this));
        rvStudents.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenterToView.getStudents(mGroupId);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onFailure(String errorMessage) {

    }

    public void showStudent(long id){
        mListener.showStudentDetails(id,mGroupId);
    }

    @Override
    public void studentsLoaded(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
        rvStudents.getAdapter().notifyDataSetChanged();
    }


    public interface OnFragmentInteractionListener {
       void showStudentDetails(long studentId,@Nullable Long groupId);
    }
}
