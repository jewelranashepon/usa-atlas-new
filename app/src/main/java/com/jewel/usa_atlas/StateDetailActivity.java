package com.jewel.usa_atlas;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StateDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_state_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.state_detail_container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get data from intent with null checks
        String stateName = getIntent().getStringExtra("STATE_NAME");
        if (stateName == null) {
            stateName = "Unknown State";
        }

        // Set title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(stateName);
        }

        try {
            // Initialize views with null checks
            ImageView stateMap = findViewById(R.id.state_map);
            TextView stateInfo = findViewById(R.id.state_info);
            TextView stateHistory = findViewById(R.id.state_history);
            TextView stateFacts = findViewById(R.id.state_facts);

            // Set sample data based on the state with proper resource handling
            if ("California".equals(stateName)) {
                stateMap.setImageResource(R.drawable.map_usa);
                stateInfo.setText(getString(R.string.california_info));
                stateHistory.setText(getString(R.string.california_history));
                stateFacts.setText(getString(R.string.california_facts));
            } else if ("New York".equals(stateName)) {
                stateMap.setImageResource(R.drawable.map_usa);
                stateInfo.setText(getString(R.string.new_york_info));
                stateHistory.setText(getString(R.string.new_york_history));
                stateFacts.setText(getString(R.string.new_york_facts));
            } else if ("Texas".equals(stateName)) {
                stateMap.setImageResource(R.drawable.map_usa);
                stateInfo.setText(getString(R.string.texas_info));
                stateHistory.setText(getString(R.string.texas_history));
                stateFacts.setText(getString(R.string.texas_facts));
            } else {
                // Default or placeholder data for other states
                stateMap.setImageResource(R.drawable.map_usa);
                stateInfo.setText(getString(R.string.default_state_info, stateName));
                stateHistory.setText(getString(R.string.default_state_history, stateName));
                stateFacts.setText(getString(R.string.default_state_facts, stateName));
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception gracefully, perhaps show a toast message
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}