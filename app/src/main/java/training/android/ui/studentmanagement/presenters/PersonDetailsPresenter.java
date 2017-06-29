package training.android.ui.studentmanagement.presenters;

import android.support.annotation.Nullable;
import android.util.Log;

import training.android.ui.studentmanagement.models.Data;
import training.android.ui.studentmanagement.models.Person;
import training.android.ui.studentmanagement.models.Student;
import training.android.ui.studentmanagement.views.PersonDetails.PersonDetailsViewToPresenter;

/**
 * Created by guedi on 6/29/2017.
 */

public class PersonDetailsPresenter implements PersonDetailsPresenterToView {

    private PersonDetailsViewToPresenter viewToPresenter;

    public PersonDetailsPresenter(PersonDetailsViewToPresenter viewToPresenter) {
        this.viewToPresenter = viewToPresenter;
    }



    @Override
    public void getDetails(long personID, long groupId) {
        Person p ;
        try{

            p = Data.getInfo(personID,groupId);
            String name = p.getName();
            String surname= p.getSurname();
            String middlename= p.getMiddleName();

            viewToPresenter.nameLoaded(name,surname,middlename);
            viewToPresenter.contactLoaded(Data.getStudentContacts(groupId,personID));
            viewToPresenter.attendanceLoaded(Data.getAttendance(personID));


       }catch (NullPointerException e){
            Log.d("PersonDetailsPresenter",e.getMessage());
            p = Data.getInfo(personID);
        }

    }
}
