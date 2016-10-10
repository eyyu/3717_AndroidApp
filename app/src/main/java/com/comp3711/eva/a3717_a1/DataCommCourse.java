package com.comp3711.eva.a3717_a1;

import java.io.Serializable;

/**
 *
 * DATA COMM COURSE CLASS.
 * @author Eva YU
 * @version 1.0
 * Date: 10/7/2016.
 *
 *
 * This class represents a single course and contains the information
 * of the course along with the title of the course
 */

public class DataCommCourse implements Serializable {

    //ctor that instantiates an empty DataCommCourse
    public DataCommCourse()
    {
        courseTitle = null;
        courseBlurb = null;
    }

    //ctor that stores the course title and blurb)
    public DataCommCourse(String cTitle, String cBlurb)
    {
        courseTitle = cTitle.toUpperCase();
        courseBlurb = cBlurb;
    }


    public String getCourseTitle()
    {
        return courseTitle;
    }

    public String getCourseBlurb()
    {
        return courseBlurb;
    }

    public void setCourseTitle(String t)
    {
        courseTitle = t;
    }

    public void setCourseBlurb(String b)
    {
        courseBlurb = b.toUpperCase();
    }

    private String courseTitle; // stores the Title of the course e.g: "COMP 1510"
    private String courseBlurb; // stores the information of the blurb

}
