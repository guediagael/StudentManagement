package training.android.ui.studentmanagement.views.PersonDetails;

import java.util.List;
import java.util.Map;

import training.android.ui.studentmanagement.models.Contact;
import training.android.ui.studentmanagement.views.BaseFragment;

/**
 * Created by guedi on 6/29/2017.
 */

public abstract class PersonDetailsViewToPresenter extends BaseFragment {

    public abstract void nameLoaded(String name, String surname, String lastName);
    public abstract void contactLoaded(List<Contact> contacts);
    public abstract void attendanceLoaded(Map<String,Boolean> attendances);
}
