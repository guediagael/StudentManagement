package training.android.ui.studentmanagement.views.student;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import training.android.ui.studentmanagement.R;
import training.android.ui.studentmanagement.models.Student;

/**
 * Created by guedi on 6/28/2017.
 */

public class StudentRVAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    private StudentsFragment fragment;
    private List<Student> students;

    public StudentRVAdapter(List<Student> studentList,StudentsFragment studentsFragment) {
        students = studentList;
        fragment = studentsFragment;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_person,parent,false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        final Student student = students.get(position);
        holder.applyData(student.getName(),student.getSurname(),student.getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.showStudent(student.getId());
            }
        });
    }


    @Override
    public int getItemCount() {
        return students.size();
    }


}
