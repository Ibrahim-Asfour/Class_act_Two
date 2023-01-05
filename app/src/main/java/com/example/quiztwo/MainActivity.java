package com.example.quiztwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText salary;
    private Spinner spinner;
    private ListView listView;
    ArrayList<Employee> emploArray = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    public void setupView(){

        name = findViewById(R.id.name);
        salary = findViewById(R.id.salary);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listViewh);
        ArrayList<String> list = new ArrayList<>();
        list.add("full time");
        list.add("part time");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        spinner.setAdapter(adapter);
    }

    public void addInfo(View view) {

        Employee emp = new Employee(name.getText().toString(),Double.parseDouble(salary.getText().toString())
        ,spinner.getSelectedItem().toString().equals("full time"));
        emploArray.add(emp);
        ArrayAdapter<Employee> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, emploArray);

        listView.setAdapter(adapter);

    }
}