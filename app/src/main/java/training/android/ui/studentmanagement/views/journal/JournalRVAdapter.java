package training.android.ui.studentmanagement.views.journal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import training.android.ui.studentmanagement.R;

/**
 * Created by guedi on 6/29/2017.
 */

public class JournalRVAdapter extends RecyclerView.Adapter<JournalViewHolder> {

    private Map<String,Boolean> attendances;
    private List<String> subjects;

    public JournalRVAdapter(Map<String, Boolean> attendances) {
        this.attendances = attendances;
        subjects = new ArrayList<>(attendances.keySet());
    }

    @Override
    public JournalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_journal,parent,false);
        return new JournalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JournalViewHolder holder, int position) {
        String text =subjects.get(position);
        if (attendances.get(text))
            holder.setData(text,R.drawable.ic_check);
        else
            holder.setData(text,R.drawable.ic_close);
    }

    @Override
    public int getItemCount() {

        return subjects.size();
    }
}
