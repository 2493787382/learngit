package com.example.test6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private NetworkChangeReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter();//？？？？？？？？？？？、
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new NetworkChangeReceiver();
        registerReceiver(receiver,filter);//注册广播
    }
    protected  void onDestroy(){//防止内存泄漏，释放内存
        super.onDestroy();
        unregisterReceiver(receiver);
    }
    class NetworkChangeReceiver extends BroadcastReceiver {//用于接收发送的广播信息
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("MainActivity","network changes");
        }
    }
}
