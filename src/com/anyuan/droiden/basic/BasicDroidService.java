package com.anyuan.droiden.basic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author Thomsen
 * @version 1.0
 * @since 11/25/12 11:56 AM
 */
public abstract class BasicDroidService extends Service {

    /**
     * 获取Service的TAG
     * @return
     */
    protected abstract String getTag();

    protected  BasicDroidHandler mServiceHandler;

    @Override
    public void onCreate() {
        super.onCreate();

        mServiceHandler = new BasicDroidHandler(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
