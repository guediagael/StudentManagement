package training.android.ui.studentmanagement.models;

import java.util.Date;
import java.util.List;

/**
 * Created by guedi on 6/29/2017.
 */

public class Curator extends Person {
    private Long id;
    public Curator(String name, String surname, String middleName, Date dateOfBirth, List<Contact> contacts, Long id) {
        super(name, surname, middleName, dateOfBirth, contacts);
        this.id= id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Curator curator = (Curator) o;

        return id.equals(curator.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Curator{" +
                "name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", middleName='" + super.getMiddleName() + '\'' +
                ", dateOfBirth=" + super.getDateOfBirth() +
                ", id=" + id +
                ", contacts=" + super.getContacts() +
                '}';
    }
}
