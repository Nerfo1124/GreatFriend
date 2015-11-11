package com107x.curso.com.greatfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowMessege extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_messege);

        // We first get a reference to the Intent that resulted in this activity
        // being started by the Android framework.
        Intent in = getIntent();
        // From the Intent we retrieve the message that was sent from MainActivity
        // Note the use of the same key, "message", to retrieve the message
        String message = in.getStringExtra("message");
        // Get the reference to the TextView on the ShowMessage UI
        TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
        // set the text of the TextView to display the incoming greeting message
        txtMessage.setText(message);

        Log.i(TAG, "In onCreate()");
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "In onStart()");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "In onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "In onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "In onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "In onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "In onDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_messege, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
