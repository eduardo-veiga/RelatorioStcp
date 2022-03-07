package com.example.relatoriostcp.activity.fragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.relatoriostcp.R;
import com.example.relatoriostcp.activity.activity.Activity_Formulario;
import com.example.relatoriostcp.activity.activity.MainActivity;
import com.example.relatoriostcp.activity.model.Atividade;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FormularioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormularioFragment extends Fragment {

    private EditText editTextSemana;
    private EditText editTextData;
    private EditText responsavel;
    private EditText talhao;
    private EditText editAtividade;
    private EditText editSubAtividade;
    private EditText unidade;
    private EditText producao;
    private EditText numColaboradores;
    private EditText obs;
    private EditText horaini;
    private EditText horafim;
    private EditText horainiProd;
    private EditText horafimProd;
    private Button btn_Foto;
    private ImageView imgview;
    private Button btnSalvar;
    private Button btnhoraini;
    private Button btnhorafim;
    private Button btndeslocini;
    private Button btndeslocfim;
    private Button btnalmocoini;
    private Button btnalmocofim;
    int hora,minutos;
    private Button btnFormFragment,btnFotoFragment,btnMapaFragment;
    private FormularioFragment formFragment;
    private FotoFragment fotoFragment;
    private MapaFragment mapaFragment;

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference cadastros = reference.child("teste");

    //Hora atual do inicio do registro
    public Date agora = new Date();
    public String horainiciodoRegistro = new SimpleDateFormat("HH:mm:ss").format(agora);


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FormularioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FormularioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FormularioFragment newInstance(String param1, String param2) {
        FormularioFragment fragment = new FormularioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_formulario, container, false);
        responsavel = view.findViewById(R.id.textResponsavel);
        talhao = view.findViewById(R.id.textTalhao);
        editAtividade = view.findViewById(R.id.textAtividade);
        editSubAtividade = view.findViewById(R.id.textSubAtividade);
        unidade = view.findViewById(R.id.textUnidade);
        producao = view.findViewById(R.id.textProducao);
        numColaboradores = view.findViewById(R.id.textColaboradores);
        obs = view.findViewById(R.id.textObs);
        btnSalvar = view.findViewById(R.id.saveButton2);
        btnhoraini = view.findViewById(R.id.btnHoraIni);
        btnhorafim = view.findViewById(R.id.BtnHoraFim);
        btndeslocini = view.findViewById(R.id.btnDeslocini);
        btndeslocfim = view.findViewById(R.id.btnDeslocFim);
        btnalmocoini = view.findViewById(R.id.btnAlmocoini);
        btnalmocofim = view.findViewById(R.id.btnAlmocofim);

        btnhorafim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);
                final TimePickerDialog timePickerDialog =new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Toast.makeText(Activity_Formulario.this, ""+ hourOfDay + ":" + minute,Toast.LENGTH_LONG).show();
                        btnhorafim.setText(hourOfDay + ":"+ minute);
                    }
                }, hora,minutos,false);
                timePickerDialog.show();
                String value = timePickerDialog.toString();

            }
        });
        btnhoraini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);
                final TimePickerDialog timePickerDialog =new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Toast.makeText(Activity_Formulario.this, ""+ hourOfDay + ":" + minute,Toast.LENGTH_LONG).show();
                        btnhoraini.setText(hourOfDay + ":"+ minute);
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
                final TimePickerDialog timePickerDialog =new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
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
                final TimePickerDialog timePickerDialog =new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
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
                final TimePickerDialog timePickerDialog =new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
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
                final TimePickerDialog timePickerDialog =new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
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

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(responsavel.getText())){
                    Toast.makeText(getContext(), "Favor Digitar o Responsavel",Toast.LENGTH_LONG).show();
                    responsavel.setError("Favor digitar o responsavel");
                    return;
                }else {
                    if (TextUtils.isEmpty(editAtividade.getText())){
                        Toast.makeText(getContext(), "Favor Preenche a Atividade",Toast.LENGTH_LONG).show();
                        editAtividade.setError("Favor Preencher a Atividade");
                        return;
                    }else {
                        if (TextUtils.isEmpty(editSubAtividade.getText())){
                            Toast.makeText(getContext(), "Favor preencher a SubAtividade",Toast.LENGTH_LONG).show();
                            editSubAtividade.setError("Favor Preencher a SubAtividade");
                            return;
                        }else {
                            Intent intent = new Intent(getContext(), MainActivity.class);
                            addTarefa();
                            Toast.makeText(getContext(), "Salvo com Sucesso",Toast.LENGTH_LONG).show();
                            limparDados();
                        }
                    }

                }
            }
        });
        return view;
    }
    public void addTarefa() {

        //Data atual
        final String currentTime = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

        //Hora atual do fim do registro
        Date agora = new Date();
        String horaagora = new SimpleDateFormat("HH:mm:ss").format(agora);


        //Semana
        final Calendar calendar = Calendar.getInstance();
        final int c = calendar.get(Calendar.WEEK_OF_YEAR);

        String id = cadastros.push().getKey();
        //String id = cadastros.child(currentTime1).getKey();


        final Atividade atividade = new Atividade(
                id,
                currentTime,
                c + "",
                responsavel.getText().toString().toUpperCase(),
                talhao.getText().toString().toUpperCase(),
                editAtividade.getText().toString().toUpperCase(),
                editSubAtividade.getText().toString().toUpperCase(),
                unidade.getText().toString(),
                producao.getText().toString(),
                numColaboradores.getText().toString(),
                horainiciodoRegistro,
                horaagora,
                btnhoraini.getText().toString(),
                btnhorafim.getText().toString(),
                //horafimProd.getText().toString(),
                obs.getText().toString(),
                btndeslocini.getText().toString(),
                btndeslocfim.getText().toString(),
                btnalmocoini.getText().toString(),
                btnalmocofim.getText().toString()

        );

        cadastros.child(id).setValue(atividade);


    }
    public void limparDados(){

        responsavel.setText("");
        talhao.setText("");
        editAtividade.setText("");
        editSubAtividade.setText("");
        unidade.setText("");
        producao.setText("");
        numColaboradores.setText("");
        obs.setText("");
        btnhoraini.setText("Inicio Produção");
        btnhorafim.setText("Fim Produção");
        btndeslocini.setText("Inicio Deslocamento");
        btndeslocfim.setText("Fim Deslocamento");
        btnalmocoini.setText("Inicio Almoço");
        btnalmocofim.setText("Fim Almoço");

    }
}