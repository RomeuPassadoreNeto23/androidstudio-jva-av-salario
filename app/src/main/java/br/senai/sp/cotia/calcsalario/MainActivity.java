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
                 depen.setError(getString(R.string.Numdep));
             }else if(tpPlanoSaude.getText().toString().isEmpty()) {
                 tpPlanoSaude.setError(getString(R.string.TipoPlano));
             }else if(vlTransporte.getText().toString().isEmpty()) {
                 vlTransporte.setError(getString(R.string.Vatrans));
             }else if(vaRefeicao.getText().toString().isEmpty()) {
                 vaRefeicao.setError(getString(R.string.VaRef));
             }else {
                 double  salarioBruto ,resPlanosaude =0;
                 double res ;
                 int dePendete;
                 String tipoPlanosaude,tipovaliTranspor,valirefeicao ;
                 salarioBruto = Double.parseDouble(salariobruto.getText().toString());
                  dePendete = Integer.parseInt(depen.getText().toString());
                  tipoPlanosaude =  tpPlanoSaude.getText().toString();
                  if(tipoPlanosaude == "Standard"){
                      if(salarioBruto <= 3000.00){
                       resPlanosaude = 60.00;
                      }else {
                          resPlanosaude = 80.00;
                      }
                  }else if(tipoPlanosaude == "basico"){
                      if(salarioBruto <= 3000.00){
                          resPlanosaude = 80.00;
                      }else {
                          resPlanosaude = 110.00;
                      }

                  }else if(tipoPlanosaude == "Super"){
                      if(salarioBruto <= 3000.00){
                          resPlanosaude = 95.00;
                      }else {
                          resPlanosaude = 135.00;
                      }

                  }else if(tipoPlanosaude == "Master"){
                      if(salarioBruto <= 3000.00){
                          resPlanosaude = 130.00;
                      }else {
                          resPlanosaude = 180.00;
                      }

                  }
                  



             }

         });
    }
}