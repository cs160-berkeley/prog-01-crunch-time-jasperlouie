package com.example.jasper.calorieconvertor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private void updateFields(HashMap<EditText, Double> conMap, EditText editedField){
        //System.out.println("asdlfjasd;f");
        EditText calField = (EditText) findViewById(R.id.editText1);
        double cals = 0.0;
        if(editedField != calField){
            double val = Float.parseFloat(editedField.getText().toString());
            cals = Math.ceil(val * conMap.get(editedField));
            calField.setText("" + cals);
        }else{
            cals = Float.parseFloat(editedField.getText().toString());
        }
        System.out.println("HI");
        Set<EditText> update_set = new HashSet<EditText>(conMap.keySet());
        update_set.remove(editedField);
        for(EditText et: update_set){
            et.setText("" + (int)Math.ceil(cals / conMap.get(et)));
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        final HashMap<EditText, Double> conversion_map = new HashMap<EditText, Double>();
        conversion_map.put((EditText) findViewById(R.id.editText1), 1.0);
        conversion_map.put((EditText) findViewById(R.id.editText2), 100.0/350.0);
        conversion_map.put((EditText) findViewById(R.id.editText3), 100.0/200.0);
        conversion_map.put((EditText) findViewById(R.id.editText4), 100.0/225.0);
        conversion_map.put((EditText) findViewById(R.id.editText5), 100.01/100.0);
        conversion_map.put((EditText) findViewById(R.id.editText6), 100.0/10.0);
        conversion_map.put((EditText) findViewById(R.id.editText7), 100.0/25.0);
        conversion_map.put((EditText) findViewById(R.id.editText8), 100.0/25.0);
        conversion_map.put((EditText) findViewById(R.id.editText9), 100.0/12.0);
        conversion_map.put((EditText) findViewById(R.id.editText10), 100.0/20.0);
        conversion_map.put((EditText) findViewById(R.id.editText11), 100.0/12.0);
        conversion_map.put((EditText) findViewById(R.id.editText12), 100.0/13.0);
        conversion_map.put((EditText) findViewById(R.id.editText13), 100.0 / 15.0);

        for(final EditText et: conversion_map.keySet()){
            et.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(et.isFocused()) {
                        try{
                            double val = Float.parseFloat(et.getText().toString());
                            updateFields(conversion_map, et);
                        }catch(Exception e){

                        }

                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    // TODO Auto-generated method stub
                }

                @Override
                public void afterTextChanged(Editable s) {

                    // TODO Auto-generated method stub
                }
            });
        }
        updateFields(conversion_map, (EditText) findViewById(R.id.editText1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("To use this app, tap the number of calories burned or some amount of exercise, and enter a new value." +
                    " The rest of the values will update accordingly to reflect how many calories you will burn, and how much of each exercise you need to do the burn that many calories.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Got it!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });


            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
