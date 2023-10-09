package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView campoResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        campoResultado  = findViewById(R.id.textViewResultado);

        // Recupere o resultado do Intent
        Intent intent = getIntent();
        String resultadoTexto = getIntent().getStringExtra("resultadoText");

        // Encontre o TextView na layout da SecondActivity
        TextView resultadoTextView = findViewById(R.id.textViewResultado);

        // Defina o texto do TextView com o resultado
        resultadoTextView.setText(resultadoTexto);

    }
}