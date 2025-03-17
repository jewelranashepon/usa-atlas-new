package com.jewel.usa_atlas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jewel.usa_atlas.R;
import com.jewel.usa_atlas.models.Emergency;

import java.util.List;

public class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.EmergencyViewHolder> {

    private List<Emergency> emergencyList;
    private OnEmergencyClickListener listener;

    public interface OnEmergencyClickListener {
        void onEmergencyClick(String phoneNumber);
    }

    public EmergencyAdapter(List<Emergency> emergencyList, OnEmergencyClickListener listener) {
        this.emergencyList = emergencyList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmergencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emergency_item, parent, false);
        return new EmergencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmergencyViewHolder holder, int position) {
        Emergency emergency = emergencyList.get(position);
        holder.emergencyNumber.setText(emergency.getNumber());
        holder.emergencyName.setText(emergency.getName());
        holder.emergencyDescription.setText(emergency.getDescription());
        
        holder.callButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onEmergencyClick(emergency.getPhoneUri());
            }
        });
    }

    @Override
    public int getItemCount() {
        return emergencyList.size();
    }

    public static class EmergencyViewHolder extends RecyclerView.ViewHolder {
        TextView emergencyNumber;
        TextView emergencyName;
        TextView emergencyDescription;
        Button callButton;

        public EmergencyViewHolder(@NonNull View itemView) {
            super(itemView);
            emergencyNumber = itemView.findViewById(R.id.emergency_number);
            emergencyName = itemView.findViewById(R.id.emergency_name);
            emergencyDescription = itemView.findViewById(R.id.emergency_description);
            callButton = itemView.findViewById(R.id.call_button);
        }
    }
}

