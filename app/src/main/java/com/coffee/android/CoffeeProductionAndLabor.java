package com.coffee.android;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.coffee.android.dbhelpers.FactsDbContract;
import com.coffee.android.enums.FactName;
import com.coffee.android.provider.FactProvider;

/**
 * Created by michal_re on 07/04/2016.
 */
public class CoffeeProductionAndLabor extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_producation_and_labor);
        String selection = FactsDbContract.FACT_NAME + " = ?";
        String[] selectionArgs = new String[]{FactName.COFFEE_PRODUCTION_AND_LABOR.getId()};
        Cursor cursor = getContentResolver().query(FactProvider.CONTENT_URI, null, selection, selectionArgs, null);
        cursor.moveToFirst();
        // fact text
        TextView textView =(TextView) findViewById(R.id.coffee_producation_and_labor_textview1);
        // textView.setText(cursor.getString(cursor.getColumnIndex(FactsDbContract.TEXT)));

        if( cursor != null && cursor.moveToFirst() ){
            textView.setText(cursor.getString(cursor.getColumnIndex(FactsDbContract.TEXT)));
            cursor.close();
        }
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
