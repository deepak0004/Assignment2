package com.example.lenovo.checking_prime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetCheat extends AppCompatActivity
{
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        return;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_cheat);

        int ss = getIntent().getExtras().getInt("s2");

        TextView tv5 = (TextView) findViewById(R.id.txtview5);

        int i;
        boolean flagg = false;
        for (i = 2; i < ss; i++) {
            if ((ss % i) == 0) {
                flagg = true;
            }
        }

        if( flagg ) {
            tv5.setText( "" + i + " is not prime " );
        }
        else {
            tv5.setText( "" + i + " is prime " );
        }
    }
}
