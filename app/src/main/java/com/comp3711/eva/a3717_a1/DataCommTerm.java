package com.comp3711.eva.a3717_a1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Eva on 10/7/2016.
 */

public class DataCommTerm implements Serializable {
    /**
     * The contructor for this class
     * @param t  int representing the term value in the array (t - 1)
     */
    public DataCommTerm(int t){
        termStr = "Term " + ( t + 1) ;
        termNo = t + 1;
    }

    public String getTermString()
    {
        return termStr;
    }

    public int getTermNum()
    {
        return termNo;
    }
    public void addToTermCourseList( DataCommCourse course )
    {
        termCourseList.add(course);
    }

    private static final int COURSES_PER_TERM = 7;

    private int                         termNo;
    private String                      termStr;
    private ArrayList<DataCommCourse>   termCourseList;



}
