package br.nichele.selecionames;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SelecionaMes extends RelativeLayout {

   TextView lblmesextenso, lbldatinicial, lbldatfinal;
   ImageButton cmdant, cmdnext;
   GregorianCalendar gc = new GregorianCalendar();

   public SelecionaMes(Context context) {
      super(context);
      initialize(context);
   }

   public SelecionaMes(Context context, AttributeSet attrs) {
      super(context, attrs);
      initialize(context);
   }

   private void initialize(final Context context){
      inflate(context, R.layout.seleciona_mes_layout, this);

      lblmesextenso = findViewById(R.id.lblmes_extenso);
      lblmesextenso.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
            gc = new GregorianCalendar();
            mostradatas();
            //Toast.makeText(context,new Date().toString(),Toast.LENGTH_SHORT).show();
         }
      });
      lbldatinicial = findViewById(R.id.lbldatinicial);
      lbldatfinal = findViewById(R.id.lbldatfinal);
      cmdnext = findViewById(R.id.cmdnext);

      mostradatas();


      cmdant = findViewById(R.id.cmdant);
      cmdant.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {

            gc.set(GregorianCalendar.YEAR, Integer.valueOf(lbldatinicial.getText().subSequence(0,4).toString()));
            gc.set(GregorianCalendar.MONTH, Integer.valueOf(lbldatinicial.getText().subSequence(5,7).toString())-1);
            gc.set(GregorianCalendar.DAY_OF_MONTH, Integer.valueOf(lbldatinicial.getText().subSequence(8,10).toString()));
            gc.setTime( Util.DateAdd( Util.DateInterval.mes,-1, gc.getTime()) );
            mostradatas();

         }
      });

      cmdnext = findViewById(R.id.cmdnext);
      cmdnext.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {

            gc.set(GregorianCalendar.YEAR, Integer.valueOf(lbldatinicial.getText().subSequence(0,4).toString()));
            gc.set(GregorianCalendar.MONTH, Integer.valueOf(lbldatinicial.getText().subSequence(5,7).toString()));
            gc.set(GregorianCalendar.DAY_OF_MONTH, Integer.valueOf(lbldatinicial.getText().subSequence(8,10).toString()));
            gc.setTime( Util.DateAdd( Util.DateInterval.mes,1, gc.getTime()) );
            mostradatas();

         }
      });


   }

   private void mostradatas(){
      lbldatinicial.setText( gc.get(Calendar.YEAR) + "/" + String.format("%02d", new Integer(gc.get(Calendar.MONTH)+1 )) + "/01" );
      lbldatfinal.setText( gc.get(Calendar.YEAR) +"/" + String.format("%02d", new Integer(gc.get(Calendar.MONTH)+1 )) +"/" + String.format("%02d", new Integer(gc.getActualMaximum(Calendar.DAY_OF_MONTH))) );
      lblmesextenso.setText(Util.setMesPorExtenso(gc.getTime()));
   }

}
