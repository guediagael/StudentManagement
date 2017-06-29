package training.android.ui.studentmanagement.views.student;

import java.util.List;

import training.android.ui.studentmanagement.models.Student;
import training.android.ui.studentmanagement.views.BaseFragment;

/**
 * Created by guedi on 6/29/2017.
 */

public abstract class StudentViewToPresenter extends BaseFragment{

    public abstract void studentsLoaded(List<Student> students);
}
