package com.fju.water;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private TextView edmonth;
    private TextView ednext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        edmonth = findViewById(R.id.month);
        ednext = findViewById(R.id.next);
    }
    public void reset() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void button(View view) {
        if (!TextUtils.isEmpty(edmonth.getText().toString())) {
            float monthValue = Float.parseFloat(edmonth.getText().toString());
            if (monthValue >= 1 && monthValue <= 10) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用：" + (float) (monthValue * 7.35))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (monthValue >= 11 && monthValue <= 30) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用：" + (float) (monthValue * 9.45 - 21))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (monthValue >= 31 && monthValue <= 50) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用：" + (float) (monthValue * 11.55 - 84))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (monthValue >= 51) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用：" + (float) (monthValue * 12.075 - 110.25))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            }
        }
        if (!TextUtils.isEmpty(ednext.getText().toString())) {
            float nextValue = Float.parseFloat(ednext.getText().toString());
            if (nextValue >= 1 && nextValue <= 20) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用：" + (float) (nextValue * 7.35))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (nextValue >= 21 && nextValue <= 60) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用：" + (float) (nextValue * 9.45 - 42))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (nextValue >= 61 && nextValue <= 100) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用：" + (float) (nextValue * 11.55 - 168))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (nextValue >= 101) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用：" + (float) (nextValue * 12.075 - 220.5))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            }
        }
        if (TextUtils.isEmpty(edmonth.getText().toString()) && TextUtils.isEmpty(ednext.getText().toString())) {
            new AlertDialog.Builder(this)
                    .setTitle("注意")
                    .setMessage("請輸入度數")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            reset();
                        }
                    }).show();
        }
    }

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
