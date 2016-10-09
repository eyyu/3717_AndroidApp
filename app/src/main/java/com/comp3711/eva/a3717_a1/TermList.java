package com.comp3711.eva.a3717_a1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TermList extends ListActivity{

    private static final int  TERMS = 4 ;
    private TextView content;
    private static final ArrayList<DataCommTerm> terms = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    static public void setTerms()
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
        content = (TextView) findViewById(R.id.output);
        adapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1);

        for(int i = 0; i < TERMS; ++i )
        {
            adapter.add(terms.get(i).getTermString());
        }

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView listView, View v, int pos, long id)
    {
        super.onListItemClick(listView, v, pos, id);
        String itemValue = (String) listView.getItemAtPosition(pos);
        // For testing only!

        content.setText("Click: \n Position: "
                + pos
                + "\nListItem:" + itemValue);

        Intent intent = new Intent(this, CourseList.class);
        intent.putExtra("SelectedDataCommTerm", terms.get(pos));
        startActivity(intent);
    }

}
