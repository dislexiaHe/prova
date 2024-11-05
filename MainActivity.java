package com.example.agecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Declaração das variáveis para o DatePicker, Button e TextView
    private DatePicker datePicker;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Definindo o layout da atividade principal
        setContentView(R.layout.activity_main);

        // Inicializando o DatePicker para escolher a data de nascimento
        datePicker = findViewById(R.id.datePicker);
        // Inicializando o botão para calcular a idade
        btnCalculate = findViewById(R.id.btnCalculate);
        // Inicializando o TextView para exibir o resultado
        tvResult = findViewById(R.id.tvResult);

        // Definindo um evento de clique no botão "Calcular Idade"
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quando o botão for clicado, chama o método para calcular a idade
                calculateAge();
            }
        });
    }

    // Método para calcular a idade com base na data selecionada
    private void calculateAge() {
        // Obtendo o ano, mês e dia do DatePicker
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();

        // Criando uma instância do Calendar para a data de nascimento (dob)
        Calendar dob = Calendar.getInstance();
        dob.set(year, month, day);

        // Criando uma instância do Calendar para a data atual
        Calendar today = Calendar.getInstance();

        // Calculando a idade com base na diferença entre o ano atual e o ano de nascimento
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        // Verificando se a data de aniversário ainda não chegou este ano
        // Caso não tenha chegado, decrementa a idade em 1
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        // Atualizando o TextView com o resultado da idade calculada
        tvResult.setText("Idade: " + age + " anos");
    }
}
