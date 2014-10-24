package bettycc.com.weixin_cropimage;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bettycc.cropimage.library.CropView;

import uk.co.senab.photoview.PhotoViewAttacher;


public class MyActivity extends ActionBarActivity {

    private CropView mCropView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_my);
        mCropView = (CropView) findViewById(R.id.crop);

        // Set the Drawable displayed
        Drawable bitmap = getResources().getDrawable(R.drawable.android);
        mCropView.setImageDrawable(bitmap);

        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
//        mAttacher.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_clip) {

            ImageView view = new ImageView(this);
            Bitmap bitmap = mCropView.getCropedBitmap();
            view.setImageBitmap(bitmap);

            new AlertDialog.Builder(this)
                    .setView(view)
                    .setNegativeButton(android.R.string.cancel, null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
