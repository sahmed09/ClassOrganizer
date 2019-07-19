package com.example.classorganizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private String[] classTime,courseName,courseTeacher;

    CustomAdapter(Context context, String[] classTime, String[] courseName, String[] courseTeacher) {
        this.context = context;
        this.classTime = classTime;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
    }

    @Override
    public int getCount() {
        return courseName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample_view,parent,false);
        }

        TextView time = convertView.findViewById(R.id.timeTextView);
        TextView course = convertView.findViewById(R.id.courseName);
        TextView teacher = convertView.findViewById(R.id.courseTeacherName);

        time.setText(classTime[position]);
        course.setText(courseName[position]);
        teacher.setText(courseTeacher[position]);
        return convertView;
    }
}
