package com.comp3711.eva.a3717_a1;

import java.io.Serializable;

/**
 * Created by Eva on 10/7/2016.
 */

public class DataCommCourse implements Serializable {

    public DataCommCourse()
    {
        courseTitle = null;
        courseBlurb = null;
    }


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

    private String courseTitle;
    private String courseBlurb;

}
