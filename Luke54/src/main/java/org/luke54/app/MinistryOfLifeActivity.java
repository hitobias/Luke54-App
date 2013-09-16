package org.luke54.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MinistryOfLifeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ministry_of_life);

        int[] images = {};
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ministry_of_life, menu);
        return true;
    }
    
}
