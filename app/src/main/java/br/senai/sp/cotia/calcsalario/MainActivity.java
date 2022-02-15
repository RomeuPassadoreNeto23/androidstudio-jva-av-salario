package br.senai.sp.cotia.calcsalario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText salariobruto,depen,tpPlanoSaude,vlTransporte,vaRefeicao;
private TextView resultado;
private Button bt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         salariobruto = findViewById(R.id.salariobruto);
         depen = findViewById(R.id.depen);
         tpPlanoSaude = findViewById(R.id.tpPlanoSaude);
         vlTransporte = findViewById(R.id.vlTransporte);
         vaRefeicao = findViewById(R.id.vaRefeicao);
         resultado = findViewById(R.id.resultado);
         bt_resultado = findViewById(R.id.bt_resultado);
         bt_resultado.setOnClickListener( v -> {
             if (salariobruto.getText().toString().isEmpty()){
                 salariobruto.setError(getString(R.string.validadeSalario));
             }else if (depen.getText().toString().isEmpty()) {
                 depen.setError(getString(R.string.validadeSalario));
             }else if(tpPlanoSaude.getText().toString().isEmpty()) {
                 tpPlanoSaude.setError(getString(R.string.validadeSalario));
             }else if(vlTransporte.getText().toString().isEmpty()) {
                 vlTransporte.setError(getString(R.string.validadeSalario));
             }else if(vaRefeicao.getText().toString().isEmpty()) {
                 vaRefeicao.setError(getString(R.string.validadeSalario));
             }else {

             }
         });
    }
}