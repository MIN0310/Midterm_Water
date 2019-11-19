package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        float fee = intent.getFloatExtra("FEE", -1);
        TextView feeText = findViewById(R.id.fee);
        int n = (int)(fee + 0.5f);//四捨五入
        feeText.setText(n +"");
    }

    public void back(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
