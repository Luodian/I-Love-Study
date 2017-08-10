package com.example.luodian.i_love_study;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.mylhyl.zxing.scanner.OnScannerCompletionListener;
import com.mylhyl.zxing.scanner.ScannerView;
import com.mylhyl.zxing.scanner.common.Scanner;

public class QRActivity extends AppCompatActivity implements OnScannerCompletionListener {
    public static final String EXTRA_LASER_LINE_MODE = "extra_laser_line_mode";
    public static final String EXTRA_SCAN_MODE = "extra_scan_mode";
    private ScannerView mScannerView;
    private Result mLastResult;
    private int laserMode;
    private boolean scanMode = true;

    private Toolbar myToolBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        myToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        mScannerView = (ScannerView) findViewById(R.id.qr_scanner_view);
        mScannerView.setOnScannerCompletionListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            laserMode = extras.getInt(EXTRA_LASER_LINE_MODE);
            scanMode = extras.getBoolean(EXTRA_SCAN_MODE);
        }

        mScannerView.setMediaResId(R.raw.beep);
        mScannerView.setDrawText("将二维码放入框内",true);
        mScannerView.setDrawTextColor(Color.WHITE);
        mScannerView.setLaserGridLineResId(R.mipmap.grid_scan_line);
        mScannerView.setLaserFrameBoundColor(0xFF26CEFF);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar,menu);
        myToolBar.getMenu().findItem(R.id.tb_settings).setVisible(false);
        myToolBar.getMenu().findItem(R.id.tb_photos).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int itemID = item.getItemId();
        if (itemID == R.id.tb_photos)
        {
            Toast.makeText(this,"Photos",0).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume()
    {
        mScannerView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        mScannerView.onPause();
        super.onPause();
    }

    private void restartPreviewAfterDelay(long delayMS) {
        mScannerView.restartPreviewAfterDelay(delayMS);
        resetStatusView();
    }

    private void resetStatusView() {
        mLastResult = null;
    }

    @Override
    public void OnScannerCompletion(Result rawResult, ParsedResult parsedResult, Bitmap barcode)
    {
        ParsedResultType type = parsedResult.getType();
    }
}
