// A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.
package com.example.lenovo.checking_prime;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class Checking_Prime extends AppCompatActivity
{
    public static int i1;        // saving the no for screen rotation
    public static String i2 = "a", i3 = "b", i4 = "c";    // used in savedInstance
    public static boolean buttonState = true, buttonState2 = true, hint = false, cheat = false;
    Button deepcorrec, deepincorrec;
    public static TextView tv8, tv9;
    RelativeLayout rl;

    // Check if no is prime
    public static boolean CheckPrime( int num ){
        boolean flag = false;
        for( int i=2; i<=num; i++){
            if( (num%i)==0 ){
                flag = true;
            }
        }
        return flag;
    }

    // Pressing back button takes us to first activity
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        return;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(i2, i1);
        outState.putBoolean(i3, buttonState);   // For correct
        outState.putBoolean(i4, buttonState2);  // For incorrect
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_checking__prime);

        deepcorrec = (Button)findViewById(R.id.correc);
        deepincorrec = (Button)findViewById(R.id.incorrec);

        rl = (RelativeLayout) findViewById(R.id.rl);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tv =(TextView)findViewById(R.id.texx);

        if( savedInstanceState!=null ) {
            i1 = savedInstanceState.getInt( i2 );

            buttonState = savedInstanceState.getBoolean(i3);
            buttonState2 = savedInstanceState.getBoolean(i4);

            deepcorrec.setEnabled(buttonState);
            deepincorrec.setEnabled(buttonState2);
        }
        else {
            Random r = new Random();
            i1 = r.nextInt(1001 - 1) + 1;
        }
        tv.setText("Is " + Integer.toString( i1 ) + " a prime no?" );

        tv8 = (TextView)findViewById(R.id.hinttaken);
        tv9 = (TextView)findViewById(R.id.cheattaken);

        // Correct button
        deepcorrec.setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                buttonState = false;             // incorrect
                buttonState2 = false;           // correct

                deepcorrec.setEnabled(buttonState);
                deepincorrec.setEnabled(buttonState2);

                if( i1!=1 ) {
                    if( !CheckPrime(i1) ) {
                        Toast.makeText(getApplicationContext(),"It is Correct!!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"It is Incorrect!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"It is Incorrect!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Incorrect button
        deepincorrec.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                buttonState = false;
                buttonState2 = false;

                deepcorrec.setEnabled(buttonState);
                deepincorrec.setEnabled(buttonState2);

                if( i1!=1 ) {
                    if( !CheckPrime(i1) ) {
                        Toast.makeText(getApplicationContext(),"It is Incorrect!!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"It is Correct!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"It is Correct!!", Toast.LENGTH_SHORT).show();
                }
            }});

        // Next button
        Button deepnex = (Button)findViewById(R.id.nex);
        deepnex.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                buttonState = true;
                buttonState2 = true;

                deepcorrec.setEnabled(buttonState);
                deepincorrec.setEnabled(buttonState);

                Random r = new Random();
                i1 = r.nextInt(1001 - 1) + 1;

                rl.setBackgroundColor(Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255)));

                TextView tv =(TextView)findViewById(R.id.texx);
                tv.setText("Is " + Integer.toString( i1 ) + " a prime no?" );

                hint = false;
                cheat = false;
                tv8.setText( "" );
                tv9.setText( "" );
            }
        });

        // Exit button
        Button exit2 = (Button)findViewById(R.id.exitt);
        exit2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                hint = false;
                cheat = false;
                tv8.setText( "" );
                tv9.setText( "" );
                startActivity( new Intent(getApplicationContext(), Checking_Primee.class) );
            }
        });

        // GetHint
        Button deepgethint = (Button)findViewById(R.id.gethint);
        deepgethint.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                hint = true;
                Intent in = new Intent(getApplicationContext(), GHint.class);
                in.putExtra("s1", i1);
                startActivity( in );
                if( hint ){
                    tv8.setText( "Hint Taken" );
                }
            }
        });

        // GetCheat
        Button deepgetcheat = (Button)findViewById(R.id.getcheat);
        deepgetcheat.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                cheat = true;
                Intent in = new Intent(getApplicationContext(), GetCheat.class);
                in.putExtra("s2", i1);
                startActivity( in );
                if( cheat ){
                    tv9.setText( "Cheat Taken" );
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_checking__prime, menu);
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