package com.example.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    Context ct;
    List<Student> list;

    public DataAdapter(MainActivity mainActivity, List<Student> studentList) {
        ct=mainActivity;
        list=studentList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ct).inflate(R.layout.rowdesign,parent,false);
        return new DataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
    Student student=list.get(position);
    holder.name.setText(student.getName());
    holder.rollnumber.setText(student.getRollnumer());
    holder.phone.setText(student.getPhonenumber());
    holder.mail.setText(student.getMailId());
    holder.gender.setText(student.getGender());
    holder.languade.setText(student.getLanguage());
    holder.department.setText(student.getDepartment());
    holder.delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity.dataBase.myDao().deleteStudent(student);
        }
    });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView name,rollnumber,phone,mail,languade,gender,department;
        ImageView update,delete;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            rollnumber=itemView.findViewById(R.id.rm);
            phone=itemView.findViewById(R.id.ph);
            mail=itemView.findViewById(R.id.maileid);
            gender=itemView.findViewById(R.id.g);
            languade=itemView.findViewById(R.id.lg);
            department=itemView.findViewById(R.id.dm);
        }
    }
}
