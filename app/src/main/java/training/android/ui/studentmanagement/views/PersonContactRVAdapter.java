package training.android.ui.studentmanagement.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.models.Contact;
import training.android.ui.studentmanagement.models.ContactType;
import training.android.ui.studentmanagement.views.journal.JournalViewHolder;

/**
 * Created by guedi on 6/29/2017.
 */

public class PersonContactRVAdapter extends RecyclerView.Adapter<JournalViewHolder> {
    private List<Contact> contacts;

    public PersonContactRVAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public JournalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_journal,parent,false);
        return new JournalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JournalViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        String text = contact.getValue();
        switch (contact.getContactType()){
            case PHONE:
                holder.setData(text,R.drawable.ic_phone_black);
                break;
            case VK:
                holder.setData(text,R.drawable.ic_vk);
                break;
            case TELEGRAM:
                holder.setData(text,R.drawable.ic_telegram);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
