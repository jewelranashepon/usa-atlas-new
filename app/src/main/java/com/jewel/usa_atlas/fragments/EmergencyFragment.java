package com.jewel.usa_atlas.fragments;

import android.content.Intent;
import android.net.Uri;
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
import com.jewel.usa_atlas.adapters.EmergencyAdapter;
import com.jewel.usa_atlas.models.Emergency;

import java.util.ArrayList;
import java.util.List;

public class EmergencyFragment extends Fragment implements EmergencyAdapter.OnEmergencyClickListener {

    private RecyclerView recyclerView;
    private EmergencyAdapter adapter;
    private List<Emergency> emergencyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emergency, container, false);
        
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        emergencyList = new ArrayList<>();
        loadEmergencyServices();
        
        adapter = new EmergencyAdapter(emergencyList, this);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private void loadEmergencyServices() {
        // Sample data - in a real app, this would come from a database or API
        emergencyList.add(new Emergency("911", getString(R.string.emergency_services), 
                getString(R.string.emergency_services_desc), "tel:911"));
        emergencyList.add(new Emergency("211", getString(R.string.community_services), 
                getString(R.string.community_services_desc), "tel:211"));
        emergencyList.add(new Emergency("1-800-222-1222", getString(R.string.poison_control), 
                getString(R.string.poison_control_desc), "tel:18002221222"));
        emergencyList.add(new Emergency("988", getString(R.string.suicide_prevention), 
                getString(R.string.suicide_prevention_desc), "tel:988"));
        emergencyList.add(new Emergency("1-866-331-9474", getString(R.string.dating_abuse_helpline), 
                getString(R.string.dating_abuse_helpline_desc), "tel:18663319474"));
        emergencyList.add(new Emergency("1-800-621-FEMA", getString(R.string.fema), 
                getString(R.string.fema_desc), "tel:18006213362"));
    }

    @Override
    public void onEmergencyClick(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phoneNumber));
        startActivity(intent);
    }
}

