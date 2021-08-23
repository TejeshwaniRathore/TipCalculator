package com.android.tippcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    public static String tvTip;
    public static String tvTotal;


    SeekBar sbPercent;

    Button btncalculate;

    EditText amount;

    double percentage,bill;




    TextView tvPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPercent=findViewById(R.id.tv_percent);
        amount=(EditText)findViewById(R.id.et_amount);






        sbPercent = findViewById(R.id.sb_percent);

        btncalculate = findViewById(R.id.btncalculate);





        sbPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                percentage=progress;
                tvPercent.setText(progress +"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calculate(View view){
        Intent intent=new Intent(getApplicationContext(),BillActivity.class);



        bill=Double.parseDouble(amount.getText().toString());
        intent.putExtra("bill_amount",bill);
        intent.putExtra("tip_percentage",percentage);
        startActivity(intent);
    }


}