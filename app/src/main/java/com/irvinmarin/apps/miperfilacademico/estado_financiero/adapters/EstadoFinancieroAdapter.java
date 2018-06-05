package com.irvinmarin.apps.miperfilacademico.estado_financiero.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.estado_financiero.adapters.holders.EstadoFinancieroViewHolder;
import com.irvinmarin.apps.miperfilacademico.estado_financiero.ui.entities.CuotasUI;

import java.util.List;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class EstadoFinancieroAdapter extends RecyclerView.Adapter<EstadoFinancieroViewHolder> {

    private List<CuotasUI> cuotasUIList;


    public EstadoFinancieroAdapter(List<CuotasUI> cuotasUIList) {
        this.cuotasUIList = cuotasUIList;
    }

    @NonNull
    @Override
    public EstadoFinancieroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cuotas, parent, false);

        return new EstadoFinancieroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadoFinancieroViewHolder holder, int position) {

//        holder.bind(cursosUIList.get(position));

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
