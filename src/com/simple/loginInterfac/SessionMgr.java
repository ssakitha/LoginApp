package com.simple.loginInterfac;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
 
public class SessionMgr {
    // Shared Preferences
    SharedPreferences pref;
     
    // Editor for Shared preferences
    Editor editor;
     
    // Context
    Context context;
     
    // Shared pref mode
    int PRIVATE_MODE = 0;
     
    // Sharedpref file name
    private static final String PREF_NAME = "user";
     
    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
     
    // User name (make variable public to access from outside)
    public static final String USER_NAME = "name";
     
    // Email address (make variable public to access from outside)
    public static final String KEEP_ME_LOGGED_IN = "keepMeLoggedIn";

    public static final String PASSWORD = "password";


     
    // Constructor
    public SessionMgr(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
 // Get Login State
    public boolean keepMeLoggedIn(){
        return pref.getBoolean(KEEP_ME_LOGGED_IN, false);
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String name, boolean keepMeLoggedIn){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
         
        // Storing email in pref
        editor.putBoolean(KEEP_ME_LOGGED_IN, keepMeLoggedIn);
         
        // commit changes
        editor.commit();
    }
	public void createSignupSession(String username, String password) {
		editor.putString(USER_NAME, username);
		editor.putString(PASSWORD, password);
		 // commit changes
        editor.commit();
	}   

	public boolean login(String username, String password){
		String prefUserName = pref.getString(USER_NAME, "");
		String prefPassword = pref.getString(PASSWORD, "");
		if(prefUserName.equals(username) && prefPassword.equals(password)){
			return true;
		}
		return false;
	}
}
