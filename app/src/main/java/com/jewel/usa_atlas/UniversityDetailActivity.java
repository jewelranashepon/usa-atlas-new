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

public class UniversityDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_university_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.university_detail_container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get university name from intent
        String universityName = getIntent().getStringExtra("UNIVERSITY_NAME");
        getSupportActionBar().setTitle(universityName);

        // Initialize views
        ImageView universityImage = findViewById(R.id.university_image);
        TextView universityInfo = findViewById(R.id.university_info);
        TextView admissionInfo = findViewById(R.id.admission_info);
        TextView programsInfo = findViewById(R.id.programs_info);
        TextView campusInfo = findViewById(R.id.campus_info);

        // Set data based on university
        if ("Harvard University".equals(universityName)) {
            universityImage.setImageResource(R.drawable.map_usa);
            universityInfo.setText(getString(R.string.california_info));
            admissionInfo.setText(getString(R.string.usa_map_description));
            programsInfo.setText(getString(R.string.california_info));
            campusInfo.setText(getString(R.string.california_info));
        } else if ("Stanford University".equals(universityName)) {
            universityImage.setImageResource(R.drawable.map_usa);
            universityInfo.setText(getString(R.string.california_info));
            admissionInfo.setText(getString(R.string.california_info));
            programsInfo.setText(getString(R.string.california_info));
            campusInfo.setText(getString(R.string.california_info));
        } else if ("MIT".equals(universityName)) {
            universityImage.setImageResource(R.drawable.map_usa);
            universityInfo.setText(getString(R.string.california_info));
            admissionInfo.setText(getString(R.string.california_info));
            programsInfo.setText(getString(R.string.california_info));
            campusInfo.setText(getString(R.string.california_info));
        } else {
            // Default or placeholder data for other universities
            universityImage.setImageResource(R.drawable.map_usa);
            universityInfo.setText(getString(R.string.default_university_info));
            admissionInfo.setText(getString(R.string.default_state_history));
            programsInfo.setText(getString(R.string.default_state_facts));
            campusInfo.setText(getString(R.string.default_state_history  ));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}