package com.lei.mymessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by yanle on 2018/3/3.
 * 监听收到短信的广播
 */

public class SMSreceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("tag","收到短信");
        Toast.makeText(context,"Message",Toast.LENGTH_SHORT).show();
        Bundle bundle = intent.getExtras();
        //短信数组
        Object[] objs = (Object[])bundle.get("pdus");
        /*
        遍历短信数组
         */
        for(Object obj:objs) {
            SmsMessage message = SmsMessage.createFromPdu((byte[])obj);
            //得到发件人
            String address = message.getOriginatingAddress();
            //获取短信内容
            String body = message.getMessageBody();
            Log.i("tag","短信内容" + body);
        }
    }
}
