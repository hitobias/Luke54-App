package org.luke54.app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FTTTMOHActivity extends Activity {

    private  int[] imagesId = {
            R.drawable.fttt_moh1,
            R.drawable.fttt_moh2,
            R.drawable.fttt_moh3,
            R.drawable.fttt_moh4,
            R.drawable.fttt_moh5,
            R.drawable.fttt_moh6,
            R.drawable.fttt_moh7,
            R.drawable.fttt_moh8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        RealViewSwitcher realViewSwitcher = new RealViewSwitcher(getApplicationContext());



        for (int i = 0; i < imagesId.length; i++) {
            ImageView iv = new ImageView(this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            iv.setLayoutParams(lp);
            iv.setBackgroundResource(imagesId[i]);
            realViewSwitcher.addView(iv);
        }
        setContentView(realViewSwitcher);

        realViewSwitcher.setOnScreenSwitchListener(onScreenSwitchListener);
    }

        private final RealViewSwitcher.OnScreenSwitchListener onScreenSwitchListener =
                new RealViewSwitcher.OnScreenSwitchListener() {
                    @Override
                    public void onScreenSwitched(final int screen) {
                    /*
                     * this method is executed if a screen has been activated, i.e. the screen is
                     * completely visible and the animation has stopped (might be useful for
                     * removing / adding new views)
                     */
                        Log.d("HorizontalPager", "switched to screen: " + screen);
                    }
                };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ftttmoh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case R.id.fttt_moh_add_contact:
                Intent intent_add_contact = new Intent(Intent.ACTION_INSERT);
                intent_add_contact.setType("vnd.android.cursor.dir/person");
                intent_add_contact.setType("vnd.android.cursor.dir/contact");
                intent_add_contact.setType("vnd.android.cursor.dir/raw_contact");
                startActivity(intent_add_contact);;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
}
