package com.coffee.android.services;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;

import com.coffee.android.R;
import com.coffee.android.dbhelpers.FactsDbContract;
import com.coffee.android.enums.FactName;
import com.coffee.android.enums.ImageId;
import com.coffee.android.provider.FactProvider;

/**
 * Created by michal_re on 09/05/2016.
 */
public class DBService extends IntentService {
    private String PROVIDER_NAME = "entity.FactsContentProvider";
    private String URL = "content://" + PROVIDER_NAME ;
    private Uri CONTENT_URI = Uri.parse(URL);
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */

    public DBService() {
        super("DBService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

                fillTheDB();
    }
    private void fillTheDB(){
       /* Toast.makeText(getBaseContext(),
                FactName.COFFEE_AND_THE_ENVIRONMENT.getId().toString(), Toast.LENGTH_LONG).show();*/

        getContentResolver().insert(FactProvider.CONTENT_URI, createFactContentValues(FactName.COFFEE_AND_THE_ENVIRONMENT,getString(R.string.title_cate1), ImageId.COFFEE_AND_THE_ENVIRONMENT));
        getContentResolver().insert(FactProvider.CONTENT_URI, createFactContentValues(FactName.COFFEE_IN_THE_GLOBAL_ECONOMY, getString(R.string.title_citge1), ImageId.COFFEE_IN_THE_GLOBAL_ECONOMY));
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
}
