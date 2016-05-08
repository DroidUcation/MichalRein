package com.coffee.android;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.coffee.android.dbhelpers.FactsDbContract;
import com.coffee.android.enums.FactName;
import com.coffee.android.provider.FactProvider;

/**
 * Created by michal_re on 07/04/2016.
 */
public class CoffeeInTheGlobalEconomy extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_in_the_global_economy);
        String selection = FactsDbContract.FACT_NAME + " = ?";
        String[] selectionArgs = new String[]{FactName.COFFEE_IN_THE_GLOBAL_ECONOMY.getId()};
        Cursor cursor = getContentResolver().query(FactProvider.CONTENT_URI, null, selection, selectionArgs, null);
        // fact text
        TextView textView =(TextView) findViewById(R.id.coffee_in_the_global_economy_textview1);
        // textView.setText(cursor.getString(cursor.getColumnIndex(FactsDbContract.TEXT)));

        if( cursor != null && cursor.moveToFirst() ){
            textView.setText(cursor.getString(cursor.getColumnIndex(FactsDbContract.TEXT)));
            cursor.close();
        }

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
