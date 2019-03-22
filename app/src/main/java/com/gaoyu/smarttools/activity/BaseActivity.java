package com.gaoyu.smarttools.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gaoyu.smarttools.R;

public class BaseActivity extends AppCompatActivity {
    private Toast mToast = null;
    //封装所有权限
    private String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.TRANSMIT_IR,
            Manifest.permission.READ_CONTACTS
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }

    /**
     * 展示Toast
     *
     * @return
     */


}
