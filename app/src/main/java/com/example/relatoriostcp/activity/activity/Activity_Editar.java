package com.example.relatoriostcp.activity.activity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.relatoriostcp.R;
import com.example.relatoriostcp.activity.model.Atividade;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Activity_Editar extends AppCompatActivity {

    private TextView responsavel;
    private TextView talhao;
    private TextView editAtividade;
    private TextView editSubAtividade;
    private EditText unidade;
    private EditText producao;
    private EditText numColaboradores;
    private EditText obs;
    private Button horainiProd;
    private Button horafimProd;
    private Button btnEditar;
    private Button btndeslocini;
    private Button btndeslocfim;
    private Button btnalmocoini;
    private Button btnalmocofim;
    int hora,minutos;
    List<Atividade> atividades;

    //Hora atual do inicio do registro
    public Date agora = new Date();
    public String horainiciodoRegistro = new SimpleDateFormat("HH:mm:ss").format(agora);


    public String _01BEM0118 = "01BEM0118";
    public String _01NES0719 = "01NES0719";
    public String _07UBI0119 = "07UBI0119";
    public String _07AQL0119 = "07AQL0119";

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference lista = reference.child("id");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        responsavel = findViewById(R.id.textoResponsavel);
        talhao = findViewById(R.id.textTalhaoEdit);
        editAtividade = findViewById(R.id.textoAtividade);
        editSubAtividade = findViewById(R.id.textoSubAtividade);
        unidade = findViewById(R.id.textUnidadeEdit);
        producao = findViewById(R.id.textProducaoEdit);
        numColaboradores = findViewById(R.id.textColaboradoresEdit);
        obs = findViewById(R.id.textObsEdit);
        horainiProd = findViewById(R.id.btnHoraIniEdit);
        horafimProd = findViewById(R.id.btnHoraFimEdit);
        btndeslocini = findViewById(R.id.btnDeslociniEdit);
        btndeslocfim = findViewById(R.id.btnDeslocFimEdit);
        btnalmocoini = findViewById(R.id.btnAlmocoiniEdit);
        btnalmocofim = findViewById(R.id.btnAlmocofimEdit);
        btnEditar = findViewById(R.id.btnEdiatar);

        horainiProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);
                final TimePickerDialog timePickerDialog =new TimePickerDialog(Activity_Editar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Toast.makeText(Activity_Formulario.this, ""+ hourOfDay + ":" + minute,Toast.LENGTH_LONG).show();
                        horainiProd.setText(hourOfDay + ":"+ minute);
                    }
                }, hora,minutos,false);
                timePickerDialog.show();
                String value = timePickerDialog.toString();

            }
        });
        horafimProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);
                final TimePickerDialog timePickerDialog =new TimePickerDialog(Activity_Editar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Toast.makeText(Activity_Formulario.this, ""+ hourOfDay + ":" + minute,Toast.LENGTH_LONG).show();
                        horafimProd.setText(hourOfDay + ":"+ minute);
                    }
                }, hora,minutos,false);
                timePickerDialog.show();
                String value = timePickerDialog.toString();
            }
        });
        btndeslocini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);
                final TimePickerDialog timePickerDialog =new TimePickerDialog(Activity_Editar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Toast.makeText(Activity_Formulario.this, ""+ hourOfDay + ":" + minute,Toast.LENGTH_LONG).show();
                        btndeslocini.setText(hourOfDay + ":"+ minute);
                    }
                }, hora,minutos,false);
                timePickerDialog.show();
                String value = timePickerDialog.toString();
            }
        });
        btndeslocfim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);
                final TimePickerDialog timePickerDialog =new TimePickerDialog(Activity_Editar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Toast.makeText(Activity_Formulario.this, ""+ hourOfDay + ":" + minute,Toast.LENGTH_LONG).show();
                        btndeslocfim.setText(hourOfDay + ":"+ minute);
                    }
                }, hora,minutos,false);
                timePickerDialog.show();
                String value = timePickerDialog.toString();
            }
        });
        btnalmocoini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);
                final TimePickerDialog timePickerDialog =new TimePickerDialog(Activity_Editar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Toast.makeText(Activity_Formulario.this, ""+ hourOfDay + ":" + minute,Toast.LENGTH_LONG).show();
                        btnalmocoini.setText(hourOfDay + ":"+ minute);
                    }
                }, hora,minutos,false);
                timePickerDialog.show();
                String value = timePickerDialog.toString();
            }
        });
        btnalmocofim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);
                final TimePickerDialog timePickerDialog =new TimePickerDialog(Activity_Editar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Toast.makeText(Activity_Formulario.this, ""+ hourOfDay + ":" + minute,Toast.LENGTH_LONG).show();
                        btnalmocofim.setText(hourOfDay + ":"+ minute);
                    }
                }, hora,minutos,false);
                timePickerDialog.show();
                String value = timePickerDialog.toString();
            }
        });


        if (getIntent().hasExtra("id")) {
            Bundle extras = getIntent().getExtras();
            DatabaseReference item = reference.child("teste").child(extras.getString("id"));

            item.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Atividade atividade = dataSnapshot.getValue(Atividade.class);
                    Atividade test = dataSnapshot.getValue(Atividade.class);
                    responsavel.setText(atividade.get_05_responsavel());
                    talhao.setText(atividade.get_06_talhao());
                    editAtividade.setText(atividade.get_07_atividade());
                    editSubAtividade.setText(atividade.get_08_subatividade());
                    producao.setText(atividade.get_09_producao());
                    unidade.setText(atividade.get_10_unidade());
                    numColaboradores.setText(atividade.get_11_numcolaboradores());
                    horainiProd.setText(atividade.get_12_horainiprod());
                    horafimProd.setText(atividade.get_13_horafimprod());
                    obs.setText(atividade.get_14_observacao());
                    btndeslocini.setText(atividade.get_15_deslocini());
                    btndeslocfim.setText(atividade.get_16_deslocfim());
                    btnalmocoini.setText(atividade.get_17_almocoini());
                    btnalmocofim.setText(atividade.get_18_almocofim());
                    Log.i(test.get_01_data(),"FIREBASE");

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
            reference.keepSynced(true);
            atividades = new ArrayList<>();

            btnEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Editar();
                    if (getIntent().hasExtra("id")) {
                        Bundle extras = getIntent().getExtras();
                        DatabaseReference item = reference.child("teste").child(extras.getString("id"));
                        item.updateChildren(toMap());
                    }

                    finish();
                    Toast.makeText(Activity_Editar.this, "Alterado com Sucesso",Toast.LENGTH_LONG).show();
                }
            });
        }

        //Recadastra itens
        public Map<String, Object> toMap () {
            HashMap<String, Object> result = new HashMap<>();
            result.put("_06_talhao", talhao.getText().toString());
            result.put("_09_producao", producao.getText().toString());
            result.put("_10_unidade", unidade.getText().toString());
            result.put("_11_numcolaboradores", numColaboradores.getText().toString());
            result.put("_12_horainiprod", horainiProd.getText().toString());
            result.put("_13_horafimprod", horafimProd.getText().toString());
            result.put("_14_observacao", obs.getText().toString());
            result.put("_15_deslocini",horainiProd.getText().toString());
            result.put("_16_deslocfim",horafimProd.getText().toString());
            result.put("_17_almocoini",btnalmocoini.getText().toString());
            result.put("_18_almocofim",btnalmocofim.getText().toString());
            return result;
        }

    /*
    public void Editar() {
        if (getIntent().hasExtra("id")) {
            Bundle extras = getIntent().getExtras();
            DatabaseReference item = reference.child("teste").child(extras.getString("id"));
            item.updateChildren(toMap());

        }
    }

     */
    }
