package com.comp3711.eva.a3717_a1;
/**
 * TERM LIST ACTIVITY CLASS
 * @author Eva YU
 * @version 1.0
 * Date: 10/7/2016.
 *
 * This is the activity that is a list view that represents
 * a list of terms in the CST program at BCIT clicking on a
 * term will lead you to the DataCommCourse Activity.
 */

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TermList extends ListActivity{

    private static final int  TERMS = 4 ; // CONST representing number of terms
    private static final ArrayList<DataCommTerm> terms = new ArrayList<>();
    private ArrayAdapter<String> adapter; // adapter for the listview

    static public void setTerms() //a list of terms available
    {
        for(int i = 0; i < TERMS; ++i )
        {
            terms.add(new DataCommTerm(i));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        setTerms();

        adapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1);

        for(int i = 0; i < TERMS; ++i )
        {
            adapter.add(terms.get(i).getTermString());
        }

        setListAdapter(adapter);
    }

    /**
     * The Action that will bring user to CourseList Activity
     *
     * @param listView the list view
     * @param v        the view selected
     * @param pos      the position of the list clicked
     * @param id       the id as required by the parent class
     */
    @Override
    protected void onListItemClick(ListView listView, View v, int pos, long id)
    {
        super.onListItemClick(listView, v, pos, id);

        Intent intent = new Intent(this, CourseList.class);
        intent.putExtra("SelectedDataCommTerm", terms.get(pos));
        startActivity(intent);
    }

}
