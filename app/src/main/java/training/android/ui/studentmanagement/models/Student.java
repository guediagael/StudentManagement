package training.android.ui.studentmanagement.models;

import java.util.Date;
import java.util.List;

/**
 * Created by guedi on 6/22/2017.
 */

public class Student extends Person{

    private Long id;
    private Long groupId;

    public Student(String name, String surname, String middleName, Date dateOfBirth,Long groupId,List<Contact> contacts, Long id) {
        super(name,surname,middleName,dateOfBirth,contacts);
        this.id = id;
        this.groupId = groupId;
    }


    public Long getId() {
        return id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setId(Long id){
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return id != null ? id.equals(student.id) : student.id == null;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", middleName='" + super.getMiddleName() + '\'' +
                ", dateOfBirth=" + super.getDateOfBirth() +
                ", id=" + id +
                ", groupId=" + groupId +
                ", contacts=" + super.getContacts() +
                '}';
    }
}
