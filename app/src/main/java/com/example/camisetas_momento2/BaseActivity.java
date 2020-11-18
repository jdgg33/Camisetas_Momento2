package com.example.camisetas_momento2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.camisetas_momento2.adapters.CamisetasAdapter;
import com.example.camisetas_momento2.conection.FirebaseConnection;
import com.example.camisetas_momento2.models.CamisetasModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    protected CamisetasModel model;
    protected ArrayList<CamisetasModel> modelArrayList;
    protected CamisetasAdapter adapter;

    protected FirebaseFirestore db;
    protected FirebaseAuth mAuth;
    protected FirebaseStorage mFirebaseStorage;
    //protected StorageReference mStorageRef;

    protected Query query;
    protected CollectionReference collectionReference;
    protected StorageReference mStorageReference, fileReference;

    protected final String COLLECTION_NAME = "Camisetas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    protected void init() {
        model = new CamisetasModel();
        db = FirebaseConnection.ConnectionFirestore();
        mAuth = FirebaseConnection.ConnectionAuth();
        mFirebaseStorage = FirebaseConnection.ConnectionStorage();
        collectionReference = db.collection(COLLECTION_NAME);
    }

    protected void makeSimpleToast(String message, int duration) {
        Toast.makeText(this, message, duration).show();
    }

    protected void makeSimpleAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog =builder.create();
        dialog.show();

    }

    protected void goToList(){
        Intent intent =new Intent(this, BaseActivity.class);
        startActivity(intent);
    }
    protected void goToCreate(){
        Intent intent =new Intent(this, BaseActivity.class);
        startActivity(intent);
    }
    protected void goToEdit(){
        Intent intent =new Intent(this, BaseActivity.class);
        startActivity(intent);
    }
    protected void goToSearch(){
        Intent intent =new Intent(this, BaseActivity.class);
        startActivity(intent);
    }
    protected void goToDetail(CamisetasModel model){
        Intent intent =new Intent(this, DetailActivity.class);
        intent.putExtra("model", model);
        startActivity(intent);
    }
}