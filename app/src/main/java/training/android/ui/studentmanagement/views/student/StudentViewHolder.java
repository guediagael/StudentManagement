package training.android.ui.studentmanagement.views.student;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import training.android.ui.studentmanagement.R;

/**
 * Created by guedi on 6/28/2017.
 */

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName, tvId;
    public StudentViewHolder(View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.text_person_name);
        tvId= itemView.findViewById(R.id.text_person_id);

    }

    public void applyData(String name, String surname, Long id){
        tvName.setText(name+" "+ surname);
        tvId.setText(String.valueOf(id));
    }
}
