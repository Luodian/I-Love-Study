package com.example.luodian.i_love_study;

import android.content.Intent;
import android.graphics.Bitmap;
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
import com.mylhyl.zxing.scanner.ScannerView;

public class QRActivity extends AppCompatActivity
{
    private ScannerView mScannerView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        Toolbar myToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        mScannerView = (ScannerView) findViewById(R.id.qr_scanner_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int itemID = item.getItemId();
        if (itemID == R.id.tb_settings)
        {
            Toast.makeText(this,"Settings",0).show();
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

    void onScannerCompletion(Result rawResult, ParsedResult parsedResult, Bitmap barcode)
    {
        ParsedResultType type = parsedResult.getType();
    }

}
