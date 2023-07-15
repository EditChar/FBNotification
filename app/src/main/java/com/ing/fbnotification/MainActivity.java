package com.ing.fbnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;



public class MainActivity extends AppCompatActivity {

    Button getToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getToken=findViewById(R.id.btn_get_token);
        getToken.setOnClickListener(v -> FirebaseMessaging.getInstance().getToken()
                .addOnSuccessListener(token -> Log.d(Utils.TAG,token))
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Failed to get token", Toast.LENGTH_SHORT).show()));

    }
}