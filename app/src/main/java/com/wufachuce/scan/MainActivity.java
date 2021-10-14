package com.wufachuce.scan;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQ_CODE = 0x1001;
    private static final int E1 = 0x01;
    private static final int E2 = 0x02;
    private static final int E3 = 0x03;
    private static final int E4 = 0x04;
    private static final int E5 = 0x05;
    private static final int E6 = 0x06;
    String content = "QR Code Content";
    int type = HmsScan.QRCODE_SCAN_TYPE;
    int width = 400;
    int height = 400;
    private TextView e1;
    private EditText et1;
    private TextView re1;

    private TextView e2;
    private EditText et2;
    private TextView re2;

    private TextView e3;
    private EditText et3;
    private TextView re3;

    private TextView e4;
    private EditText et4;
    private TextView re4;

    private TextView e5;
    private EditText et5;
    private TextView re5;

    private TextView e6;
    private EditText et6;
    private TextView re6;


    private EditText et7;
    private Button btn0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Txt.createFile((Context)this);
        // CAMERA_REQ_CODE为用户自定义，用于接收权限校验结果的请求码。
        this.requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_REQ_CODE);
        initview();
    }

    private void initview() {
        e1 = findViewById(R.id.e1);
        e1.setOnClickListener(this);
        et1 = findViewById(R.id.et1);
        re1 = findViewById(R.id.re1);
        re1.setOnClickListener(this);

        e2 = findViewById(R.id.e2);
        e2.setOnClickListener(this);
        et2 = findViewById(R.id.et2);
        re2 = findViewById(R.id.re2);
        re2.setOnClickListener(this);

        e3 = findViewById(R.id.e3);
        e3.setOnClickListener(this);
        et3 = findViewById(R.id.et3);
        re3 = findViewById(R.id.re3);
        re3.setOnClickListener(this);

        e4 = findViewById(R.id.e4);
        e4.setOnClickListener(this);
        et4 = findViewById(R.id.et4);
        re4 = findViewById(R.id.re4);
        re4.setOnClickListener(this);

        e5 = findViewById(R.id.e5);
        e5.setOnClickListener(this);
        et5 = findViewById(R.id.et5);
        re5 = findViewById(R.id.re5);
        re5.setOnClickListener(this);

        e6 = findViewById(R.id.e6);
        e6.setOnClickListener(this);
        et6 = findViewById(R.id.et6);
        re6 = findViewById(R.id.re6);
        re6.setOnClickListener(this);


        et7 = findViewById(R.id.et7);
        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
    }


    // 实现“onRequestPermissionsResult”函数接收校验权限结果。
    final int PERMISSIONS_LENGTH = 2;
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // 判断“requestCode”是否为申请权限时设置请求码CAMERA_REQ_CODE，然后校验权限开启状态。
        if (requestCode == CAMERA_REQ_CODE && grantResults.length == PERMISSIONS_LENGTH && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.e1:
                ScanUtil.startScan(this, E1, new HmsScanAnalyzerOptions.Creator().create());
                break;
            case R.id.re1:
                et1.setText("");
                break;

            case R.id.e2:
                ScanUtil.startScan(this, E2, new HmsScanAnalyzerOptions.Creator().create());
                break;
            case R.id.re2:
                et2.setText("");
                break;

            case R.id.e3:
                ScanUtil.startScan(this, E3, new HmsScanAnalyzerOptions.Creator().create());
                break;
            case R.id.re3:
                et3.setText("");
                break;

            case R.id.e4:
                ScanUtil.startScan(this, E4, new HmsScanAnalyzerOptions.Creator().create());
                break;
            case R.id.re4:
                et4.setText("");
                break;

            case R.id.e5:
                ScanUtil.startScan(this, E5, new HmsScanAnalyzerOptions.Creator().create());
                break;
            case R.id.re5:
                et5.setText("");
                break;

            case R.id.e6:
                ScanUtil.startScan(this, E6, new HmsScanAnalyzerOptions.Creator().create());
                break;
            case R.id.re6:
                et6.setText("");
                break;
            case R.id.btn0:

                    StringBuffer stringBuffer = new StringBuffer();

                    stringBuffer.append(
                            et1.getText().toString()).append("|").append(
                            et2.getText().toString()).append("|").append(
                            et3.getText().toString()).append("|").append(
                            et4.getText().toString()).append("|").append(
                            et5.getText().toString()).append("|").append(
                            et6.getText().toString()).append("|").append(
                            et7.getText().toString());
                   Txt.save2File(stringBuffer.toString());
                Toast.makeText(this,stringBuffer.toString(),Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");
                break;

        }
    }


    /**
     * Event for receiving the activity result.
     *
     * @param requestCode Request code.
     * @param resultCode Result code.
     * @param data        Result.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null) {
            return;
        }
        HmsScan obj = data.getParcelableExtra(ScanUtil.RESULT);
        if (obj != null) {
            if (requestCode == E1) {
                et1.setText(obj.getOriginalValue());
            } else if (requestCode == E2) {
                et2.setText(obj.getOriginalValue());
            } else if (requestCode == E3) {
                et3.setText(obj.getOriginalValue());
            } else if (requestCode == E4) {
                et4.setText(obj.getOriginalValue());
            } else if (requestCode == E5) {
                et5.setText(obj.getOriginalValue());
            } else if (requestCode == E6) {
                et6.setText(obj.getOriginalValue());
            }
        }

    }

}
