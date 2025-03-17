package com.jewel.usa_atlas.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jewel.usa_atlas.DestinationDetailActivity;
import com.jewel.usa_atlas.R;
import com.jewel.usa_atlas.models.TouristDestination;

import java.util.List;

public class TouristDestinationAdapter extends RecyclerView.Adapter<TouristDestinationAdapter.DestinationViewHolder> {

    private List<TouristDestination> destinationList;

    public TouristDestinationAdapter(List<TouristDestination> destinationList) {
        this.destinationList = destinationList;
    }

    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.destination_item, parent, false);
        return new DestinationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder holder, int position) {
        TouristDestination destination = destinationList.get(position);
        holder.destinationName.setText(destination.getName());
        holder.destinationLocation.setText(destination.getLocation());
        holder.destinationImage.setImageResource(destination.getImageResource());
        
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DestinationDetailActivity.class);
            intent.putExtra("DESTINATION_NAME", destination.getName());
            intent.putExtra("DESTINATION_LOCATION", destination.getLocation());
            intent.putExtra("DESTINATION_DESCRIPTION", destination.getDescription());
            intent.putExtra("DESTINATION_IMAGE", destination.getImageResource());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public static class DestinationViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView destinationImage;
        TextView destinationName;
        TextView destinationLocation;

        public DestinationViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            destinationImage = itemView.findViewById(R.id.destination_image);
            destinationName = itemView.findViewById(R.id.destination_name);
            destinationLocation = itemView.findViewById(R.id.destination_location);
        }
    }
}

