package training.android.ui.studentmanagement.views.group;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.models.Group;
import training.android.ui.studentmanagement.presenters.GroupPresenter;
import training.android.ui.studentmanagement.presenters.GroupPresenterToView;


public class GroupFragment extends  GroupViewToPresenter {


    private GroupPresenterToView presenter;
    private OnFragmentInteractionListener mListener;
    private RecyclerView rvGroups;
    private GroupRVAdapter groupRVAdapter;


    private ArrayList<Group> groups;

    public GroupFragment() {
        // Required empty public constructor
    }


    public static GroupFragment newInstance() {
        GroupFragment fragment = new GroupFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        groups = new ArrayList<>();
        presenter = new GroupPresenter(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rvGroups = view.findViewById(R.id.recycler_groups);
        groupRVAdapter = new GroupRVAdapter(groups,this);
        rvGroups.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rvGroups.setAdapter(groupRVAdapter);
        presenter.loadGroups();
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
    public void groupLoaded(List<Group> groups) {
        this.groups.clear();
        this.groups.addAll(groups);
        rvGroups.getAdapter().notifyDataSetChanged();


    }

    public void loadStudents(long groupId){
        mListener.openStudentList(groupId);
    }


    public interface OnFragmentInteractionListener {
        void openStudentList(Long groupId);
    }
}
