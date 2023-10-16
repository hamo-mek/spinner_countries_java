package com.example.spinnercountries;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner_main);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Country Name: " + item, Toast.LENGTH_SHORT).show();
                if (item.equals("South Africa")) {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                } else {
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE); // or any other default color
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /*This is the array in the MainActivity.java file:
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Yemen");
        countries.add("The US");
        countries.add("Argentina");
        countries.add("South Korea");
        countries.add("The Netherlands");*/

        ArrayAdapter<CharSequence> adapter =
                //array in the strings.xml file:
                ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        // array in the MainActivity.java file:
                // ArrayAdapter.createFromResource(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}