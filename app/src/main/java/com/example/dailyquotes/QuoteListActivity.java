package com.example.dailyquotes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QuoteListActivity extends AppCompatActivity {

    private ListView quotesListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> quotesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_list);
        quotesListView = findViewById(R.id.quotesListView);
        quotesList = new ArrayList<>();
        quotesList.add("Believe in yourself and all that you are.");
        quotesList.add("The only way to do great work is to love what you do.");
        quotesList.add("Success is not the key to happiness. Happiness is the key to success.");
        quotesList.add("Stay positive, work hard, make it happen.");
        quotesList.add("Don't watch the clock; do what it does. Keep going.");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quotesList);
        quotesListView.setAdapter(adapter);

    }
}
