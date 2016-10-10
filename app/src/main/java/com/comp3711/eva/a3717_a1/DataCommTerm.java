package com.comp3711.eva.a3717_a1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * DATA COMM TERM CLASS.
 * @author Eva YU
 * @version 1.0
 * Date: 10/7/2016.
 *
 *
 * This class represents a single term in the datacomm option
 * of CST and contains the information of the term number
 * and an array of courses this term has
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

    private int                         termNo; // The term (1 -4)
    private String                      termStr; // the string that titles of the course
    private ArrayList<DataCommCourse>   termCourseList; // the list of DataComm Course objects
                                                        // in the term

}
