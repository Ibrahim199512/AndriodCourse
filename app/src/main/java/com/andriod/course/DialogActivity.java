package com.andriod.course;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    AlertDialog alertDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                        DialogActivity.this, R.style.CustomDialogTheme);
                alertDialog.setTitle("Confirm Delete...");
                alertDialog.setMessage("Are you sure you want delete this file ? ");
                alertDialog.setIcon(R.drawable.logo);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int
                                    which) {
                                Toast.makeText(getApplicationContext(),
                                        "You clicked on YES",
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int
                                    which) {
                                Toast.makeText(getApplicationContext(),
                                        "You clicked on NO",
                                        Toast.LENGTH_SHORT)
                                        .show();
                                dialog.cancel();
                            }
                        });
                alertDialog1 = alertDialog.show();
            }
        });

        findViewById(R.id.close_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog1.dismiss();
            }
        });

        findViewById(R.id.custem_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(DialogActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.custem_dialog);
                dialog.show();
            }
        });

        findViewById(R.id.custem_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustemDialog custemDialog = new CustemDialog(DialogActivity.this);
                custemDialog.show();
            }
        });
    }
}
