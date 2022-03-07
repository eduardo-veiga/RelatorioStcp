package com.example.relatoriostcp.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.relatoriostcp.R;
import com.example.relatoriostcp.activity.model.Atividade;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Atividade> atividades;
    private Context context;

    public Adapter(List<Atividade> listaAtividades, Context c) {

        this.atividades = listaAtividades;
        this.context = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista,parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Atividade atividade = atividades.get( position );
        holder.data.setText(atividade.get_01_data());
        holder.Semana.setText(atividade.get_02_semana());
        holder.atividade.setText(atividade.get_07_atividade());
        holder.subAtividade.setText(atividade.get_08_subatividade());

    }

    @Override
    public int getItemCount() {
        return atividades.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView data;
        TextView Semana;
        TextView atividade;
        TextView subAtividade;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            data = itemView.findViewById(R.id.textdata);
            Semana = itemView.findViewById(R.id.editTextSemana);
            atividade = itemView.findViewById(R.id.textAtividade);
            subAtividade = itemView.findViewById(R.id.textsubAtividade);


        }

    }
}


