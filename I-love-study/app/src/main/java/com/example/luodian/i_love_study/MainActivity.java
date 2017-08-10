package com.example.luodian.i_love_study;

import android.Manifest;
import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button QRbutton = null;
    private Toolbar myToolBar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QRbutton = (Button) this.findViewById(R.id.qr_button);
        QRbutton.setOnClickListener(this);
        myToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolBar);

    }

    @Override
    public void onClick(View view)
    {
        if (view == QRbutton)
        {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},60);
            }
            else
            {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,QRActivity.class);
                MainActivity.this.startActivity(intent);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar,menu);
        myToolBar.getMenu().findItem(R.id.tb_settings).setVisible(true);
        myToolBar.getMenu().findItem(R.id.tb_photos).setVisible(false);
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
}
