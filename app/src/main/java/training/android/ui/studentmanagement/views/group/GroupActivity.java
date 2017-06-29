package training.android.ui.studentmanagement.views.group;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.models.Student;
import training.android.ui.studentmanagement.views.Main.PersonDetailsActivity;
import training.android.ui.studentmanagement.views.group.GroupFragment;
import training.android.ui.studentmanagement.views.student.StudentActivity;
import training.android.ui.studentmanagement.views.student.StudentsFragment;

public class GroupActivity extends AppCompatActivity implements
        GroupFragment.OnFragmentInteractionListener, StudentsFragment.OnFragmentInteractionListener {

    private final int TAG_FRAGMENT_GROUP_LIST=1;
    private final int TAG_FRAGMENT_STUDENT = 2;
    private static final String ARG_PERSON_ID = "personId";
    private static final String ARG_GROUP_ID = "groupId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        loadFragment(TAG_FRAGMENT_GROUP_LIST);
    }

    private void loadFragment(int tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (tag==1){
            GroupFragment fragment = GroupFragment.newInstance();
            transaction.add(R.id.frame_group,fragment,String.valueOf(tag));
            transaction.commit();
        }
    }


    @Override
    public void openStudentList(Long groupId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = StudentsFragment.newInstance(groupId);
        transaction.replace(R.id.frame_group,fragment,String.valueOf(TAG_FRAGMENT_STUDENT));
        transaction.commit();
    }


    @Override
    public void showStudentDetails(long studentId, @Nullable Long groupID) {
        Intent intent = new Intent(this, PersonDetailsActivity.class);
        //TODO:catch NPE
        intent.putExtra(ARG_GROUP_ID,groupID);
        intent.putExtra(ARG_PERSON_ID,studentId);
        startActivity(intent);
    }
}
