package com.example.test_10_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mReceiver;
    private IntentFilter mFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReceiver = new MyReceiver2();
        mFilter = new IntentFilter("com.example.test_10_05.TESTEVENT2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(mReceiver, mFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mReceiver);
    }

    public void mOnClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnIntent1:
                intent.setAction("com.example.test_10_05.TESTEVENT1");
                intent.putExtra("mydata", 100);
                sendBroadcast(intent);
                break;
            case R.id.btnIntent2:
                intent.setAction("com.example.test_10_05.TESTEVENT2");
                intent.putExtra("mydata", 200);
                sendBroadcast(intent);
                break;
        }
    }
}