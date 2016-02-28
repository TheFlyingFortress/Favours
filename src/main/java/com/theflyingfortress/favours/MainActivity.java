package com.theflyingfortress.favours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import com.facebook.FacebookSdk;
//import com.facebook.appevents.AppEventsLogger;

public class MainActivity extends Activity {

    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

	@Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        
        /*
         * create a new favour
         */
        final Button newFavour = (Button) findViewById(R.id.newFavour);
        newFavour.setText("Create Request");
        newFavour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, RequestActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        
        /*
         * list all available favours
         */
        final Button listFavours = (Button) findViewById(R.id.listFavours);
        listFavours.setText("List Requests");
        listFavours.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ListActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// Logs 'install' and 'app activate' App Events.
		//AppEventsLogger.activateApp(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// Logs 'app deactivate' App Event.
		//AppEventsLogger.deactivateApp(this);
	}

    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            info.setText(
                            "User ID: "
                            + loginResult.getAccessToken().getUserId()
                            + "\n" +
                            "Auth Token: "
                            + loginResult.getAccessToken().getToken()
            );
        }

        @Override
        public void onCancel() {
            info.setText("Login attempt canceled.");
        }

        @Override
        public void onError(FacebookException e) {
            info.setText("Login attempt failed.");
        }
    });

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
