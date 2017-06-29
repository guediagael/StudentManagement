package training.android.ui.studentmanagement.views.PersonDetails;

import java.util.List;
import java.util.Map;

import training.android.ui.studentmanagement.views.BaseFragment;

/**
 * Created by guedi on 6/29/2017.
 */

public abstract class AttendanceViewToPresenter  extends BaseFragment{

    public abstract void journalLoaded(Map<String,Boolean> journal);
}
