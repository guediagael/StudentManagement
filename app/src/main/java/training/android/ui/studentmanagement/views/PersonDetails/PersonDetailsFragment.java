package training.android.ui.studentmanagement.views.PersonDetails;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.models.Contact;
import training.android.ui.studentmanagement.presenters.PersonDetailsPresenter;
import training.android.ui.studentmanagement.presenters.PersonDetailsPresenterToView;
import training.android.ui.studentmanagement.views.PersonContactRVAdapter;
import training.android.ui.studentmanagement.views.journal.JournalRVAdapter;


public class PersonDetailsFragment extends PersonDetailsViewToPresenter{

    private static final String ARG_PERSON_ID = "personId";
    private static final String ARG_GROUP_ID = "groupId";

    private long mPersonID,mGroupID;
    private RecyclerView rvContacts;
    private RecyclerView rvAttendance;
    private List<Contact> mContacts;
    private Map<String,Boolean> mAttandance;
    private TextView tvName, tvLastName, tvMiddleName,tvGroupid;
    private OnFragmentInteractionListener mListener;
    private PersonDetailsPresenterToView mPresenterToView;

    public PersonDetailsFragment() {
        // Required empty public constructor
    }


    public static PersonDetailsFragment newInstance(long personID, @Nullable Long groupId) {
        PersonDetailsFragment fragment = new PersonDetailsFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PERSON_ID, personID);
        try {
            args.putLong(ARG_GROUP_ID,groupId);

        }catch (NullPointerException e){
            Log.d("PersonDetailsFragment", e.getMessage());
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPersonID = getArguments().getLong(ARG_PERSON_ID);
            mGroupID = getArguments().getLong(ARG_GROUP_ID);
        }

        mPresenterToView = new PersonDetailsPresenter(this);
        mAttandance = new HashMap<>();
        mContacts = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tvGroupid = view.findViewById(R.id.text_details_group_id);
        tvGroupid.setText(String.valueOf(mPersonID));
        tvName = view.findViewById(R.id.text_details_person_name);
        tvLastName = view.findViewById(R.id.text_details_person_last_name);
        tvMiddleName = view.findViewById(R.id.text_details_person_middle_name);
        rvContacts =view.findViewById(R.id.recycler_contacts_profile);
        rvAttendance = view.findViewById(R.id.recycler_attendance_profile);

        rvContacts.setAdapter(new PersonContactRVAdapter(mContacts));
        rvAttendance.setAdapter(new JournalRVAdapter(mAttandance));
        rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAttendance.setLayoutManager(new LinearLayoutManager(getActivity()));

        mPresenterToView.getDetails(mPersonID,mGroupID);
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
    public void nameLoaded(String name, String surname, String lastName) {
        tvName.setText(name);
        tvLastName.setText(lastName);
        tvMiddleName.setText(surname);
    }

    @Override
    public void contactLoaded(List<Contact> contacts) {
        mContacts.clear();
        mContacts.addAll(contacts);
        rvContacts.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void attendanceLoaded(Map<String, Boolean> attendances) {
        mAttandance.clear();
        mAttandance.putAll(attendances);
        rvAttendance.getAdapter().notifyDataSetChanged();
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
