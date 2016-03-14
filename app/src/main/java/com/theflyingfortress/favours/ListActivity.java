package com.theflyingfortress.favours;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * List all pending favours
 */
public class ListActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        ListView mainListView = (ListView) findViewById(R.id.mainListView);
    }
}
