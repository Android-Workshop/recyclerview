package com.workshop.recyclerview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rohitjain on 24/12/15.
 */
public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Student> studentList;
    private Context context;

    public StudentAdapter(List<Student> list, Context context){
        studentList =list;
        this.context = context;

    }


    @Override
    public StudentAdapter.StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null);
        StudentHolder rcv = new StudentHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof StudentHolder) {
            StudentHolder regionHolder = (StudentHolder) holder;
            Student studentObject = studentList.get(position);
            regionHolder.txt_name.setText(studentObject.getName());
            regionHolder.txt_roll_no.setText(studentObject.getRollNumber()+"");
            if(studentObject.isGender())
            regionHolder.dp.setImageResource(R.drawable.male);
            else
                regionHolder.dp.setImageResource(R.drawable.female);
            regionHolder.view.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        if(studentList == null)
            return 0;
        return studentList.size();
    }

    class StudentHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView txt_name;
        private TextView txt_roll_no;
        private ImageView dp;
        public StudentHolder(View itemView) {
            super(itemView);
            txt_name = (TextView)itemView.findViewById(R.id.name);
            txt_roll_no = (TextView)itemView.findViewById(R.id.rollno);
            dp = (ImageView)itemView.findViewById(R.id.dp);
            view = itemView;
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    final int position = (int)view.getTag();
                    final AlertDialog.Builder ab = new AlertDialog.Builder(context);
                    ab.setMessage("Are you sure?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            studentList.remove(position);
                            notifyDataSetChanged();
                        }
                    })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            }).show();
                }
            });
        }
    }


    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:

                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };

    public void setRegionList(List<Student> list) {
        this.studentList = list;
    }

    public Student getItem(int position) {
        return this.studentList.get(position);
    }
}
