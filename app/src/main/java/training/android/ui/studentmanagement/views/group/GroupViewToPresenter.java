package training.android.ui.studentmanagement.views.group;

import java.util.List;

import training.android.ui.studentmanagement.models.Group;
import training.android.ui.studentmanagement.views.BaseFragment;

/**
 * Created by guedi on 6/29/2017.
 */

public abstract class GroupViewToPresenter extends BaseFragment{

    abstract public void groupLoaded(List<Group> groups);
}
