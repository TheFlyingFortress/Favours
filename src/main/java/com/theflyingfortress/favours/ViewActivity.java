package com.theflyingfortress.favours;

import java.util.ArrayList;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view);
        Intent intent = getIntent();

        String contactName = intent.getStringExtra("key");
        ArrayList<String> details = intent.getStringArrayListExtra("details");

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(contactName);

        JSONObject testJSON = details.get(0);

        TextView company = (TextView) findViewById(R.id.company);
        company.setText(details.get(0));

        final Button button = (Button) findViewById(R.id.goBack);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                ViewActivity.this.finish();
            }
        });
    }
}
