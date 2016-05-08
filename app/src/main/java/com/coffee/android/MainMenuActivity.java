package com.coffee.android;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.coffee.android.dbhelpers.FactsDbContract;
import com.coffee.android.enums.FactName;
import com.coffee.android.enums.ImageId;
import com.coffee.android.provider.FactProvider;

public class MainMenuActivity extends AppCompatActivity {
    private boolean dataInserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //insertFact(4);
        // initialize facts table
        if(!dataInserted){
            insertFactsToDB();
            dataInserted = true; // insert data only once.TODO: need to save in Bundle savedInstanceState
        }


    }
    private void insertFactsToDB(){
       /* Toast.makeText(getBaseContext(),
                FactName.COFFEE_AND_THE_ENVIRONMENT.getId().toString(), Toast.LENGTH_LONG).show();*/

        getContentResolver().insert(FactProvider.CONTENT_URI, createFactContentValues(FactName.COFFEE_AND_THE_ENVIRONMENT,getString(R.string.title_cate1),ImageId.COFFEE_AND_THE_ENVIRONMENT));
        getContentResolver().insert(FactProvider.CONTENT_URI, createFactContentValues(FactName.COFFEE_IN_THE_GLOBAL_ECONOMY,getString(R.string.title_citge1),  ImageId.COFFEE_IN_THE_GLOBAL_ECONOMY));
        getContentResolver().insert(FactProvider.CONTENT_URI, createFactContentValues(FactName.COFFEE_PRODUCTION_AND_LABOR, getString(R.string.title_cpal), ImageId.COFFEE_PRODUCTION_AND_LABOR));
        getContentResolver().insert(FactProvider.CONTENT_URI, createFactContentValues(FactName.COFFEE_TYPE, getString(R.string.coffee_type), ImageId.COFFEE_TYPE));

       /* ContentValues values = new ContentValues();
        values.put(FactsDbContract.KEY_ID, 1);
        values.put(FactsDbContract.TEXT, getString(R.string.title_cate1));
        // values.put(FactsDbContract.IMAGE_ID, imageId.getId());

      //  getContentResolver().insert(FactProvider.CONTENT_URI,values);
        Uri uri = getContentResolver().insert(FactProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();*/
    }

    private ContentValues createFactContentValues(FactName factName, String factText, ImageId imageId){
        ContentValues values = new ContentValues();
        values.put(FactsDbContract.FACT_NAME, factName.getId());
        values.put(FactsDbContract.TEXT, factText);
      // values.put(FactsDbContract.IMAGE_ID, imageId.getId());
        return values;
    }

    public void displayCoffeeType(View view){
// fact image
//        Button imageView =(Button) findViewById(R.id.coffee_type_img);
//        String selection = FactsDbContract.FACT_NAME + " = ?";
//        String[] selectionArgs = new String[]{FactName.COFFEE_TYPE.getId()};
//        Cursor cursor = getContentResolver().query(FactProvider.CONTENT_URI, null, selection, selectionArgs, null);
//        int imageId = cursor.getInt(cursor.getColumnIndex(FactsDbContract.IMAGE_ID));
//        imageView.setBackgroundResource(imageId);
                Intent intent = new Intent(this, CoffeeType.class);
                startActivity(intent);
    }

    public void displayCoffeeInTheGlobalEconomy(View view){


        Intent intent = new Intent(this,CoffeeInTheGlobalEconomy.class);
        startActivity(intent);
    }

    public void displayCoffeeProductionAndLabor(View view){
        Intent intent = new Intent(this, CoffeeProductionAndLabor.class);
        startActivity(intent);
    }

    public void displayCoffeeAndTheEnvironment(View view){
        // get fact image
      /*  String[] mProjection = {FactsDbContract.IMAGE_ID};
        Cursor cursor = getContentResolver().query(FactProvider.CONTENT_URI, mProjection, null, null, null);
        cursor.moveToFirst();
*/
        // fact image
       /* Button imageView =(Button) findViewById(R.id.coffee_type_img);
        int imageId = cursor.getInt(cursor.getColumnIndex(FactsDbContract.IMAGE_ID));
        imageView.setBackground(getDrawable(imageId));*/



        Intent intent = new Intent(this, CoffeeAndTheEnvironment.class);
        startActivity(intent);

    }
  /*  public void insertFact(int activityFact) {
        // Add a new employee record
        ContentValues contentValues = new ContentValues();
        switch (activityFact)
        {
            case 4:
                contentValues.put(FactsDbContract.KEY_ID, 1);
                contentValues.put(FactsDbContract.FACT_NAME, "@string/title_cate1");///
                contentValues.put(FactsDbContract.TEXT,"@string/coffee_overview5");
                break;
        }


        // Insert a new employee record to the content provider
        Uri uri = getContentResolver().insert(FactProvider.CONTENT_URI, contentValues);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }*/

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    public void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);


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
