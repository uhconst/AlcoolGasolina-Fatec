package com.uhc.alcoolgasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_calcular = findViewById(R.id.btn_calcular);

        txt_resultado = findViewById(R.id.txt_resultado);

        final EditText edt_alcool = findViewById(R.id.edt_alcool);
        final EditText edt_gasolina = findViewById(R.id.edt_gasolina);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoAlcool = edt_alcool.getText().toString();
                String textoGasolina = edt_gasolina.getText().toString();

                if (textoAlcool.isEmpty() || textoGasolina.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Os dois campos devem ser preenchidos!", Toast.LENGTH_LONG).show();
                } else {
                    double valorAlcool = Double.parseDouble(textoAlcool);
                    double valorGasolina = Double.parseDouble(textoGasolina);

                    double resultado = valorAlcool / valorGasolina;

                    if (resultado >= 0.7) {
                        //Compensa a gasolina
                        txt_resultado.setText("Compensa a GASOLINA!");
                    } else {
                        // Compensa o alcool
                        txt_resultado.setText("Compensa o ÁLCOOL!");

                    }
                }
            }
        });
    }
}
