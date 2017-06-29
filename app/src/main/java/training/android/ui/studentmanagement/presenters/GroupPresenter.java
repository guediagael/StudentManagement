package training.android.ui.studentmanagement.presenters;

import java.util.List;

import training.android.ui.studentmanagement.models.Data;
import training.android.ui.studentmanagement.models.Group;
import training.android.ui.studentmanagement.views.group.GroupFragment;
import training.android.ui.studentmanagement.views.group.GroupViewToPresenter;

/**
 * Created by guedi on 6/29/2017.
 */

public class GroupPresenter extends BasePresenter implements GroupPresenterToView{

    private GroupViewToPresenter view ;

    public GroupPresenter(GroupFragment fragment) {
        view = fragment;
    }

    @Override
    void onFailure(String err) {

    }

    @Override
    public void loadGroups() {
        view.groupLoaded(Data.groups);
    }



}
