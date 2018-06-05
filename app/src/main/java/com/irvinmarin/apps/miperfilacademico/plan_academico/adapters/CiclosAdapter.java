package com.irvinmarin.apps.miperfilacademico.plan_academico.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.plan_academico.adapters.holders.CiclosViewHolder;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CiclosUI;

import java.util.Date;
import java.util.List;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class CiclosAdapter extends RecyclerView.Adapter<CiclosViewHolder> {


    private final String TAG = this.getClass().getSimpleName();
    private List<CiclosUI> ciclosUIList;


    public CiclosAdapter(List<CiclosUI> ciclosUIList) {
        this.ciclosUIList = ciclosUIList;
    }

    @NonNull
    @Override
    public CiclosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ciclos, parent, false);

        return new CiclosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CiclosViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder init time: " + new Date().getTime());

        holder.bind(new CiclosUI(), position);

    }

    @Override
    public int getItemCount() {
//        return ciclosUIList.size();
        return 5;
    }


}
