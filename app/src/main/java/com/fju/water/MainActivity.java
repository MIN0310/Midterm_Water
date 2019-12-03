package com.fju.water;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView edmonth;
    float fee = 0;
    boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG, "onCreate");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        edmonth = findViewById(R.id.month);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caculate();
            }
        });
        Switch sw = findViewById(R.id.switch2);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.switch2);
                text.setText(isNext ? getText(R.string.ever_other_month) : getText(R.string.monthly));
                TextView text2 = findViewById(R.id.type);
                text2.setText(isNext ? getText(R.string.ever_other_month) : getText(R.string.monthly));

                if(isNext!=isChecked){

                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    public void reset() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void caculate() {
        if (!TextUtils.isEmpty(edmonth.getText().toString())) {
            float monthValue = Float.parseFloat(edmonth.getText().toString());
            if (monthValue >= 1 && monthValue <= 10) {
                fee = (float) (monthValue * 7.35);
            } else if (monthValue >= 11 && monthValue <= 30) {
                fee = (float) (monthValue * 9.45 - 21);
            } else if (monthValue >= 31 && monthValue <= 50) {
                fee = (float) (monthValue * 11.55 - 84);
            } else if (monthValue >= 51) {
                fee = (float) (monthValue * 12.075 - 110.25);
            }

//            if (!TextUtils.isEmpty(ednext.getText().toString())) {
//                float nextValue = Float.parseFloat(ednext.getText().toString());
//                if (nextValue >= 1 && nextValue <= 20) {
//                    fee = (float) (nextValue * 7.35);
//                } else if (nextValue >= 21 && nextValue <= 60) {
//                    fee = (float) (nextValue * 9.45 - 42);
//                } else if (nextValue >= 61 && nextValue <= 100) {
//                    fee = (float) (nextValue * 11.55 - 168);
//                } else if (nextValue >= 101) {
//                    fee = (float)(nextValue * 12.075 - 220.5);
//                }
        }
//            new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("每月抄表費用")
//                    .setMessage(getString(R.string.fee) + fee)
//                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            reset();
//                        }
//                    })
//                    .show();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(getString(R.string.extra_fee),fee);
        startActivity(intent);
    }



//        if(TextUtils.isEmpty(edmonth.getText().
//
//    toString())&&TextUtils.isEmpty(ednext.getText().
//
//    toString()))
//
//    {
//
//        new AlertDialog.Builder(this)
//                .setTitle(getString(R.string.error))
//                .setMessage(getString(R.string.please_enter_the_degree))
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        reset();
//                    }
//                }).show();
//    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
