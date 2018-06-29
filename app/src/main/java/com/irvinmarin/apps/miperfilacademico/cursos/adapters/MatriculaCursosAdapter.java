package com.irvinmarin.apps.miperfilacademico.cursos.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.cursos.adapters.holders.MatriculaCursosViewHolder;
import com.irvinmarin.apps.miperfilacademico.cursos.ui.entities.CursosDetalleUI;

import java.util.List;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class MatriculaCursosAdapter extends RecyclerView.Adapter<MatriculaCursosViewHolder> {



    private List<CursosDetalleUI> cursosUIList;


    public MatriculaCursosAdapter(List<CursosDetalleUI> cursosUIList) {
        this.cursosUIList = cursosUIList;
    }

    @NonNull
    @Override
    public MatriculaCursosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cursos_detalle, parent, false);

        return new MatriculaCursosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatriculaCursosViewHolder holder, int position) {

        holder.bind(cursosUIList.get(position));

    }

    @Override
    public int getItemCount() {
        return cursosUIList.size();
    }

    public void setListCiclos(List<CursosDetalleUI> cursosUIList) {
        this.cursosUIList.clear();
        this.cursosUIList.addAll(cursosUIList);
        notifyDataSetChanged();
    }


}


