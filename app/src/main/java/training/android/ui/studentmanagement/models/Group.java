package training.android.ui.studentmanagement.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guedi on 6/22/2017.
 */

public class Group {
    private Long groupID;
    private Semester semester;
    private List<Student> students;
    private Short course;


    public Group(Long groupID,Semester semester,Short course) {
        this.groupID = groupID;
        this.semester = semester;
        this.students = new ArrayList<>();
        this.course = course;
    }

    public Semester getSemester() {
        return semester;
    }


    public String getName(){
        String name = String.valueOf(semester)+" "+String.valueOf(course)+ " "
                + String.valueOf(groupID);
        return name;
    }
    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Short getCourse() {
        return course;
    }


    public Long getGroupID() {
        return groupID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        return getGroupID().equals(group.getGroupID()) && getSemester()
                == group.getSemester() && getCourse().equals(group.getCourse());
    }

    @Override
    public int hashCode() {
        int result = getGroupID().hashCode();
        result = 31 * result + getSemester().hashCode();
        result = 31 * result + getCourse().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", semester=" + semester +
                ", course=" + course +
                '}';
    }
}
