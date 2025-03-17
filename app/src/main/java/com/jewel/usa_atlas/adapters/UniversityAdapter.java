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

import com.jewel.usa_atlas.R;
import com.jewel.usa_atlas.UniversityDetailActivity;
import com.jewel.usa_atlas.models.University;

import java.util.List;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder> {

    private List<University> universityList;

    public UniversityAdapter(List<University> universityList) {
        this.universityList = universityList;
    }

    @NonNull
    @Override
    public UniversityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.university_item, parent, false);
        return new UniversityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityViewHolder holder, int position) {
        University university = universityList.get(position);
        holder.universityName.setText(university.getName());
        holder.universityLocation.setText(university.getLocation());
        holder.universityDescription.setText(university.getDescription());
        holder.universityImage.setImageResource(university.getImageResource());
        
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), UniversityDetailActivity.class);
            intent.putExtra("UNIVERSITY_NAME", university.getName());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return universityList.size();
    }

    public static class UniversityViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView universityImage;
        TextView universityName;
        TextView universityLocation;
        TextView universityDescription;

        public UniversityViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            universityImage = itemView.findViewById(R.id.university_image);
            universityName = itemView.findViewById(R.id.university_name);
            universityLocation = itemView.findViewById(R.id.university_location);
            universityDescription = itemView.findViewById(R.id.university_description);
        }
    }
}

