package com.anyuaning.droiden.activity;

import android.os.Bundle;
import android.util.Log;
import com.anyuaning.droiden.R;
import com.anyuaning.droiden.basic.BasicDroidActivity;
import com.anyuaning.droiden.exception.DroidException;

public class HomeActivity extends BasicDroidActivity {

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.i(getTag(), "onCreate");
        setContentView(R.layout.main);

        throw new DroidException();

    }

    @Override
    public String getTag() {
        return "HomeActivity";
    }

}

