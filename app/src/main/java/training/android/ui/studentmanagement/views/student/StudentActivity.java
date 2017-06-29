package training.android.ui.studentmanagement.views.student;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.views.Main.PersonDetailsActivity;

public class StudentActivity extends AppCompatActivity implements StudentsFragment.OnFragmentInteractionListener {

    private final int TAG_STUDENT_LIST = 1;
    private long mGroupID;
    private static final String ARG_PERSON_ID = "personId";
    private static final String ARG_GROUP_ID = "groupId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        loadFragment(TAG_STUDENT_LIST);
        mGroupID = getIntent().getLongExtra("group",0);
        Log.d("StudentActivity",String.valueOf(mGroupID));

    }

    private void loadFragment(int TAG){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (TAG==1){
            Fragment fragment = StudentsFragment.newInstance(mGroupID);
            transaction.add(R.id.frame_students,fragment,String.valueOf(TAG));
            transaction.commit();
        }
    }




    @Override
    public void showStudentDetails(long studentId, @Nullable Long groupId) {
        Intent intent = new Intent(this, PersonDetailsActivity.class);
        intent.putExtra(ARG_GROUP_ID,mGroupID);
        intent.putExtra(ARG_PERSON_ID,studentId);
        startActivity(intent);
    }
}
