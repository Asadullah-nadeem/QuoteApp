package com.example.dailyquotes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private TextView quoteTextView;
    private Button nextQuoteButton, favoritesButton, showQuotesButton, saveToFavoritesButton;
    private ArrayList<String> quotesList = new ArrayList<>();
    private Random random = new Random();
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        quoteTextView = findViewById(R.id.quoteTextView);
        nextQuoteButton = findViewById(R.id.nextQuoteButton);

        showQuotesButton = findViewById(R.id.showQuotesButton);


        initializeQuotes();
        showRandomQuote();
        nextQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRandomQuote();
            }
        });
        showQuotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuoteListActivity.class));
            }
        });
    }
    private void showRandomQuote() {
        String randomQuote = quotesList.get(random.nextInt(quotesList.size()));
        quoteTextView.setText(randomQuote);
    }

    private void initializeQuotes() {
        quotesList.add("Believe in yourself and all that you are.");
        quotesList.add("The only way to do great work is to love what you do.");
        quotesList.add("Success is not the key to happiness. Happiness is the key to success.");
        quotesList.add("Stay positive, work hard, make it happen.");
        quotesList.add("Don't watch the clock; do what it does. Keep going.");
    }

    private void saveQuoteToFavorites() {
        String currentQuote = quoteTextView.getText().toString();
        Set<String> favoritesSet = sharedPreferences.getStringSet("favorites", new HashSet<>());
        favoritesSet.add(currentQuote);
        sharedPreferences.edit().putStringSet("favorites", favoritesSet).apply();
        Toast.makeText(MainActivity.this, "Quote added to Favorites", Toast.LENGTH_SHORT).show();
    }
}
