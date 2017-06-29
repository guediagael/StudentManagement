package training.android.ui.studentmanagement.views.group;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.models.Group;

/**
 * Created by guedi on 6/28/2017.
 */

public class GroupRVAdapter extends RecyclerView.Adapter<GroupViewHolder>{

    private List<Group> groups;
    private GroupFragment fragment;

    public GroupRVAdapter(List<Group> groups, GroupFragment groupFragment) {
        this.groups = groups;
        fragment= groupFragment;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_group,parent,false);
        return new GroupViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        final Group group = groups.get(position);
        holder.applyData(group.getName(),group.getGroupID());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.loadStudents(group.getGroupID());
            }
        });


    }






    @Override
    public int getItemCount() {
        return groups.size();
    }


}
