package com.irvinmarin.apps.miperfilacademico.plan_academico.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CursosUI;
import com.irvinmarin.apps.miperfilacademico.plan_academico.adapters.holders.CursosViewHolder;

import java.util.List;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class CursosAdapter extends RecyclerView.Adapter<CursosViewHolder> {


    private List<CursosUI> cursosUIList;


    public CursosAdapter(List<CursosUI> cursosUIList) {
        this.cursosUIList = cursosUIList;
    }

    @NonNull
    @Override
    public CursosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cursos_plan_academico, parent, false);

        return new CursosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CursosViewHolder holder, int position) {

        holder.bind(cursosUIList.get(position));

    }

    @Override
    public int getItemCount() {
        return cursosUIList.size();
    }

    public void setListCiclos(List<CursosUI> cursosUIList) {
        this.cursosUIList.clear();
        this.cursosUIList.addAll(cursosUIList);
        notifyDataSetChanged();
    }

}


