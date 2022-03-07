package com.example.relatoriostcp.activity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.relatoriostcp.R;
import com.example.relatoriostcp.activity.RecyclerItemClickListener;
import com.example.relatoriostcp.activity.adapter.Adapter;
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
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button cadAtividade;
    private Button listAtividade;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abilitarPersistencia();

        cadAtividade = findViewById(R.id.regAtividade);
        listAtividade = findViewById(R.id.listAtividade);

        cadAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Activity_Formulario.class);
                startActivity( intent);
            }
        });

        listAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),Activity_Lista.class);
                startActivity( intent );
            }
        });


    }
    public void abilitarPersistencia(){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
