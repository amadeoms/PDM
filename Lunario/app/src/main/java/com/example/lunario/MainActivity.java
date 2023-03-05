package com.example.lunario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
    }

    //Abre el lunario
    public void AbrirLunario(View view) {
        //Creamos una instancia calendario
        Calendar lunario = Calendar.getInstance();
        //Creamos variables para años, meses y dias.
        int anio = lunario.get(Calendar.YEAR);
        int mes = lunario.get(Calendar.MONTH);
        int dia = lunario.get(Calendar.DAY_OF_MONTH);

        //Creamos el dialogo para escoger día. Indicamos contexto (actividad main), y un listener.
        DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            //La fecha se indica como dia/mes/año, y se muestra en el textview.
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
              String fecha = dayOfMonth + "/" + month + "/" + year;
              tv.setText(fecha);
            }
        }, anio, mes, dia);
        //Mostramos el dialogo.
        dpd.show();
    }
}