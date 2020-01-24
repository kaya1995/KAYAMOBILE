package com.example.suivi_eleve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** Called when the user taps the Enseignant button */
    public void toEnseingant (View view) {
        // Do something in response to button
        Intent intentEnseignant = new Intent(this, EnseignantDashbordActivity.class);
        startActivity(intentEnseignant);

       Toolbar toolbar = (Toolbar)  findViewById(R.id.toolbar);


        /** textView Tableau de bord*/
        TextView TableauDeBord = (TextView) findViewById(R.id.textView)  ;

        /** bouton publier*/
        Button publier = (Button) findViewById(R.id.button);


        /** Image activite a faire*/
         ImageView activite = (ImageView) findViewById(R.id.activite);

        /** Image activite a faire*/
        ImageView observation = (ImageView) findViewById(R.id.observation);

        /** Image activite a faire*/
        ImageView evenement = (ImageView) findViewById(R.id.evenement);

        /** Image activite a faire*/
        ImageView rappel = (ImageView) findViewById(R.id.rappel);


    }

    /** Called when the user taps the Parent button */
    public void toParent (View view) {
        // Do something in response to button
        Intent intentParent = new Intent(this, ParentAcceuilActivity.class);
        startActivity(intentParent);
    }

}
