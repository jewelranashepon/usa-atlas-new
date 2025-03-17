package com.jewel.usa_atlas;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.jewel.usa_atlas.fragments.EmergencyFragment;
import com.jewel.usa_atlas.fragments.GeographyFragment;
import com.jewel.usa_atlas.fragments.StatesFragment;
import com.jewel.usa_atlas.fragments.TourismFragment;
import com.jewel.usa_atlas.fragments.TrafficRulesFragment;
import com.jewel.usa_atlas.fragments.UniversitiesFragment;
import com.jewel.usa_atlas.fragments.VisitorInfoFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        // Set up the drawer layout
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        
        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        // Load default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new StatesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_states);
        }
    }
    
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment selectedFragment = null;
        
        int itemId = item.getItemId();
        if (itemId == R.id.nav_states) {
            selectedFragment = new StatesFragment();
        } else if (itemId == R.id.nav_emergency) {
            selectedFragment = new EmergencyFragment();
        } else if (itemId == R.id.nav_tourism) {
            selectedFragment = new TourismFragment();
        } else if (itemId == R.id.nav_universities) {
            selectedFragment = new UniversitiesFragment();
        } else if (itemId == R.id.nav_geography) {
            selectedFragment = new GeographyFragment();
        } else if (itemId == R.id.nav_traffic) {
            selectedFragment = new TrafficRulesFragment();
        } else if (itemId == R.id.nav_visitor_info) {
            selectedFragment = new VisitorInfoFragment();
        }

        if (selectedFragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, selectedFragment);
            transaction.commit();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

