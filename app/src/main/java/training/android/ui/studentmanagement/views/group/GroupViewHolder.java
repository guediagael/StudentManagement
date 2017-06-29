package training.android.ui.studentmanagement.views.group;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import training.android.ui.studentmanagement.R;

/**
 * Created by guedi on 6/28/2017.
 */

 class GroupViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName, tvId;
    public GroupViewHolder(View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.text_group_name_raw);
        tvId = itemView.findViewById(R.id.text_group_id_raw);
    }

    public void applyData(String groupName, Long id){
        tvName.setText(groupName);
        tvId.setText(String.valueOf(id));
    }
}
