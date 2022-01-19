package com.higorp.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private Button btnCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        txtResultado = findViewById(R.id.txtResultado);

    }

    public void CalcularPreco (View view) {

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados){
            calcularMelhorPreco(precoAlcool, precoGasolina);
        }

    }

    public Boolean validarCampos (String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("") && pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
            Toast.makeText(getApplicationContext(), "Preencha o valor do alcool e da gasolina", Toast.LENGTH_SHORT).show();
        }else if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
            Toast.makeText(getApplicationContext(), "Preencha o valor do alcool", Toast.LENGTH_SHORT).show();
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
            Toast.makeText(getApplicationContext(), "Preencha o valor da gasolina", Toast.LENGTH_SHORT).show();
        }
        return camposValidados;
    }

    public Double calcularMelhorPreco(String pAlcool, String pGasolina){
        Double valorAlcool = Double.parseDouble(pAlcool);
        Double valorGasolina = Double.parseDouble(pGasolina);

        Double resultado = valorAlcool / valorGasolina;
        if (resultado >= 0.7){
            txtResultado.setText("Melhor usar gasolina");
        }else {
            txtResultado.setText("Melhor usar alcool");
        }
        return resultado;
    }
}