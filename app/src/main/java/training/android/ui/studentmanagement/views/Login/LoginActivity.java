package training.android.ui.studentmanagement.views.Login;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.views.Main.PersonDetailsActivity;

public class LoginActivity extends AppCompatActivity
        implements LoginFragment.OnFragmentInteractionListener,
        RegisterFragment.OnFragmentInteractionListener {

    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();



    }

    @Override
    public void onFragmentInteraction(int buttonId, @Nullable  Uri uri) {

        switch (buttonId){
            case R.id.bOk :
                Intent i = new Intent(this,PersonDetailsActivity.class);
                startActivity(i);
                break;
            case R.id.bOkReg:
                Intent intent = new Intent(this,PersonDetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.bLogin:
                fragmentTransaction.replace(R.id.flLoginContainer,LoginFragment.newInstance());
                fragmentTransaction.commit();
                break;
            case R.id.bReg:
                fragmentTransaction.replace(R.id.flLoginContainer,RegisterFragment.newInstance());
                fragmentTransaction.commit();
                break;
        }

    }
}
