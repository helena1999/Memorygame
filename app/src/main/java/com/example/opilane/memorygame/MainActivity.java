package com.example.opilane.memorygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public abstract class MainActivity extends AppCompatActivity {

    TextView pv1, pv2;
    ImageView pr11, pr12, pr13, pr14, pr21, pr22, pr23, pr24, pr31, pr32, pr33, pr34;

    Integer[] piltideArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206 };

    int pilt101, pilt102, pilt103, pilt104, pilt105, pilt106, pilt201, pilt202, pilt203, pilt204, pilt205, pilt206;

    int esimeneKaart, teineKaart;

    int esimeneValik, teineValik;

    int kaartiNr = 1;

    int kord = 1;

    int punktidIsik1 = 0, punktidIsik2 = 0;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mediaPlayer == null );
            mediaPlayer = MediaPlayer.create(this, R.raw.music.mp3);
        mediaPlayer.start();

        SharedPreferences sharedPreferences = getSharedPreferences("nimed", MODE_PRIVATE);
        String m1 = sharedPreferences.getString("nimi1", "Ei leitud");
        String m2 = sharedPreferences.getString("nimi2", "Ei leitud");

        pv1 = findViewById(R.id.pv1);
        pv2 = findViewById(R.id.pv2);

        pv1.setText(m1);
        pv2.setText(m2);

        pr11 = findViewById(R.id.pr11);
        pr12 = findViewById(R.id.pr12);
        pr13 = findViewById(R.id.pr13);
        pr14 = findViewById(R.id.pr14);
        pr21 = findViewById(R.id.pr21);
        pr22 = findViewById(R.id.pr22);
        pr23 = findViewById(R.id.pr23);
        pr24 = findViewById(R.id.pr24);
        pr31 = findViewById(R.id.pr31);
        pr32 = findViewById(R.id.pr32);
        pr33 = findViewById(R.id.pr33);
        pr34 = findViewById(R.id.pr34);

        pr11.setTag("0");
        pr12.setTag("1");
        pr13.setTag("2");
        pr14.setTag("3");
        pr21.setTag("4");
        pr22.setTag("5");
        pr23.setTag("6");
        pr24.setTag("7");
        pr31.setTag("8");
        pr32.setTag("9");
        pr33.setTag("10");
        pr34.setTag("11");

        frontOfKaardidRessurssid();

        Collections.shuffle(Arrays.asList(piltideArray));

        pv2.setTextColor(Color.WHITE);

        pr11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr11, kaart);

            }
        });

        pr12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr12, kaart);
            }
        });

        pr13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr13, kaart);
            }
        });

        pr14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr14, kaart);
            }
        });

        pr21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr21, kaart);
            }
        });

        pr22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr22, kaart);
             }
        });

        pr23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag));
                toimubTegevus(pr23, kaart);
            }
        });

        pr24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr24, kaart);
            }
        });

        pr31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr31, kaart);
            }
        });

        pr32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr32, kaart);
            }
        });
        pr33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr33, kaart);
            }
        });

        pr34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kaart = Integer.parseInt((String)view.getTag);
                toimubTegevus(pr34,kaart);
            }
        });
    }

    private void toimubTegevus(ImageView pr, int kaarti){
        if (piltideArray[kaarti]== 101) {
            pr.setImageResource(pilt101);

        }
        else if (piltideArray[kaarti] == 102){
            pr.setImageResource(pilt102);
        }
        else if (piltideArray[kaarti] == 103){
            pr.setImageResource(pilt103);
        }
        else if (piltideArray[kaarti] == 104){
            pr.setImageResource(pilt104);
        }
        else if (piltideArray[kaarti] == 105){
            pr.setImageResource(pilt105);
        }
        else if (piltideArray[kaarti] == 106){
            pr.setImageResource(pilt106);
        }
        else if (piltideArray[kaarti] == 201){
            pr.setImageResource(pilt201);
        }
        else if (piltideArray[kaarti] == 202){
            pr.setImageResource(pilt202);
        }
        else if (piltideArray[kaarti] == 203){
            pr.setImageResource(pilt203);
        }
        else if (piltideArray[kaarti] == 204){
            pr.setImageResource(pilt204);
        }
        else if (piltideArray[kaarti] == 206){
            pr.setImageResource(pilt205);
        }
        if (kaartiNr == 1){
            esimeneKaart = piltideArray[kaarti];
            if (esimeneKaart > 200 ){
                esimeneKaart = esimeneKaart - 100;
            }
            kaartiNr = 2;
            esimeneValik = kaarti;
            pr.setEnabled(false);

        }else if (kaartiNr == 2){
            teineKaart = piltideArray[kaarti];
            if (teineKaart > 200){
                teineKaart = teineKaart - 100;
            }
            kaartiNr = 1;
            teineValik = kaarti;
            pr11.setEnabled(false);
            pr12.setEnabled(false);
            pr13.setEnabled(false);
            pr14.setEnabled(false);
            pr21.setEnabled(false);
            pr22.setEnabled(false);
            pr23.setEnabled(false);
            pr24.setEnabled(false);
            pr31.setEnabled(false);
            pr32.setEnabled(false);
            pr33.setEnabled(false);
            pr34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    arvuta();


                }
            }, 1000);
        }
    }
    private void arvuta(){
        SharedPreferences sharedPreferences = getSharedPreferences("nimed", MODE_PRIVATE);
        String m1 = sharedPreferences.getString("nimi1", "Ei leidnud");
        String m2 = sharedPreferences.getString("nimi2", "Ei leidnud");

        if (esimeneValik == 0){
            pr11.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 1){
            pr12.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 2){
            pr13.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 3){
            pr14.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 4){
            pr21.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 5){
            pr22.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 6){
            pr23.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 7){
            pr24.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 8){
            pr31.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 9){
            pr32.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 10){
            pr33.setVisibility(View.INVISIBLE);
        }else if (esimeneValik == 11){
            pr34.setVisibility(View.INVISIBLE);
        }

        if (teineValik == 0){
            pr11.setVisibility(View.INVISIBLE);
        }else if (teineValik == 1){
            pr12.setVisibility(View.INVISIBLE);
        }else if (teineValik == 2){
            pr13.setVisibility(View.INVISIBLE);
        }else if (teineValik == 3){
            pr14.setVisibility(View.INVISIBLE);
        }else if (teineValik == 4){
            pr21.setVisibility(View.INVISIBLE);
        }else if (teineValik == 5){
            pr22.setVisibility(View.INVISIBLE);
        }else if (teineValik == 6){
            pr23.setVisibility(View.INVISIBLE);
        }else if (teineValik == 7){
            pr24.setVisibility(View.INVISIBLE);
        }else if (teineValik == 8){
            pr31.setVisibility(View.INVISIBLE);
        }else if (teineValik == 9){
            pr32.setVisibility(View.INVISIBLE);
        }else if (teineValik == 10){
            pr33.setVisibility(View.INVISIBLE);
        }else if (teineValik == 11){
            pr34.setVisibility(View.INVISIBLE);
        }

        if (kord == 1){
            punktidIsik1++;
            pv1.setText(m1 + ":" + punktidIsik1);
        }else if (kord == 2){
            punktidIsik2++;
            pv2.setText(m2 + ":" + punktidIsik2);
        }
    }
    else {
        pr11.setImageResource(R.drawable.question);
        pr12.setImageResource(R.drawable.question);
        pr13.setImageResource(R.drawable.question);
        pr14.setImageResource(R.drawable.question);
        pr21.setImageResource(R.drawable.question);
        pr22.setImageResource(R.drawable.question);
        pr23.setImageResource(R.drawable.question);
        pr24.setImageResource(R.drawable.question);
        pr31.setImageResource(R.drawable.question);
        pr32.setImageResource(R.drawable.question);
        pr33.setImageResource(R.drawable.question);
        pr34.setImageResource(R.drawable.question);

        if (kord == 1){
            kord = 2;
            pv1.setTextColor(Color.WHITE);
            pv2.setTextColor(Color.BLACK);
        }else if (kord == 2){
            kord = 1;
            pv2.setTextColor(Color.WHITE);
            pv1.setTextColor(Color.BLACK);
        }
    }
    pr11.setEnabled(true);
    pr12.setEnabled(true);
    pr13.setEnabled(true);
    pr14.setEnabled(true);
    pr21.setEnabled(true);
    pr22.setEnabled(true);
    pr23.setEnabled(true);
    pr24.setEnabled(true);
    pr31.setEnabled(true);
    pr32.setEnabled(true);
    pr33.setEnabled(true);
    pr34.setEnabled(true);

    kontrollilõpp() {

    }

    private void kontrollilõpp(){

        SharedPreferences sharedPreferences = getSharedPreferences("nimed", MODE_PRIVATE);
        String m1 = sharedPreferences.getString("nimi1", "Ei leitud");
        String m2 = sharedPreferences.getString("nimi2","Ei leitud");

        if (pr11.getVisibility() == View.INVISIBLE && pr12.getVisibility() == View.INVISIBLE && pr13.getVisibility() == View.INVISIBLE && pr14.getVisibility() == View.INVISIBLE && pr21.getVisibility() == View.INVISIBLE && pr22.getVisibility() == View.INVISIBLE && pr23.getVisibility() == View.INVISIBLE && pr24.getVisibility() == View.INVISIBLE && pr31.getVisibility() == View.INVISIBLE && pr32.getVisibility() == View.INVISIBLE && pr33.getVisibility() == View.INVISIBLE && pr34.getVisibility() == View.INVISIBLE);

        mediaPlayer.stop();
        mediaPlayer = null;

        AlertDialog.Builder teavitus = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = getLayoutInflater();
        teavitus.setView(inflater.inflate(R.layout.custom_dialog, null));

        .setMessage(m1+ ":" + punktidIsik1 + "\n" + m2 + ":" + punktidIsik2)
                .setCancelable(false)
                .setPositiveButton ("UUESTI", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int i){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                })

                .setNeutralButton("Välju", new DialogInterface.OnClickListener()){

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finish();
                    }
                });
        AlertDialog alertDialog = teavitus.create();
        alertDialog.show();

        TextView textView = alertDialog.findViewById(android.R.id.message);
        textView.setGravity(Gravity.CENTER);
        textView.setAllCaps(true);
        textView.setTextSize(28);

        }
    }
    private void frontOfKaardidRessurssid() {
        pilt101 = R.drawable.cat.png;
        pilt102 = R.drawable.dog.png;
        pilt103 = R.drawable.horse.png;
        pilt104 = R.drawable.janes.png;
        pilt105 = R.drawable.squirrel.png;
        pilt106 = R.drawable.wolf.png;
        pilt201 = R.drawable.cat.png;
        pilt202 = R.drawable.dog.png;
        pilt203 = R.drawable.horse.png;
        pilt204 = R.drawable.janes.png;
        pilt205 = R.drawable.squirrel.png;
        pilt206 = R.drawable.wolf.png;


    }



}




