package com.jewel.usa_atlas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jewel.usa_atlas.R;
import com.jewel.usa_atlas.adapters.TouristDestinationAdapter;
import com.jewel.usa_atlas.models.TouristDestination;

import java.util.ArrayList;
import java.util.List;

public class TourismFragment extends Fragment {

    private RecyclerView recyclerView;
    private TouristDestinationAdapter adapter;
    private List<TouristDestination> destinationList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tourism, container, false);
        
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        
        destinationList = new ArrayList<>();
        loadDestinations();
        
        adapter = new TouristDestinationAdapter(destinationList);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private void loadDestinations() {
        // Sample data - in a real app, this would come from a database or API
        destinationList.add(new TouristDestination("Grand Canyon", "Arizona", 
                getString(R.string.grand_canyon_desc), R.drawable.map_usa));
        destinationList.add(new TouristDestination("Statue of Liberty", "New York", 
                getString(R.string.statue_liberty_desc), R.drawable.map_usa));
        destinationList.add(new TouristDestination("Walt Disney World", "Florida", 
                getString(R.string.disney_world_desc), R.drawable.map_usa));
        destinationList.add(new TouristDestination("Golden Gate Bridge", "California", 
                getString(R.string.golden_gate_desc), R.drawable.map_usa));
        destinationList.add(new TouristDestination("Yellowstone", "Wyoming", 
                getString(R.string.yellowstone_desc), R.drawable.map_usa));
        destinationList.add(new TouristDestination("Las Vegas Strip", "Nevada", 
                getString(R.string.las_vegas_desc), R.drawable.map_usa));
        destinationList.add(new TouristDestination("Times Square", "New York", 
                getString(R.string.times_square_desc), R.drawable.map_usa));
        destinationList.add(new TouristDestination("Niagara Falls", "New York", 
                getString(R.string.niagara_falls_desc), R.drawable.map_usa));
    }
}

