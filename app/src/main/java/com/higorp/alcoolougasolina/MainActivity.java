package com.higorp.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
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
        boolean camposValidados = true;

        if (pAlcool.equals("") && pGasolina.equals("")){
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

    public void calcularMelhorPreco(String pAlcool, String pGasolina){
        Double valorAlcool = Double.parseDouble(pAlcool);
        Double valorGasolina = Double.parseDouble(pGasolina);

        double resultado = valorAlcool / valorGasolina;
        if (resultado >= 0.7) {
            txtResultado.setText(R.string.MelhorGasolina);
        } else {
            txtResultado.setText(R.string.MelhorAlcool);
        }
    }
}