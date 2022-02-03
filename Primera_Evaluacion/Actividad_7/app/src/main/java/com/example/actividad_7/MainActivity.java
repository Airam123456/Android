package com.example.actividad_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    static final String CANAL_ID ="mi_canal";
    static final int NOTIFICACION_ID = 1;
    private int aux1, aux2, aux3, respCorrectas = 0;
    private EditText operando1, operando2, resultado, operador;
    private TextView respuesta;
    private Button volver, comprobar, nueva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volver = (Button) findViewById(R.id.btnVolver);
        operando1 = (EditText) findViewById(R.id.txtOperando1);
        operando2 = (EditText) findViewById(R.id.txtOperando2);
        operador = (EditText) findViewById(R.id.txtOperador);
        resultado = (EditText) findViewById(R.id.txtResultado);
        comprobar = (Button) findViewById(R.id.btnComprobarResult);
        nueva = (Button) findViewById(R.id.btnNewQuestion); 
        respuesta = (TextView) findViewById(R.id.lblRespuesta);

        generarNumeros();

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        
        nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generarNumeros();
                resultado.setText("");
                respuesta.setText("");
            }
        });

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resultado.getText().toString().isEmpty())
                    generarNumeros();
                else {
                    switch (aux3)
                    {
                        case 0: if((aux1 + aux2) == Integer.parseInt(resultado.getText().toString())) {
                            respuesta.setText("CORRECTA");
                            respCorrectas++;
                        }
                        else{
                            respuesta.setText("INCORRECTA");
                        }
                            break;
                        case 1: if((aux1 - aux2) == Integer.parseInt(resultado.getText().toString())){
                            respuesta.setText("CORRECTA");
                            respCorrectas++;
                        }
                        else{
                            respuesta.setText("INCORRECTA");
                        }
                            break;
                        case 2: if((aux1 * aux2) == Integer.parseInt(resultado.getText().toString())){
                            respuesta.setText("CORRECTA");
                            respCorrectas++;
                        }
                        else{
                            respuesta.setText("INCORRECTA");
                        }
                            break;
                        case 3: if((aux1 / aux2) == Integer.parseInt(resultado.getText().toString())){
                            respuesta.setText("CORRECTA");
                            respCorrectas++;
                        }
                        else{
                            respuesta.setText("INCORRECTA");
                        }
                            break;
                    }
                }
                if(respCorrectas == 10){
                    notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    //Creamos el canal. SOLO puede hacerse en dispositivos con ver. 8 o más.
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        NotificationChannel notificationChannel = new NotificationChannel(
                                CANAL_ID, "Mis notificaciones",
                                NotificationManager.IMPORTANCE_DEFAULT);
                        notificationChannel.setDescription("Descripción del canal");
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                    NotificationCompat.Builder notificacion =
                            new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                    .setSmallIcon(R.drawable.outline_pets_black_24dp)
                                    .setContentTitle("Enhorabuena")
                                    .setContentText("Has acertado 10 preguntas seguidas");
                    notificationManager.notify(NOTIFICACION_ID, notificacion.build());
                }

            }
        });

    }


    private void generarNumeros()
    {
        aux1 = (int)(Math.random() * 100);
        operando1.setText(String.valueOf(aux1));
        aux2 = (int)(Math.random()  * 100 + 1);
        operando2.setText(String.valueOf(aux2));
        aux3 = (int)(Math.random() * 3);
        if (aux3 == 0)
            operador.setText("+");
        else if (aux3 == 1){
            operador.setText("-");
            if(aux2 > aux1)
                aux2 = aux1;
                operando2.setText(String.valueOf(aux2));
        }

        else if (aux3 == 2)
            operador.setText("*");
        else
            operador.setText("/");
    }
}