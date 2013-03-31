package com.anyuan.droiden.basic;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.anyuan.droiden.utils.DataCastUtils;

/**
 * Created with IntelliJ IDEA.
 * User: thom
 * Date: 3/9/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicDroidHandler extends Handler {

    public static final int BASIC_EXCEPTION = 0x01;

    public static final int BASIC_SHOW_MESSAGE = 0x02;

    private Context mContext;

    public BasicDroidHandler(Context context) {
        mContext = context;
    }


    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        switch (msg.what) {
            case BASIC_SHOW_MESSAGE: {

                shortToast(DataCastUtils.castString(msg.obj));
            }
            case BASIC_EXCEPTION: {
                break;
            }
            default: {
                break;
            }
        }
    }


    public void showMessage(String strMsg) {
        Message msg = new Message();
        msg.what = BasicDroidHandler.BASIC_SHOW_MESSAGE;
        msg.obj = strMsg;
        sendMessage(msg);

    }

    public void showMessage(int idMsg) {
        Message msg = new Message();
        msg.what = BasicDroidHandler.BASIC_SHOW_MESSAGE;
        msg.obj = mContext.getString(idMsg);
        sendMessage(msg);
    }

    private void shortToast(String strMsg) {
        Toast.makeText(mContext, strMsg,  Toast.LENGTH_SHORT).show();
    }


}
