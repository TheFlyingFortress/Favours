package com.theflyingfortress.favours;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Create a new request and save to JSON string
 */
public class RequestActivity extends Activity {
	
	int userID = 0;
	int favourID = 0;

	@Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_request);
              
        final EditText taskName = (EditText) findViewById (R.id.editText1);
        final EditText phoneNumber = (EditText) findViewById (R.id.editText2);
        final EditText coffeeStore = (EditText) findViewById (R.id.editText3);
        final EditText userLocation = (EditText) findViewById (R.id.editText4);
        final EditText compensation = (EditText) findViewById (R.id.editText5);
        final EditText comments = (EditText) findViewById (R.id.editText6);
        
        final Button mButton = (Button) findViewById(R.id.button1);  
        
        
        mButton.setOnClickListener(new View.OnClickListener() {
        	
        	@SuppressLint("SimpleDateFormat") public void onClick(View view) {
        		
        		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        		Date date = new Date();
        		String timeNow = (String) dateFormat.format(date);
        		
        		final TimePicker timePicker = (TimePicker) findViewById (R.id.timePicker1);
        		int hour = timePicker.getCurrentHour();
        		int minute = timePicker.getCurrentMinute();
        		
        		String jsonString = null;
        		
        		try {
        			jsonString = new JSONObject()
        				.put("favourID", favourID)
        				.put("userID", userID)
        				.put("title", taskName.getText().toString())
        			    .put("phoneNumber", phoneNumber.getText().toString())
        			    .put("taskLocation", coffeeStore.getText().toString())
        			    .put("timeStart", timeNow)
        			    .put("timeEnd", Integer.toString(hour) + ":" + Integer.toString(minute))
        			    .put("userLocation", userLocation.getText().toString())
        			    .put("reward", compensation.getText().toString())
        			    .put("description", comments.getText().toString())
        			    .put("status", "open").toString();
        			
        		} catch (JSONException e) {
        			e.printStackTrace();
        		}
        		
        		System.out.println("new request: " + jsonString);
        		
        	}
        });       
	}
}