package com.example.gerenciadorads;

import android.annotation.SuppressLint;
import android.hardware.biometrics.BiometricManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edNome;
    private EditText edEmail;
    private EditText edIdade;
    private EditText edDisciplina;
    private EditText edNota1;
    private EditText edNota2;
    private Button btEnviar;
    private Button btLimpar;
    private TextView tvResposta;
    private TextView tvErro;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edIdade = findViewById(R.id.edIdade);
        edDisciplina = findViewById(R.id.edDisciplina);
        edNota1 = findViewById(R.id.edNota1);
        edNota2 = findViewById(R.id.edNota2);
        btEnviar = findViewById(R.id.btEnviar);
        btLimpar = findViewById(R.id.btLimpar);
        tvResposta = findViewById(R.id.tvResposta);
        tvErro = findViewById(R.id.edErro);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
    }

    private void validar() {
        String nome = edNome.getText().toString();
        String email = edEmail.getText().toString();
        String idade = edIdade.getText().toString();
        String disciplina = edDisciplina.getText().toString();
        String notaA = edNota1.getText().toString();
        String notaB = edNota2.getText().toString();


        if (TextUtils.isEmpty(nome)) {
            tvResposta.setText("O campo de nome está vazio");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            tvResposta.setText("O email é inválido");
            return;
        }
        if (TextUtils.isEmpty(idade) || !idade.matches("\\d+") || Integer.parseInt(idade) <= 0) {
            tvResposta.setText("A idade deve ser um número positivo");
            return;
        }
        if (TextUtils.isEmpty(disciplina)) {
            tvResposta.setText("O campo de disciplina está vazio");
            return;
        }

        if (TextUtils.isEmpty(notaA)) {
            tvResposta.setText("Nota do 1º bimestre inválida");
        }

        if (TextUtils.isEmpty(notaB)) {
            tvResposta.setText("Nota do 2º bimestre inválida");
            return;
        }

        double nota1 = Double.parseDouble(notaA);
        double nota2 = Double.parseDouble(notaB);
        double media = (nota1 + nota2) / 2;

        tvResposta.setText(new String("Nome: " + nome + "\n" +
                "E-mail: " + email + "\n" +
                "Idade: " + idade + "\n" +
                "Disciplina: " + disciplina + "\n" +
                "Nota Primeiro Bimestre: " + nota1 + "\n" +
                "Nota Segundo Bimestre: " + nota2 + "\n" +
                "Sua Media: " + media));
    }
//    if(media < 6){
//        tvResposta.setText("Aluno REPROVADO");
//    }else if(media > 6){
//        tvResposta.setText("APROVADO");
//    }
    private void limpar(){
        edNome.setText("");
        edEmail.setText("");
        edIdade.setText("");
        edDisciplina.setText("");
        edNota1.setText("");
        edNota2.setText("");
    }

}