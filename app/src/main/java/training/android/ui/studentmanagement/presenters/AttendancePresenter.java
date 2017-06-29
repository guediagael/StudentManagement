package training.android.ui.studentmanagement.presenters;

import training.android.ui.studentmanagement.models.Data;
import training.android.ui.studentmanagement.views.PersonDetails.AttendanceViewToPresenter;

/**
 * Created by guedi on 6/29/2017.
 */

public class AttendancePresenter extends BasePresenter implements AttendancePresenterToView {
    private AttendanceViewToPresenter view;

    public AttendancePresenter(AttendanceViewToPresenter fragment) {
        this.view = fragment;
    }

    @Override
    void onFailure(String err) {

    }

    @Override
    public void getInfo(long studentId) {

        view.journalLoaded(Data.getAttendance(studentId));
    }
}
