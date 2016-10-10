package com.comp3711.eva.a3717_a1;

/**
 * COURSE INFO ACTIVITY CLASS
 * @author Eva YU
 * @version 1.0
 * Date: 10/7/2016.
 *
 * This activity takes the DataCommCourse Object passed
 * into this activity from the previous activity and
 * retrieves the course information blurb and title
 * to present in the activity textviews.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseInfo extends AppCompatActivity
{
    // This is the DataCommCourse object selected
    private DataCommCourse course;
    // Store the information of the course
    private TextView blurbTextView, titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);

        blurbTextView = (TextView) findViewById(R.id.blurb_text);
        titleTextView = (TextView) findViewById(R.id.title_text);

        course = (DataCommCourse) ( getIntent().getSerializableExtra("SelectedDataCommCourse"));

        titleTextView.setText( course.getCourseTitle() );
        blurbTextView.setText( course.getCourseBlurb() );

    }

}
