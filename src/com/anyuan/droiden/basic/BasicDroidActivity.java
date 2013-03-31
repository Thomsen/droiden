package com.anyuan.droiden.basic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.anyuan.droiden.activity.HomeActivity;
import com.anyuan.droiden.R;
import com.anyuan.droiden.bean.DialogDecorate;
import com.anyuan.droiden.exception.CrashHandler;
import com.anyuan.droiden.exception.DroidException;

/**
 * @author Thomsen
 * @version 1.0
 * @since 11/25/12 11:55 AM
 */
public abstract class BasicDroidActivity extends Activity {

    /**
     * 设置activity的TAG
     * @return
     */
    public abstract String getTag();

    private AlertDialog.Builder mBuilder;

    protected Activity mActivity;

    protected BasicDroidHandler mActivityHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;

        initCrashHandler();

        mActivityHandler = new BasicDroidHandler(this);
    }

    private void initCrashHandler() {
        CrashHandler crash = CrashHandler.getInstance();
        crash.setOnHandleException(new CrashHandler.OnHandleListener() {
            @Override
            public void handle() {
                        new Thread() {
                            public void run() {
                                Looper.prepare();
                                DialogDecorate dec = new DialogDecorate();
                                dec.setMessage("请选择报告，以便尽快帮你解决。");
                                dec.setOkContent("报告");
                                dec.setCancelContent("终止");
                                dialog(dec, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
//                                                android.os.Process.killProcess(android.os.Process.myPid());
                                                Intent intent = new Intent(mActivity, HomeActivity.class);
                                                startActivity(intent);
                                            }
                                        }, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                android.os.Process.killProcess(android.os.Process.myPid());
                                            }
                                        }, null
                                );
                                Looper.loop();
                            }
                        }.start();
            }
        });
        crash.init(this);
    }

    protected void dialog(DialogDecorate decorate, DialogInterface.OnClickListener okListener,
                          DialogInterface.OnClickListener cancelListener,
                          DialogInterface.OnClickListener discardListener) {
        if (decorate == null) {
            throw new DroidException();
        }

        mBuilder = new AlertDialog.Builder(mActivity);
        mBuilder.setTitle((decorate.getTitle() == null) ? getString(R.string.prompt) : decorate.getTitle());
        mBuilder.setMessage((decorate.getTitle() == null) ? getString(R.string.title) : decorate.getTitle());
        if (okListener != null) {
            mBuilder.setPositiveButton((decorate.getOkContent() == null) ? getString(R.string.ok) :
                    decorate.getOkContent(), okListener);
        }
        if (cancelListener != null) {
            mBuilder.setNegativeButton((decorate.getCancelContent() == null) ? getString(R.string.cancel) :
                    decorate.getCancelContent(), cancelListener);
        }
        if (discardListener != null) {
            mBuilder.setNeutralButton((decorate.getDiscardContent() == null) ? getString(R.string.discard) :
                    decorate.getDiscardContent(), discardListener);
        }
        mBuilder.create();
        mBuilder.show();
    }

}
