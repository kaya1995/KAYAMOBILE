package com.bambey.utilityapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btnconnect = (Button) findViewById(R.id.bouton);

        btnconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity","Merci");
                Toast.makeText(getApplicationContext(),"le bouton est cliquer ", Toast.LENGTH_LONG).show();
final Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:779312442"));
           startActivity(intent);
            }
        });

        Button btn1connect = (Button) findViewById(R.id.boutonSMS);

        btn1connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + Uri.encode("779312442")));
                intent.putExtra("sms_body", "hello");
                startActivity(intent);
            }
        });


        Button btn2connect = (Button) findViewById(R.id.bouton3);

        btn2connect.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentNewActivity = new Intent(getApplicationContext(),newActivity.class);
                startActivity(intentNewActivity);

            }
        });
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
        else if (id == R.id.action1_help) {

            Intent intentNewActivity = new Intent(getApplicationContext(),newActivity.class);
            startActivity(intentNewActivity);
        }

        return super.onOptionsItemSelected(item);
    }
}
