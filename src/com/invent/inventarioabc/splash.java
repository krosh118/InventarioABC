package com.invent.inventarioabc;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.EditText;

public class splash extends Activity{

	private long splashDelay = 6000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		TimerTask task = new TimerTask() {
		      @Override
		      public void run() {
		        Intent mainIntent = new Intent().setClass(splash.this, MainActivity.class);
		        startActivity(mainIntent);
		        finish();
		      }
		    };

		    Timer timer = new Timer();
		    timer.schedule(task, splashDelay);
	}
		
	
	
}
