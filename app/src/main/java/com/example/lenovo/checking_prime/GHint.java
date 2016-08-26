package com.example.lenovo.checking_prime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GHint extends AppCompatActivity
{
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        return;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghint);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        int ss = getIntent().getExtras().getInt("s1");

        TextView tv = (TextView) findViewById(R.id.txtview2);
        tv.setText("Factors of " + ss);
        TextView tv2 = (TextView) findViewById(R.id.txtview3);

        int i;

        for (i = 1; i <= ss; i++) {
            if ((ss % i) == 0) {
                tv2.setText(tv2.getText() + "  " + i);
            }
        }
    }
}