package com.example.relatoriostcp.activity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.relatoriostcp.R;
import com.example.relatoriostcp.activity.fragment.FormularioFragment;
import com.example.relatoriostcp.activity.fragment.FotoFragment;
import com.example.relatoriostcp.activity.fragment.MapaFragment;
import com.example.relatoriostcp.activity.model.Atividade;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Activity_Formulario extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int hora,minutos;
    private Button btnFormFragment,btnFotoFragment,btnMapaFragment;
    private FormularioFragment formFragment;
    private FotoFragment fotoFragment;
    private MapaFragment mapaFragment;

    //Hora atual do inicio do registro
    public Date agora = new Date();
    public String horainiciodoRegistro = new SimpleDateFormat("HH:mm:ss").format(agora);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__formulario);
        getSupportActionBar().setElevation(0);
        btnFormFragment = findViewById(R.id.btnFormFragment);
        btnFotoFragment = findViewById(R.id.btnFotoFragment);
        btnMapaFragment = findViewById(R.id.btnMapaFragment);

        //setar configuracao pardrao na tela do fragment
        formFragment = new FormularioFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.conteudoFragment, formFragment);
        transaction.commit();
        //evento de troca de fragment
        btnFormFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formFragment = new FormularioFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.conteudoFragment, formFragment);
                transaction.commit();

            }
        });
        //eventro de toca entre fragments
        btnFotoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fotoFragment = new FotoFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.conteudoFragment, fotoFragment);
                transaction.commit();
            }
        });
        //evento de troca entre fragments
        btnMapaFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapaFragment = new MapaFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.conteudoFragment, mapaFragment);
                transaction.commit();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
