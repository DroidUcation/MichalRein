package com.coffe.android.aboutcoffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * Created by michal_re on 07/04/2016.
 */
public class CoffeeProductionAndLabor extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_producation_and_labor);

        TextView linkMoreInformation = (TextView) findViewById(R.id.coffee_overview13);
        linkMoreInformation.setMovementMethod(LinkMovementMethod.getInstance());
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
