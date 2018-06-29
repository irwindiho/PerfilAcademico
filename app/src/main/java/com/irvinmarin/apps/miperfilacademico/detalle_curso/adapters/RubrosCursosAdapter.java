package com.irvinmarin.apps.miperfilacademico.detalle_curso.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.detalle_curso.adapters.holders.RubrosViewHolder;
import com.irvinmarin.apps.miperfilacademico.detalle_curso.entities.RubrosUI;

import java.util.List;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class RubrosCursosAdapter extends RecyclerView.Adapter<RubrosViewHolder> {


    private List<RubrosUI> rubrosUIList;


    public RubrosCursosAdapter(List<RubrosUI> rubrosUIList) {
        this.rubrosUIList = rubrosUIList;
    }

    @NonNull
    @Override
    public RubrosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rubros, parent, false);

        return new RubrosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RubrosViewHolder holder, int position) {

        holder.bind(rubrosUIList.get(position));

    }

    @Override
    public int getItemCount() {
        return rubrosUIList.size();
//        return 7;
    }

    public void setListCiclos(List<RubrosUI> rubrosUIList) {
        this.rubrosUIList.clear();
        this.rubrosUIList.addAll(rubrosUIList);
        notifyDataSetChanged();
    }


}


