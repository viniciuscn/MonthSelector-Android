package br.nichele.navegames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

   br.nichele.selecionames.SelecionaMes sm;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      //sm = new br.nichele.selecionames.SelecionaMes(this);

      TextView lbldatinicial = findViewById(R.id.lbldatinicial);
      TextView ano = findViewById(R.id.ano);
      TextView mes = findViewById(R.id.mes);
      TextView dia = findViewById(R.id.dia);

      lbldatinicial.setText("2019/09/01");
      ano.setText("--"+lbldatinicial.getText().subSequence(0,4).toString()+"--");
      mes.setText("--"+lbldatinicial.getText().subSequence(5,7).toString()+"--");
      dia.setText("--"+lbldatinicial.getText().subSequence(8,10).toString()+"--");


   }
}
