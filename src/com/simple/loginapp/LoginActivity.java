package com.simple.loginapp;

import com.simple.loginInterfac.AlertDialogMgr;
import com.simple.loginInterfac.SessionMgr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	// Email, password edittext
	EditText txtUsername, txtPassword;
	CheckBox isChecked;

	// login button
	Button btnLogin;
	SessionMgr session;
	AlertDialogMgr alert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// Session Manager
		session = new SessionMgr(getApplicationContext());
		alert = new AlertDialogMgr();

		// Email, Password input text
		txtUsername = (EditText) findViewById(R.id.txtUsername);
		txtPassword = (EditText) findViewById(R.id.txtPassword);
		isChecked=(CheckBox)findViewById(R.id.checkBox1);

		if(session.keepMeLoggedIn()){

			Toast.makeText(getApplicationContext(),
					"You are Logged in: ", Toast.LENGTH_LONG)
					.show();
			// Staring MainActivity
			Intent i = new Intent(getApplicationContext(),MainActivity.class);
			startActivity(i);
			finish();
		}
		// Login button
		btnLogin = (Button) findViewById(R.id.btnLogin);

		// Login button click event
		btnLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get username, password from EditText
				String username = txtUsername.getText().toString();
				String password = txtPassword.getText().toString();
				boolean keepMeLoggedIn=isChecked.isChecked();

				// Check if username, password is filled
				if (username.trim().length() > 0
						&& password.trim().length() > 0) {
					// For testing puspose username, password is checked with
					// sample data
					// username = test
					// password = test
					//if (username.equals(username.trim()) && password.equals(password.trim())) {
					
					
					
					if (session.login(username,password )) {

						// Creating user login session
						// For testing i am stroing name, email as follow
						// Use user real data
						session.createLoginSession(username, keepMeLoggedIn); 
						
						// Staring MainActivity
						Intent i = new Intent(getApplicationContext(),MainActivity.class);
						startActivity(i);
						finish();
					} else {
						// username / password doesn't match
						alert.showAlertDialog(LoginActivity.this,
								"Login failed..",
								"Username/Password is incorrect", false);
					}
				} else {
					// user didn't entered username or password
					// Show alert asking him to enter the details
					alert.showAlertDialog(LoginActivity.this, "Login failed..",
							"Please enter username and password", false);
				}

			}
		});
	}
	public void signup(View v){
		Intent e = new Intent(LoginActivity.this,SignupActivity.class);
		startActivity(e);
		finish();
		
	}

}
