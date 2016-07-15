package com.example.gideon.temperatureconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText temp;
    RadioButton toCelcius;
    RadioButton toFahreinheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        temp = (EditText)findViewById(R.id.temperatureEditText);
        toCelcius = (RadioButton)findViewById(R.id.celciusRadioButton);
        toFahreinheit = (RadioButton)findViewById(R.id.fahreinheitRadioButton);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public  void  convert(View v) {
        double value = new Double(temp.getText().toString());

        if (toCelcius.isChecked())
            value = Converter.fahrenheit(value);
        else
            value = Converter.celcius(value);

        temp.setText(new Double(value).toString());

    }

    /**
     * Created by gideon on 08/07/16.
     */
    public static class Converter {
        public static double fahrenheit(double f) {
            return (f - 32) * 5/9;
        }

        public  static  double celcius(double c) {
            return (32 + c) * 9/5;
        }
    }
}
