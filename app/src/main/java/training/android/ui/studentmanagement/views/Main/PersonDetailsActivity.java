package training.android.ui.studentmanagement.views.Main;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.views.PersonDetails.PersonDetailsFragment;
import training.android.ui.studentmanagement.views.student.StudentJournalFragment;

public class PersonDetailsActivity extends AppCompatActivity implements
        PersonDetailsFragment.OnFragmentInteractionListener{
    private static final String ARG_PERSON_ID = "personId";
    private static final String ARG_GROUP_ID = "groupId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        long personId = getIntent().getLongExtra(ARG_PERSON_ID,0);
        Log.e("PersonDetailsActivity",String.valueOf(personId));
        long groupId = getIntent().getLongExtra(ARG_GROUP_ID,0);
        Log.e("PersonDetailsActivity",String.valueOf(groupId));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //Todo: catch NPE for curator login
        transaction.add(R.id.frame_person_details, PersonDetailsFragment.newInstance(personId,groupId));
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
