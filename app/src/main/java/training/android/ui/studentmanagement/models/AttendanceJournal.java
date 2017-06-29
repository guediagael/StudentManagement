package training.android.ui.studentmanagement.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guedi on 6/22/2017.
 */

public class AttendanceJournal {
    private Map<Subject,List<Map<Date,List<Student>>> > studentAttendances;
    private Long groupID;

    public AttendanceJournal(Long groupID) {
        this.studentAttendances = new HashMap<>();
        this.groupID = groupID;
    }




    public Map<Subject,List<Map<Date,List<Student>>>> getStudentAttendances() {
        return studentAttendances;
    }



    public Long getGroupID() {
        return groupID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttendanceJournal)) return false;

        AttendanceJournal that = (AttendanceJournal) o;

        if (!getStudentAttendances().equals(that.getStudentAttendances())) return false;
        return getGroupID().equals(that.getGroupID());
    }

    @Override
    public int hashCode() {
        int result = getStudentAttendances().hashCode();
        result = 31 * result + getGroupID().hashCode();
        return result;
    }
}
