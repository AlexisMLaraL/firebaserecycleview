package com.misaelal.firebaserecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mEmail;
    private TextView mUser;
    private Button mBtbCrear;
    private Button mBtnshow;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.nombre);
        mEmail = findViewById(R.id.email);
        mUser = findViewById(R.id.user);
        mBtbCrear = findViewById(R.id.buttonC);

        mBtnshow = findViewById(R.id.mostrardb);

        mBtbCrear.setOnClickListener((v) -> {
            String nombre = mName.getText().toString();
            String email = mEmail.getText().toString();
            String user = mUser.getText().toString();

            HashMap<String, String> userMap = new HashMap<>();
            userMap.put("nombre", nombre);
            userMap.put("email", email);
            userMap.put("user", user);

            root.push().setValue(userMap).addOnCompleteListener(task -> {
                Toast.makeText(MainActivity.this, "Datos Guadados", Toast.LENGTH_SHORT).show();
            });
        });

        mBtnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowActivity.class));
            }
        });


    }
}