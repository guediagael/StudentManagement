package training.android.ui.studentmanagement.views.journal;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import training.android.ui.studentmanagement.R;

/**
 * Created by guedi on 6/29/2017.
 */

public class JournalViewHolder extends RecyclerView.ViewHolder {
    private TextView tvText;
    private ImageView ivIcon;

    public JournalViewHolder(View itemView) {
        super(itemView);
        tvText = itemView.findViewById(R.id.text_contact_type_raw);
        ivIcon = itemView.findViewById(R.id.image_contact_type_raw);
    }

    public void setData(String text, @Nullable Integer resId){
        tvText.setText(text);
        if (resId!=null){
            ivIcon.setImageResource(resId);
        }
    }
}
