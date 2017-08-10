package com.acadgild.application102;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    TextView textView;
    ArrayList<String> productname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //passing id textView
        textView = (TextView) findViewById(R.id.textView);
        //creating arraylist and populating it
        productname =new ArrayList<>();
        productname.add("Hp Inkjet Printer");
        productname.add("Google Pixel");
        productname.add("Apple Macbook Pro");
         //creating object of MyHelperClass
        MyHelper myHelper = new MyHelper(this);
          //applying forloop
        for(int i = 0;i<productname.size();i++){
            myHelper.Addproducts(productname.get(i));
        }



        ArrayList arrayList = myHelper.Databasetoarray();



         // //passing id of  autoCompleteTextView
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,arrayList);
        //setting the minimum word to get suggestion
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);



    }
}

