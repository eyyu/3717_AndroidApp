package com.comp3711.eva.a3717_a1;

/**
 * COURSE LIST ACTIVITY CLASS
 * @author Eva YU
 * @version 1.0
 * Date: 10/7/2016.
 *
 * This activity takes the DataCommTerm object generated from
 * the previous activity and generates a list of courses
 * that corresponds to the term selected. The information
 * is generated from a local JSON file
 *
 */
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CourseList extends ListActivity {

    private DataCommTerm term;
    private ArrayList<DataCommCourse> DCCourse_List;
    private ArrayAdapter<String> adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        term = (DataCommTerm) (getIntent().getSerializableExtra("SelectedDataCommTerm"));

        int termno = term.getTermNum();
        loadJSONFromAsset(termno);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        for (int i = 0; i < DCCourse_List.size(); ++i) {
            adapter.add(DCCourse_List.get(i).getCourseTitle());
        }

        setListAdapter(adapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * The Action that will bring user to CourseInfo Activity
     *
     * @param listView the list view
     * @param v        the view selected
     * @param pos      the position of the list clicked
     * @param id       the id as required by the parent class
     */
    @Override
    protected void onListItemClick(ListView listView, View v, int pos, long id) {
        super.onListItemClick(listView, v, pos, id);

        Intent intent = new Intent(this, CourseInfo.class);
        intent.putExtra("SelectedDataCommCourse", DCCourse_List.get(pos));
        startActivity(intent);

    }

    /**
     * JASON formatter for static json file in assets folder
     * Will parse the json object to set the array list of course info
     * objects relating to the term
     *
     * @param termNo    the term selected
     * @return  an array list of DataCommCourses
     *
     */
    public ArrayList<DataCommCourse> loadJSONFromAsset(int termNo) {
        String termKey = "term" + termNo;
        DCCourse_List = new ArrayList<>();
        String json = null;

        try {
            InputStream is = getAssets().open("courses_info.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        try {
            JSONArray jsonTermsCoursesArr = new JSONArray(json);
            JSONObject obj = jsonTermsCoursesArr.getJSONObject(termNo - 1);
            JSONArray m_jArray = obj.getJSONArray(termKey);

            for (int i = 0; i < m_jArray.length(); i++) {
                JSONObject jsonOb_inside = m_jArray.getJSONObject(i);
                DataCommCourse course = new DataCommCourse();
                course.setCourseTitle(jsonOb_inside.getString("course_number"));
                course.setCourseBlurb(jsonOb_inside.getString("course_details"));
                DCCourse_List.add(course);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return DCCourse_List;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("CourseList Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
