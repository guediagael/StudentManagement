package training.android.ui.studentmanagement.views.journal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import training.android.ui.studentmanagement.R;

public class JournalActivity extends AppCompatActivity {

    private final int TAG_JOURNAL = 1;
    private long mStudentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        mStudentId = getIntent().getExtras().getLong("studentID",0);
        Log.d("JournalActivity",String.valueOf(mStudentId));
        loadFragment(TAG_JOURNAL);
    }

    private void loadFragment(int tag){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (tag==1){
            Fragment fragment = JournalFragment.newInstance(mStudentId);
            transaction.add(R.id.frame_journal,fragment,String.valueOf(tag));
            transaction.commit();
        }
    }
}


