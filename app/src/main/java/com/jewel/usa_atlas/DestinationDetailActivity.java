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

public class DestinationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_destination_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.destination_detail_container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get data from intent
        String name = getIntent().getStringExtra("DESTINATION_NAME");
        String location = getIntent().getStringExtra("DESTINATION_LOCATION");
        String description = getIntent().getStringExtra("DESTINATION_DESCRIPTION");
        int imageResource = getIntent().getIntExtra("DESTINATION_IMAGE", R.drawable.ic_flag_usa);

        // Set title
        getSupportActionBar().setTitle(name);

        // Set views
        ImageView destinationImage = findViewById(R.id.destination_image);
        TextView destinationLocation = findViewById(R.id.destination_location);
        TextView destinationDescription = findViewById(R.id.destination_description);
        TextView destinationVisitInfo = findViewById(R.id.destination_visit_info);

        destinationImage.setImageResource(imageResource);
        destinationLocation.setText(location);
        destinationDescription.setText(description);

        // Set visit info based on destination
        if ("Grand Canyon".equals(name)) {
            destinationVisitInfo.setText(getString(R.string.grand_canyon_visit_info));
        } else if ("Statue of Liberty".equals(name)) {
            destinationVisitInfo.setText(getString(R.string.statue_liberty_visit_info));
        } else {
            destinationVisitInfo.setText(getString(R.string.default_visit_info));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

