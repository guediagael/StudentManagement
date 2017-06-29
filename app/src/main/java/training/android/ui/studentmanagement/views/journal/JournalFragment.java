package training.android.ui.studentmanagement.views.journal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.presenters.AttendancePresenter;
import training.android.ui.studentmanagement.presenters.AttendancePresenterToView;
import training.android.ui.studentmanagement.views.PersonDetails.AttendanceViewToPresenter;


public class JournalFragment extends AttendanceViewToPresenter {

    private static final String ARG_STUDENT_ID = "studentId";

    private long mStudentId;
    private RecyclerView rvJournal;
    private AttendancePresenterToView presenterToView;

    private OnFragmentInteractionListener mListener;

    public JournalFragment() {
        // Required empty public constructor
    }


    public static JournalFragment newInstance(long studentId) {
        JournalFragment fragment = new JournalFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_STUDENT_ID, studentId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStudentId = getArguments().getLong(ARG_STUDENT_ID);

        }
        presenterToView = new AttendancePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journal, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rvJournal = view.findViewById(R.id.recycler_journal);
        presenterToView.getInfo(mStudentId);
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

    @Override
    public void journalLoaded(Map<String, Boolean> journal) {
        rvJournal.setAdapter(new JournalRVAdapter(journal));
        rvJournal.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false));
    }


    public interface OnFragmentInteractionListener {

    }
}
