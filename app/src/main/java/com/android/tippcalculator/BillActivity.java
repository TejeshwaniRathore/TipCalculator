package com.android.tippcalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class BillActivity extends AppCompatActivity {

    private TextView bill;
    private TextView tip;

    private double total,percentage,t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_calculate);


        bill=(TextView) findViewById(R.id.tv_total);
        tip=(TextView) findViewById(R.id.tv_tip);

        Intent intent=getIntent();
        percentage=intent.getDoubleExtra("tip_percentage",0);
        t=intent.getDoubleExtra("bill_amount",0);
        total=(t+(t*(percentage/100.0)));
        bill.setText("Rs " + Double.toString(total));

        tip.setText("Rs " + String.format("%.2f",(t*(percentage/100.0))));

}}
