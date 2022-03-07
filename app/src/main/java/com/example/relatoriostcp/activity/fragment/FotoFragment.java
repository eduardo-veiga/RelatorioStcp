package com.example.relatoriostcp.activity.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.relatoriostcp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FotoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FotoFragment extends Fragment {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference cadastros = reference.child("teste");

    private ImageView imgview;
    public ImageView btn_Foto;
    public TextView text_img;

    String currentPhotoPath;

    static final int REQUEST_IMAGE_CAPTURE = 1;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FotoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fotosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FotoFragment newInstance(String param1, String param2) {
        FotoFragment fragment = new FotoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    //recuperar img e setar em uma view
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imgview.setImageBitmap(imgBitmap);

        }
        super.onActivityResult(requestCode, resultCode, data);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fotos, container, false);

        btn_Foto = view.findViewById(R.id.btn_foto);
        text_img = view.findViewById(R.id.text_img);
        imgview = view.findViewById(R.id.imageView2);
        //btn = view.findViewById(R.id.testebtnfoto);

        btn_Foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(getContext(),"Take aPikture",Toast.LENGTH_LONG).show();
               text_img.setText("Foto Registrada");
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

               //salvarFoto();
            }
        });

        return view;
    }
    public void salvarFoto() {

        //Hora atual da foto
        Date agora = new Date();
        String horaagora = new SimpleDateFormat("HH:mm:ss").format(agora);

        //Data atual do dia
        final String currentTime = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        FirebaseStorage storage = FirebaseStorage.getInstance();

        imgview.setDrawingCacheEnabled(true);
        imgview.buildDrawingCache();

        Bitmap bitmap = ((BitmapDrawable) imgview.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();
        //storage.getReference().child("img/"+ currentTime +"-" + horaagora + ".png" ).putBytes(data);
        storage.getReference().child( "teste" + "/" + currentTime +"-" + horaagora + ".png" )
                .putBytes(data)
                .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        FirebaseStorage stor = FirebaseStorage.getInstance();
        StorageReference storeRef = stor.getReference();
        StorageReference imgRef = storeRef.child("teste.jpg");
        StorageReference imagesRef = storeRef.child("imagem/teste.jpg");
        imgview.setDrawingCacheEnabled(true);
        imgview.buildDrawingCache();
        Bitmap bitmapimg = ((BitmapDrawable) imgview.getDrawable()).getBitmap();
        ByteArrayOutputStream baosimg = new ByteArrayOutputStream();
        bitmapimg.compress(Bitmap.CompressFormat.JPEG, 100, baosimg);
        byte[] dataimg = baosimg.toByteArray();
        UploadTask uploadTask = imgRef.putBytes(dataimg);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

            }
        });
    }

    private void createImageFile() throws IOException{
        String timestamp = new SimpleDateFormat("yyyMMdd").format(new Date());
        String imageFileName = "JPEG" + timestamp + "_";
        //File storageDit = getExternalFilesDir
    }
}