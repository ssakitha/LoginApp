package com.simple.loginapp;

import com.simple.loginInterfac.AlertDialogMgr;
import com.simple.loginInterfac.SessionMgr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends Activity {

	EditText tusername, tpassword, trpassword;
	SessionMgr session;
	AlertDialogMgr alert;
	Button btnsignup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		session = new SessionMgr(getApplicationContext());
		alert = new AlertDialogMgr();
		tusername = (EditText) findViewById(R.id.username);
		tpassword = (EditText) findViewById(R.id.password);
		trpassword = (EditText) findViewById(R.id.rpassword);
		btnsignup = (Button) findViewById(R.id.signup);

		btnsignup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String username = tusername.getText().toString();
				String password = tpassword.getText().toString();
				String rpassword = trpassword.getText().toString();
				Log.v(password, "button clicked");
				if (password.equals(rpassword)){
					Log.v(password, password);
					session.createSignupSession(username, password);
					Log.v(password, "session created");
					Intent i = new Intent(getApplicationContext(),
							LoginActivity.class);
					startActivity(i);
					finish();
				} else {
					Log.v("Alert", "button clicked");
					alert.showAlertDialog(SignupActivity.this,
							"Signup failed.",
							"Password/ReenteredPassword is not matching", false);
				}

			}
		});

	}
}
