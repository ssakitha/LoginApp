package com.simple.loginapp;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		switch (item.getItemId()) {
		
		
		case R.id.map: {
			Intent i = new Intent();
			i.setAction("com.simple.gmap");
			startActivity(i);
			break;
		}
		case R.id.survey: {
			Intent a = new Intent();
			a.setAction("com.simple.survey");
			startActivity(a);
			Log.v("survey", "survey");
			break;
		}
		case R.id.calculator: {
			Intent a = new Intent();
			a.setAction("com.simple.calculator");
			startActivity(a);
			Log.v("survey", "survey");
			break;
		}

		}
		return super.onMenuItemSelected(featureId, item);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
	}
	private boolean welcome=false;
	public void flipImage(View v){
		ImageView portrait=(ImageView)findViewById(R.id.imageView1);
		
		if (welcome){
			portrait.setImageResource(R.drawable.welcome);
		}
		
		else {
			portrait.setImageResource(R.drawable.cat);
		}
		welcome=!welcome;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
		
		
		
}



