package com.comp3711.eva.a3717_a1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseInfo extends AppCompatActivity {
    private DataCommCourse course;
    private TextView blurbTextView, titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);

        blurbTextView = (TextView) findViewById(R.id.blurb_text);
        titleTextView = (TextView) findViewById(R.id.title_text);

        course = (DataCommCourse) ( getIntent().getSerializableExtra("SelectedDataCommCourse"));

        titleTextView.setText( course.getCourseTitle() );
        blurbTextView.setText( course.getCourseBlurb() );

    }

}
