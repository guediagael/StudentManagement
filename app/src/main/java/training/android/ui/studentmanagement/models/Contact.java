package training.android.ui.studentmanagement.models;

/**
 * Created by guedi on 6/22/2017.
 */

public class Contact {

    private ContactType contactType;
    private String value;

    public Contact(ContactType contactType, String value) {
        this.contactType = contactType;
        this.value = value;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        if (this.contactType !=((Contact) o).getContactType()) return false;
        if (this.getValue() !=((Contact)o).getValue()) return false;
        return  true;
    }

    @Override
    public int hashCode() {
        int result = getContactType().hashCode();
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactType=" + contactType +
                ", value='" + value + '\'' +
                '}';
    }
}
