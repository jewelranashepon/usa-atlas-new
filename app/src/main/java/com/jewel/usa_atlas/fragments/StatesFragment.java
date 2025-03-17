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
import com.jewel.usa_atlas.adapters.StateAdapter;
import com.jewel.usa_atlas.models.State;

import java.util.ArrayList;
import java.util.List;

public class StatesFragment extends Fragment {

    private RecyclerView recyclerView;
    private StateAdapter adapter;
    private List<State> stateList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_states, container, false);
        
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        stateList = new ArrayList<>();
        loadStates();
        
        adapter = new StateAdapter(stateList);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private void loadStates() {
        // Sample data - in a real app, this would come from a database or API
        stateList.add(new State("Alabama", "Montgomery", "4.9 million", "52,420 sq mi", R.drawable.ic_education));
        stateList.add(new State("Alaska", "Juneau", "0.7 million", "665,384 sq mi", R.drawable.map_usa));
        stateList.add(new State("Arizona", "Phoenix", "7.2 million", "113,990 sq mi", R.drawable.map_usa));
        stateList.add(new State("Arkansas", "Little Rock", "3.0 million", "53,179 sq mi", R.drawable.map_usa));
        stateList.add(new State("California", "Sacramento", "39.5 million", "163,696 sq mi", R.drawable.map_usa));
        stateList.add(new State("Colorado", "Denver", "5.8 million", "104,094 sq mi", R.drawable.map_usa));
        stateList.add(new State("Connecticut", "Hartford", "3.6 million", "5,543 sq mi", R.drawable.map_usa));
        stateList.add(new State("Delaware", "Dover", "1.0 million", "2,489 sq mi", R.drawable.map_usa));
        stateList.add(new State("Florida", "Tallahassee", "21.5 million", "65,758 sq mi", R.drawable.map_usa));
        stateList.add(new State("Georgia", "Atlanta", "10.6 million", "59,425 sq mi", R.drawable.map_usa));
        // Add more states as needed
    }
}

