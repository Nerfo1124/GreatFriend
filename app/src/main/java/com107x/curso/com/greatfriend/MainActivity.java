package com107x.curso.com.greatfriend;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends ListActivity {

    String [] names;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Construct a string array from the String Array resource "friends" in the
        // strings.xml file
        names = getResources().getStringArray(R.array.friends);
        // This method call sets the names string array as the source of the names
        // for the list of items in the listview. The ArrayAdapter object is used
        // to adapt the string array and construct a list of layout items that are
        // then used by the ListView of the ListActivity to construct the list of friends.
        // The layout of each item is specified by the friend_item.xml file
        setListAdapter(new ArrayAdapter<String>(this, R.layout.friend_item, names));
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public String getGreetingMessage(){

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        String message = "";

        if(hour >= 6 && hour < 12)
            message = getString(R.string.greetMorning);
        else if (hour >= 12 && hour < 17)
            message = getString(R.string.greetAfternoon);
        else if (hour >= 17 && hour < 21)
            message = getString(R.string.greetEvening);
        else if (hour >= 21 || hour < 6)
            message = getString(R.string.greetNight);

        return message;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String greeting = getGreetingMessage();

        // create a new intent. The first parameter is the Context which is the current Activity.
        // Hence we use "this". The second parameter is the Activity class that we wish to start.
        // Hence it is specified as ShowMessage.class
        Intent in = new Intent(this, ShowMessege.class);
        // Add the message as a payload to the Intent. We add data to be carried by the intern using
        // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
        // the key, specified as a string, and the second parameter is the value.
        in.putExtra("message", greeting + " " + names[(int) id] + "!");
        // We start the new activity by calling this method to inform the Android framework to start
        // the new activity. The parameter is the Intent we just created earlier
        startActivity(in);
    }

    /*
    @Override
    public void onClick(View v) {

        TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);
        String friendName = editFriendName.getText().toString();
        String greeting = getGreetingMessage();

        switch (v.getId()){
            case R.id.GreetButton:
                // create a new intent. The first parameter is the Context which is the current Activity.
                // Hence we use "this". The second parameter is the Activity class that we wish to start.
                // Hence it is specified as ShowMessage.class
                Intent in = new Intent(this, ShowMessege.class);
                // Add the message as a payload to the Intent. We add data to be carried by the intern using
                // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
                // the key, specified as a string, and the second parameter is the value.
                in.putExtra("message", greeting + " " + friendName + "!");
                // We start the new activity by calling this method to inform the Android framework to start
                // the new activity. The parameter is the Intent we just created earlier
                startActivity(in);
                break;
            default:
                break;
        }
    }*/
}