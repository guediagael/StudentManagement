package training.android.ui.studentmanagement.presenters;

import training.android.ui.studentmanagement.models.Data;
import training.android.ui.studentmanagement.views.student.StudentViewToPresenter;

/**
 * Created by guedi on 6/29/2017.
 */

public class StudentPresenter extends BasePresenter implements StudentPresenterToView {

    private StudentViewToPresenter viewToPresenter;

    public StudentPresenter(StudentViewToPresenter viewToPresenter) {
        this.viewToPresenter = viewToPresenter;
    }

    @Override
    void onFailure(String err) {

    }

    @Override
    public void getStudents(long groupId) {
        viewToPresenter.studentsLoaded(Data.getStudents(groupId));
    }
}
