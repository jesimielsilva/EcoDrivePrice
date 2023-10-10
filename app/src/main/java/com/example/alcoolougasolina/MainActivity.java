package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView campoResultado;
    private AutoCompleteTextView autoCompleteCarros;
    private TextInputEditText distancia, precoCombustivel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoResultado = findViewById(R.id.campoResultadoId);
        autoCompleteCarros = findViewById(R.id.autoCompleteCarros);
        distancia = findViewById(R.id.editDistancia);
        precoCombustivel = findViewById(R.id.precoCombustivel);

        List<Carros> carrosList = new ArrayList<>();
        carrosList.add(new Carros("Polo 2018 1.6", 8.7, 12.9, 10.0, 14.4));
        carrosList.add(new Carros("Duster 2014 1.6", 6.7, 10.0, 7.4, 10.7));
        carrosList.add(new Carros("Gol 2010 1.0", 7.4, 10.8, 9.5, 14.1));
        carrosList.add(new Carros("Argo 2022 1.0", 9.9, 14.2, 10.7, 15.1));
        carrosList.add(new Carros("HB20 2015 1.0", 7.6, 11.5, 9.8, 14.5));
        carrosList.add(new Carros("Fluence 2018 CVT 2.0", 6.1, 7.4, 8.7, 10.7));
        carrosList.add(new Carros("Onix Joy 2019 1.0", 8.7, 12.9, 10.9, 15.6));
        carrosList.add(new Carros("Fiesta Class 2011 1.6", 7.1, 8.4, 9.7, 12.4));
        carrosList.add(new Carros("Ford Ka 2016 1.0", 8.9, 10.4, 13.0, 15.1));
        carrosList.add(new Carros("Fox 2012 1.0", 7.5, 11.5, 9.5, 13.5));
        // Adicione mais carros conforme necessário

        ArrayAdapter<Carros> carroAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, carrosList);
        autoCompleteCarros.setAdapter(carroAdapter);
    }

    public void calcular(View view){

        Carros selectedCar = getSelectedCarByName(autoCompleteCarros.getText().toString());

        if (selectedCar != null) {
            String carName = selectedCar.getNomeCarro();

            RadioGroup radioGroup = findViewById(R.id.radioCombustivel);
            int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

            double consumo = 0.0;
            String combustivelNome = "";

            if (selectedRadioButtonId == R.id.radioCidadeA) {
                consumo = selectedCar.getCidadeA();
                combustivelNome = "Etanol";
            } else if (selectedRadioButtonId == R.id.radioCidadeG) {
                consumo = selectedCar.getCidadeG();
                combustivelNome = "Gasolina";
            } else if (selectedRadioButtonId == R.id.radioEstradaA) {
                consumo = selectedCar.getEstradaA();
                combustivelNome = "Etanol";
            } else if (selectedRadioButtonId == R.id.radioEstradaG) {
                consumo = selectedCar.getEstradaG();
                combustivelNome = "Gasolina";
            } else {
                campoResultado.setText("Selecione uma opção (Cidade Etanol, Cidade Gasolina, Estrada Etanol ou Estrada Gasolina).");
                return;
            }

            String distanciaP = distancia.getText().toString();
            String precoCombust = precoCombustivel.getText().toString();

            if (!validarCampos(distanciaP, precoCombust)) {
                campoResultado.setText("Preencha todos os campos corretamente.");
                return;
            }

            double distanciaKm = Double.parseDouble(distanciaP);
            double precoLitro = Double.parseDouble(precoCombust);
            double resultado = (distanciaKm / consumo) * precoLitro;

            String resultadoTexto = String.format("Carro: %s\nConsumo de %s: %.2f km/l\nDistância: %.2f km\nPreço do %s: R$ %.2f\nValor para abastecer: R$ %.2f",
                    carName, combustivelNome, consumo, distanciaKm, combustivelNome, precoLitro, resultado);

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("resultadoText", resultadoTexto);
            startActivity(intent);
        } else {
            campoResultado.setText("Selecione um carro válido.");
        }

    }

    private Carros getSelectedCarByName(String carName) {
        // Implemente a lógica para encontrar o carro pelo nome na lista de carros.
        // Retorna o objeto Carros correspondente ou null se não encontrado.
        List<Carros> carrosList = new ArrayList<>();
        carrosList.add(new Carros("Polo 2018 1.6", 8.7, 12.9, 10.0, 14.4));
        carrosList.add(new Carros("Duster 2014 1.6", 6.7, 10.0, 7.4, 10.7));
        carrosList.add(new Carros("Gol 2010 1.0", 7.4, 10.8, 9.5, 14.1));
        carrosList.add(new Carros("Argo 2022 1.0", 9.9, 14.2, 10.7, 15.1));
        carrosList.add(new Carros("HB20 2015 1.0", 7.6, 11.5, 9.8, 14.5));
        carrosList.add(new Carros("Fluence 2018 CVT 2.0", 6.1, 7.4, 8.7, 10.7));
        carrosList.add(new Carros("Onix Joy 2019 1.0", 8.7, 12.9, 10.9, 15.6));
        carrosList.add(new Carros("Fiesta Class 2011 1.6", 7.1, 8.4, 9.7, 12.4));
        carrosList.add(new Carros("Ford Ka 2016 1.0", 8.9, 10.4, 13.0, 15.1));
        carrosList.add(new Carros("Fox 2012 1.0", 7.5, 11.5, 9.5, 13.5));
        // Adicione mais carros conforme necessário

        for (Carros car : carrosList) {
            if (car.getNomeCarro().equals(carName)) {
                return car;
            }
        }
        return null;
    }

    public Boolean validarCampos(String pDistancia, String pPreco){

        boolean validar = true;

        if  (pDistancia == null || pDistancia.equals("")){
            validar = false;
        } else if (pPreco == null || pPreco.equals("")) {
            validar = false;
        }

        return validar;

    }


}