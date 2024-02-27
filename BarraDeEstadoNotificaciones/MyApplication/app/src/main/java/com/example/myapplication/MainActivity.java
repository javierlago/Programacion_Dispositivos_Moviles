package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICACION_1=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnsNotificaciones(View view) {
        switch (view.getId()) {
            case R.id.btn_notificacion: {
                notificacion();
                break;
            }

        }

    }

    private void notificacion(){
        // 1 Crear la notificacion
        Notification.Builder builder = new Notification.Builder(MainActivity.this);
        // 2 Personalizamos la notificacion
        builder.setSmallIcon(R.drawable.taxi); // Icono que aparece en la barra de estado
        // *****************************************
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.taxi); // Conversion de nuestro drawabla a bitmap
        //**********************************
        builder.setLargeIcon(bitmap); // Se necesita que crear un bitmap a partir de un drawable
        // ***************
        builder.setContentTitle("Nuevo mensaje"); // Configuracion del titulo
        builder.setContentText("Proximo reunión semanal bla bla bla bla");// Configuramos el mensje de la notificación
        // 3 Asociamos la notificación
        Intent intent = new Intent(this, MainActivity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_IMMUTABLE);// configuracion del pending intent
        builder.setContentIntent(pendingIntent);
        // 4 Lanzamos la notificación
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);// Crear un notificador
        Notification notificacion = builder.build(); // Pasamos el buildera a notificacion(Contructor->Construido)
        notificationManager.notify(NOTIFICACION_1,notificacion);

    }











}