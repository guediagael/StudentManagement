package training.android.ui.studentmanagement.models;

import java.util.Date;
import java.util.List;

/**
 * Created by guedi on 6/29/2017.
 */

public abstract class Person {
    private String name;
    private String surname;
    private String middleName;
    private Date dateOfBirth;
    private Long id;
    private List<Contact> contacts ;

    public Person(String name, String surname, String middleName, Date dateOfBirth,
                  List<Contact> contacts) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getId() {
        return id;
    }


    public List<Contact> getContacts() {
        return contacts;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
}
