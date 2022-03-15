package br.senai.sp.cotia.calcsalario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText salariobruto,depen;
private Spinner spinner;
private RadioGroup radioGroupvt,radioGroupa,radioGroupr;
private TextView resultado;
private Button bt_resultado ,bt_lipar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         salariobruto = findViewById(R.id.salariobruto);
         depen = findViewById(R.id.depen);
         resultado = findViewById(R.id.resultado);
         bt_resultado = findViewById(R.id.bt_resultado);
         bt_lipar = findViewById(R.id.bt_limpar);
         spinner = findViewById(R.id.spinnerps);
         radioGroupvt = findViewById(R.id.radio_gupovt);
         radioGroupa = findViewById(R.id.radio_gupova);
         radioGroupr = findViewById(R.id.radio_gupovr);

         bt_resultado.setOnClickListener( v -> {
             if (salariobruto.getText().toString().isEmpty()){
                 salariobruto.setError(getString(R.string.validadeSalario));
             }else if (depen.getText().toString().isEmpty()) {
                 depen.setError(getString(R.string.Numdep));
             }else {
                 double  salarioBruto ,resPlanosaude = 0 ,inns = 0,vt = 0 , va = 0,vr = 0,irrf = 0 ,sl = 0;
                 double res ;
                 int dePendete;

                 salarioBruto = Double.parseDouble(salariobruto.getText().toString());
                 dePendete = Integer.parseInt(depen.getText().toString());

                  if( spinner.getSelectedItemPosition() == 0){
                      if(salarioBruto <= 3000.00){
                       resPlanosaude = 60.00;
                      }else {
                          resPlanosaude = 80.00;
                      }
                  }else if(spinner.getSelectedItemPosition() == 1){
                      if(salarioBruto <= 3000.00){
                          resPlanosaude = 80.00;
                      }else {
                          resPlanosaude = 110.00;
                      }

                  }else if(spinner.getSelectedItemPosition() == 2){
                      if(salarioBruto <= 3000.00){
                          resPlanosaude = 95.00;
                      }else {
                          resPlanosaude = 135.00;
                      }

                  }else if(spinner.getSelectedItemPosition() == 3){
                      if(salarioBruto <= 3000.00){
                          resPlanosaude = 130.00;
                      }else {
                          resPlanosaude = 180.00;
                      }

                  }
                 if (salarioBruto <= 1045.00) {
                     inns = salarioBruto * 0.075 ;

                 }else if (salarioBruto <= 2089.60) {
                     inns = 0.09 * salarioBruto - 15.68;

                 }else if (salarioBruto <= 3134.40 ) {
                     inns = 0.12 * salarioBruto - 78.38;

                 }else if (salarioBruto <= 6101.06) {
                     inns = 0.14 *  salarioBruto - 141.07;

                 }else {
                     inns = 713.08;
                 }
                 switch (radioGroupvt.getCheckedRadioButtonId()){
                     case R.id.radio_buttonvts:
                         vt = 0.06 * salarioBruto;
                         break;
                     case R.id.radio_buttonvtn:
                         vt = 0;
                         break;
                 }
                 switch (radioGroupa.getCheckedRadioButtonId()){
                     case R.id.radio_buttonvas:
                         if(salarioBruto <= 3000.00) {
                             va = 15.00;
                         }else if(salarioBruto <= 5000.00) {
                             va = 25.00;
                         }else {
                             va = 35.00;
                         }
                         break;
                     case R.id.radio_buttonvan:
                         va = 0;
                         break;
                 }
                 switch (radioGroupr.getCheckedRadioButtonId()){
                     case R.id.radio_buttonvrs:
                         if(salarioBruto <= 3000.00) {
                             vr = 2.60 * 22;
                         }else if (salarioBruto <= 5000.00) {
                             vr = 3.65 * 22;
                         }else {
                             vr = 6.50 * 22;
                         }
                         break;
                     case R.id.radio_buttonvrn:
                         vr = 0;
                         break;
                 }
                 double calinss = salarioBruto - inns - 189.59 * dePendete;

                 if(calinss <= 1903.98) {
                     calinss  = 0;
                 }else if(calinss <= 2826.65) {
                     calinss = calinss * 0.075 - 142.80;
                 }else if (calinss <= 3751.05){
                     calinss = calinss * 0.15 - 354.80;
                 }else if(calinss <= 4664.68) {
                     calinss = calinss * 0.225 - 636.13;
                 }else {
                     calinss = calinss * 0.275 - 869.36;
                 }
                  sl = salarioBruto - inns  - vt - vr - va - calinss - resPlanosaude;
                 resultado.setText(String.format("salario liquido %10.2f" ,sl));






                  



             }

         });
         bt_lipar.setOnClickListener( v -> {
             resultado.setText(null);
         });
    }
}