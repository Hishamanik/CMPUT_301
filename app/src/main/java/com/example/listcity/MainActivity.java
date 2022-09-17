
//Student name: Al Hisham Anik
//CCID: alhisham
//CMPUT 301 Lab 2 Exercise
//Note: Some of the codes are taken during lab session from the TA's demo
//Pros: The delete button works perfectly
//Issues: Add button brings up the two button to add new cities to the list but unable to add anything yet

package com.example.listcity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String [] cities = {"Vancouver", "Sydney", "Moscow", "Edmonton", "Calgary" };
    ArrayList<String> arrayList;
    ListView listView;
    private Button addBtn;
    String selectedCity;

    ArrayAdapter<String> cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ListViewID);
        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(cities));


        cityAdapter = new ArrayAdapter<>(this, R.layout.city_list_item, arrayList);
        listView.setAdapter(cityAdapter);

        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setVisibilityAddCityComponent(true);
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                selectedCity = (String) (listView.getItemAtPosition(position));
            }
        });

        //listen for delete button click
        Button deleteBtn = findViewById(R.id.delBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                arrayList.remove(selectedCity);
                cityAdapter.notifyDataSetChanged();
            }
        });
    }

    public void setVisibilityAddCityComponent(boolean isVisible) {
        int visibilityCode = (isVisible) ? View.VISIBLE : View.INVISIBLE;
        EditText cityText = findViewById(R.id.city_editText);
        cityText.getText().clear();
        cityText.setVisibility(visibilityCode);
        Button confirmBtn = findViewById(R.id.confirmBtn);
        confirmBtn.setVisibility(visibilityCode);
    }
}