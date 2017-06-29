package training.android.ui.studentmanagement.presenters;

import android.support.annotation.Nullable;

/**
 * Created by guedi on 6/29/2017.
 */

public interface PersonDetailsPresenterToView  {
    void getDetails(long personID, @Nullable long groupId);
}
