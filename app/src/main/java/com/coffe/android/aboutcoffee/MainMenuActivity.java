package com.coffe.android.aboutcoffee;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //System.gc();
        super.onCreate(savedInstanceState);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(getResources(), R.id.coffee_in_the_global_economy, options);
//        int imageHeight = options.outHeight;
//        int imageWidth = options.outWidth;
//        String imageType = options.outMimeType;
//        if( savedInstanceState != null )
//            Toast.makeText(this, savedInstanceState.getString("message"), Toast.LENGTH_LONG).show();

//         String url = new String("https://www.google.co.il/search?q=coffee&espv=2&biw=1920&bih=955&source=lnms&tbm=isch&sa=X&ved=0ahUKEwj26LGvzIPMAhWDPRoKHU7YA1AQ_AUIBigB#imgrc=MH5h5aOa3jMtMM%3A");
//
//        DownloadImageTask downloadImageTask=  new DownloadImageTask((ImageView) findViewById(R.id.coffee_in_the_global_economy));
//        downloadImageTask.doInBackground(url);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.id.coffee_in_the_global_economy, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;

        setContentView(R.layout.activity_main_menu);
//        URL url = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
//        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        imageView.setImageBitmap(bmp);

    }
//    mImageView.setImageBitmap(
//    decodeSampledBitmapFromResource(getResources(), R.id.myimage, 100, 100));
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    public void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("message", "This is my message to be reloaded");

    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//    }

    public void displayCoffeeType(View view){
        Intent intent = new Intent(this, CoffeeType.class);
        startActivity(intent);
    }

    public void displayCoffeeInTheGlobalEconomy(View view){
        Intent intent = new Intent(this, CoffeeInTheGlobalEconomy.class);
        startActivity(intent);
    }

    public void displayCoffeeProductionAndLabor(View view){
        Intent intent = new Intent(this, CoffeeProductionAndLabor.class);
        startActivity(intent);
    }

    public void displayCoffeeAndTheEnvironment(View view){
        Intent intent = new Intent(this, CoffeeAndTheEnvironment.class);
        startActivity(intent);
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
        /*ImageView imageView = (ImageView) findViewById(R.id.coffee_in_the_global_economy);
        Drawable drawable = imageView.getDrawable();
        imageView.setImageDrawable(null);

        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }*/
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
