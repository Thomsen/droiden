package com.anyuan.droiden.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.anyuan.droiden.R;
import com.anyuan.droiden.basic.BasicDroidActivity;

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

//        throw new DroidException();
//        Library library = new Library();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//               showMessage("hehee");
//                mBasicHandler.sh("通用的消息显示，防止在非ui线程中");
//                mBasicHandler.showMessage("通用的消息显示，防止在非ui线程中");
            }

        });

    }

    @Override
    public String getTag() {
        return "HomeActivity";
    }

}

