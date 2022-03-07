package com.example.relatoriostcp.activity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.relatoriostcp.R;
import com.example.relatoriostcp.activity.RecyclerItemClickListener;
import com.example.relatoriostcp.activity.adapter.Adapter;
import com.example.relatoriostcp.activity.model.Atividade;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventListener;
import java.util.List;
import java.util.Locale;

public class Activity_Lista extends AppCompatActivity {

    private RecyclerView recyclerView;
    public List<Atividade> listaAtividade = new ArrayList<>();
    List<Atividade> atividades;

    public String _01BEM0118 = "01BEM0118";
    public String _01NES0719 = "01NES0719";
    public String _07UBI0119 = "07UBI0119";
    public String _07AQL0119 = "07AQL0119";


    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference lista = reference.child("teste");

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    //opcoes menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_atualiza:
                recreate();
                Toast toast = Toast.makeText(getApplicationContext(),"Lista Atualizada",Toast.LENGTH_LONG);
                toast.show();
                return true;
            case R.id.menu_exportar:
                export();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    //utilizar metodo on start para nao duplicar lista , no oncreate estava duplicando
    @Override
    protected void onStart() {
        super.onStart();
        listaAtividade.clear();
        atividades.clear();
        this.CriarLista();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lista);

        reference.keepSynced(true);
        recyclerView = findViewById(R.id.recyclerView);
        atividades = new ArrayList<>();
        atividades.clear();
        //this.CriarLista();

        final Adapter adapter = new Adapter( listaAtividade , this);

        //Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapter);



        //Evento de clicke
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, final int position) {

                                Atividade atividade = atividades.get(position);

                                Intent intent = new Intent(getApplicationContext(),Activity_Editar.class);
                                String value = atividade.get_id();
                                intent.putExtra("id", value);
                                startActivity(intent);
                                //Toast toast = Toast.makeText(getApplicationContext(),""+atividade.get_id()+"",Toast.LENGTH_LONG);
                                //toast.show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                //delItem(position);

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }


    public void CriarLista(){

        //Lista

        lista.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                listaAtividade.clear();


                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Atividade atividade = postSnapshot.getValue(Atividade.class);
                    atividades.add(atividade);
                    Log.i(postSnapshot.getKey(),"FIREBASE");
                }

                Adapter atividadeAdapter = new Adapter(atividades, Activity_Lista.this);
                recyclerView.setAdapter(atividadeAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.i("FIREBASE" , databaseError.getMessage());

            }
        });
    }

    public void delItem(final int position){
        lista.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Atividade atividade = atividades.get(position);

                dataSnapshot.getRef().child(atividade.get_id()).removeValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void export(){
        //dados

        final StringBuilder data = new StringBuilder();
        data.append("Data"+ "," + "Semana" + "," + "Hora inicio Cadastro" + "," + "Hora Fim Cadastro" + "," + "Responsavel" + "," + "Talhão" + "," + "Atividade"
                + "," + "SubAtividade" + "," + "Prodção" + "," + "Unidade" + "," + "Numero De Colaboradores" + "," + "Hora inicio Produção" + "," + "Hora Fim Produção"
                + "," + "Deslocamento Inicio" + "," + "Deslocamento Fim" + "," + "Inicio Almoço" + "," + "Fim Almoço" + "," + "Observaçoes");
        data.append("\n");  
        for (Atividade s : atividades){

            data.append(s.get_01_data() + "," + s.get_02_semana() + "," + s.get_03_horainicioCadastro()+ "," + s.get_04_horafimCadastro()+ "," + s.get_05_responsavel()
                    + "," + s.get_06_talhao()+ "," + s.get_07_atividade()+ "," + s.get_08_subatividade()+ "," +s.get_09_producao()+ "," +s.get_10_unidade()+ "," +s.get_11_numcolaboradores()
                    + "," +s.get_12_horainiprod()+ "," +s.get_13_horafimprod()+ "," +s.get_15_deslocini()+ "," +s.get_16_deslocfim()+ "," +s.get_17_almocoini()+ "," +s.get_18_almocofim()
                    + "," +s.get_14_observacao());
            data.append("\n");
        }
            //Toast toast = Toast.makeText(getApplicationContext(),""+atividades+"",Toast.LENGTH_LONG);
            //toast.show();

        try{
            FileOutputStream out = openFileOutput("data.csv", Context.MODE_PRIVATE);
            out.write((data.toString().getBytes()));
            out.close();

            Context context = getApplicationContext();
            File filelocation = new File(getFilesDir(), "data.csv");
            Uri path = FileProvider.getUriForFile(context,"com.example.relatoriostcp",filelocation);
            Intent fileintent = new Intent(Intent.ACTION_SEND);
            fileintent.setType("text/csv");
            fileintent.putExtra(Intent.EXTRA_SUBJECT,"Relatorio" );
            fileintent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            fileintent.putExtra(Intent.EXTRA_STREAM, path);
            startActivity(Intent.createChooser(fileintent, "send mail"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
