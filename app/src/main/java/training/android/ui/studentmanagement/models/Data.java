package training.android.ui.studentmanagement.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guedi on 6/29/2017.
 */

public class Data {
    public static final ArrayList<Group> groups = getGroups();



    private static ArrayList<Group> getGroups(){
        ArrayList<Group> groups = new ArrayList<>();
        for (int i=0; i<=15;i++){
            Semester s ;
            if (i%2==0)
                s = Semester.FALL;
            else s = Semester.SPRING;
            Group group = new Group((long)i,s,(short) 1);
            groups.add(group);
        }
        return groups;
    }


    public static ArrayList<Student> getStudents(long groupId){
        ArrayList<Student> students = new ArrayList<>();
        Contact vk = new Contact(ContactType.VK,"Vk");
        Contact phone = new Contact(ContactType.PHONE, "89870052640");
        Contact telegram = new Contact(ContactType.TELEGRAM,"@gaelGuedia");

        for (int i=0;i <20;i++){
            ArrayList<Contact> contacts = new ArrayList<>();
            contacts.add(vk);
            contacts.add(phone);
            contacts.add(telegram);
            Student student = new Student("student"+i,i+"'s  Surname",i+"'s Middlename", new Date(),
                    groupId,contacts,(long)i);
            students.add(student);
        }

        return students;
    }

    public static Map<String,Boolean> getAttendance(long studentId){
        Map<String,Boolean> attendances = new HashMap<>();
        for (int i=0; i<=8;i++){
            if (i>0 && i%2==0 && i!=6)
                attendances.put(Subject.ANDROID.toString(),true);
            else if (i>0 && i%3==0)
                attendances.put(Subject.CV_CONSULTING.toString(),false);
            else
                attendances.put(Subject.JAVA_ADVANCED.toString(),true);
        }

        return attendances;
    }

    public static List<Contact> getStudentContacts(long groupId, long studentId){
        List<Contact> contacts = new ArrayList<>();
        for (Student student : getStudents(groupId)){
            if (student.getId()==studentId){
                for (Contact contact :student.getContacts())
                    contacts.add(contact);
                break;
            }
        }
        return contacts;
    }

    public static Student getInfo(long id, long groupID) throws NullPointerException{
        for (Student student : getStudents(groupID)){
            if (student.getId()==id)
                return student;
        }
        return null;
    }

    public static Curator getInfo(long curatorId){
        return null;
    }
}
