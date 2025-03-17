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
import com.jewel.usa_atlas.StateDetailActivity;
import com.jewel.usa_atlas.models.State;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {

    private List<State> stateList;

    public StateAdapter(List<State> stateList) {
        this.stateList = stateList;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.state_item, parent, false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, int position) {
        State state = stateList.get(position);
        holder.stateName.setText(state.getName());
        holder.stateCapital.setText(holder.itemView.getContext().getString(R.string.capital_label, state.getCapital()));
        holder.statePopulation.setText(holder.itemView.getContext().getString(R.string.population_label, state.getPopulation()));
        holder.stateFlag.setImageResource(state.getFlagResource());
        
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), StateDetailActivity.class);
            intent.putExtra("STATE_NAME", state.getName());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    public static class StateViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView stateName;
        TextView stateCapital;
        TextView statePopulation;
        ImageView stateFlag;

        public StateViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            stateName = itemView.findViewById(R.id.state_name);
            stateCapital = itemView.findViewById(R.id.state_capital);
            statePopulation = itemView.findViewById(R.id.state_population);
            stateFlag = itemView.findViewById(R.id.state_flag);
        }
    }
}

