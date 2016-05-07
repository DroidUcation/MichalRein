package com.coffee.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by michal_re on 07/04/2016.
 */
public class CoffeeType extends AppCompatActivity {

    private final ArrayList<List<String>> completeCoffeeList = new ArrayList<>();
    private final List<String> completeCoffeeListNames = new ArrayList<>();
    private int typeIndex = 1;
    private String typeAppend = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_type);

        Spinner typesSpinner = (Spinner) findViewById(R.id.type_spinner);
        final ArrayAdapter<CharSequence> typesAdapter = ArrayAdapter.createFromResource(this,
                R.array.type_spinner_elements, android.R.layout.simple_spinner_item);
        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typesSpinner.setAdapter(typesAdapter);

        List<String> csvCoffeeList = Arrays.asList(getResources().getStringArray(R.array.complete_list));

        for (int i = 0; i < csvCoffeeList.size(); i++) {
            String singleRow = csvCoffeeList.get(i);
            List<String> items = Arrays.asList(singleRow.split("\\s*,\\s*"));
            completeCoffeeList.add(items);
            completeCoffeeListNames.add(items.get(0));

        }

        updateCoffeeList(completeCoffeeListNames);

        typesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                typeIndex = position+1;
                typeAppend = parent.getItemAtPosition(position).toString();
                filterCoffee();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }

    /**
     * @param coffeeArray list of coffee to be written to the filtered_coffee_list TextView
     */
    private void updateCoffeeList(List<String> coffeeArray) {

        StringBuffer coffeeString = new StringBuffer();
        for (int i = 0; i < coffeeArray.size(); i++) {
            coffeeString.append(coffeeArray.get(i)).append("\n");
        }
        TextView textView = (TextView) findViewById(R.id.filtered_coffee_list);
        textView.setText(coffeeString);

    }

    private void filterCoffee() {
        ArrayList<String> filteredCoffeeListNames = new ArrayList();
        for (int i = 0; i < completeCoffeeList.size(); i++) {
            String extractedName = completeCoffeeList.get(i).get(0);
            String a = completeCoffeeList.get(i).get(typeIndex);
            if (a.equals("true")) {
                filteredCoffeeListNames.add(extractedName);
            }
        }
        TextView coffeeListTitleView = (TextView) findViewById(R.id.coffee_list_title);
        if (typeAppend.contains("All") ) {
            coffeeListTitleView.setText("All Coffee");
        } else if (typeAppend.contains("All")) {
            coffeeListTitleView.setText("All " + typeAppend + " coffee");
        } else {
            coffeeListTitleView.setText(typeAppend );
        }
        updateCoffeeList(filteredCoffeeListNames);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}