package com.theflyingfortress.favours;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewFragment extends Fragment{
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		System.out.println("heyyyyyy");
        return inflater.inflate(R.layout.fragment_view, container, false);
	}
/*
	@Override
	public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        
        Intent intent = getIntent();

        // get name and details
        String contactName = intent.getStringExtra("key");
        ArrayList<String> details = intent.getStringArrayListExtra("details");

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(contactName);

        TextView company = (TextView) findViewById(R.id.company);
        company.setText(details.get(0));

        TextView birthdate = (TextView) findViewById(R.id.birthdate);
        birthdate.setText(details.get(1));

        TextView workPhone = (TextView) findViewById(R.id.workPhone);
        workPhone.setText(details.get(2));

        TextView homePhone = (TextView) findViewById(R.id.homePhone);
        homePhone.setText(details.get(3));

        TextView mobilePhone = (TextView) findViewById(R.id.mobilePhone);
        mobilePhone.setText(details.get(4));

        final Button button = (Button) findViewById(R.id.goBack);
        button.setOnClickListener(new View.OnClickListener() {

            // go back to the list of contacts
            public void onClick(View v) {

                ContactActivity.this.finish();
            }
        });

    }
    */

}
