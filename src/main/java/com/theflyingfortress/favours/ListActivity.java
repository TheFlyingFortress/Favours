package com.theflyingfortress.favours;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * List all pending favours
 */
public class ListActivity extends Activity {
	
	static JSONObject testJSON = null;

	@Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        ListView mainListView = (ListView) findViewById(R.id.mainListView);
        
        // for testing purpose only
		try {
			testJSON = new JSONObject()
				.put("0", new JSONObject()
					.put("favourID", "0")
					.put("userID", "0")
					.put("title", "Get coffee from Blenz")
				    .put("phoneNumber", "7399920")
				    .put("taskLocation", "Blenz")
				    .put("timeStart", "04:30")
				    .put("timeEnd", "06:20")
				    .put("userLocation", "ICSCS")
				    .put("reward", "$200")
				    .put("description", "use soy milk")
				    .put("status", "open"))
				.put("1",new JSONObject()
					.put("favourID", "1")
					.put("userID", "1")
					.put("title", "Get tea from Starbucks")
				    .put("phoneNumber", "9896410")
				    .put("taskLocation", "Starbucks")
				    .put("timeStart", "05:30")
				    .put("timeEnd", "06:10")
				    .put("userLocation", "Kaiser")
				    .put("reward", "$100")
				    .put("description", "earl grey")
				    .put("status", "open"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> favourNames = new ArrayList<String>();
		
		for (int i = 0; i < testJSON.length(); i++) {
			try {
				JSONObject obj = testJSON.getJSONObject(Integer.toString(i));
				favourNames.add(obj.getString("title"));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, favourNames);

        mainListView.setAdapter(listAdapter);
        
        mainListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long rowID) {

                String title = (String) adapter.getItemAtPosition(position);

                Intent intent = new Intent(ListActivity.this, ViewFragment.class);
                
                

                /*
                intent.putExtra("key", title);

                ArrayList<String> details = new ArrayList<String>();

                for (int i = 0; i < testJSON.length(); i++) {

                	JSONObject obj;
					try {
						obj = testJSON.getJSONObject(Integer.toString(i));
						
						if (title == obj.getString("title")) {

						    details = new ArrayList<String>();

								details.add(obj.getString("phoneNumber"));
						}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }

                // pass in details as extra parameters
                intent.putStringArrayListExtra("details", details);

*/
                // start ContactActivity
                startActivity(intent);
                
            }
        });
		
    }
}
