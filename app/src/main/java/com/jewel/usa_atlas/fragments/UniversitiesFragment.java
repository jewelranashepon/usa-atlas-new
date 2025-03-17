package com.jewel.usa_atlas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jewel.usa_atlas.R;
import com.jewel.usa_atlas.adapters.UniversityAdapter;
import com.jewel.usa_atlas.models.University;

import java.util.ArrayList;
import java.util.List;

public class UniversitiesFragment extends Fragment {

    private RecyclerView recyclerView;
    private UniversityAdapter adapter;
    private List<University> universityList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_universities, container, false);
        
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        universityList = new ArrayList<>();
        loadUniversities();
        
        adapter = new UniversityAdapter(universityList);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private void loadUniversities() {
        // Sample data - in a real app, this would come from a database or API
        universityList.add(new University("Harvard University", "Cambridge, MA", 
                getString(R.string.harvard_desc), R.drawable.map_usa));
        universityList.add(new University("Stanford University", "Stanford, CA", 
                getString(R.string.stanford_desc), R.drawable.map_usa));
        universityList.add(new University("MIT", "Cambridge, MA", 
                getString(R.string.mit_desc), R.drawable.map_usa));
        universityList.add(new University("Yale University", "New Haven, CT", 
                getString(R.string.yale_desc), R.drawable.map_usa));
        universityList.add(new University("Princeton University", "Princeton, NJ", 
                getString(R.string.princeton_desc), R.drawable.map_usa));
        universityList.add(new University("Columbia University", "New York, NY", 
                getString(R.string.columbia_desc), R.drawable.map_usa));
        universityList.add(new University("University of Chicago", "Chicago, IL", 
                getString(R.string.chicago_desc), R.drawable.map_usa));
        universityList.add(new University("University of California, Berkeley", "Berkeley, CA", 
                getString(R.string.berkeley_desc), R.drawable.map_usa));
    }
}

