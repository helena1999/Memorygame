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

public class MainActivity extends AppCompatActivity {
    // deklareerin muutujad
    TextView pv1, pv2;
    ImageView pr11, pr12, pr13, pr14, pr21, pr22, pr23, pr24, pr31, pr32, pr33, pr34;
    // kaartidemassiiv
    Integer[] piltideArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};
    // päris pildid
    int pilt101, pilt102, pilt103, pilt104 ,pilt105, pilt106, pilt201, pilt202, pilt203, pilt204 ,pilt205, pilt206;
    // muutuja kui valitakse esimene ja teine kaart
    int esimeneKaart, teineKaart;
    // esimese ja teise valiku muutujad
    int esimeneValik, teineValik;
    // kaarti number
    int kaartiNr = 1;
    // mitmes kord
    int kord = 1;
    // Skooride algväärtused
    int punktidIsik1 = 0, punktidIsik2 = 0;
    // meediaplayer
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // kui mediaplayeri väärtus on null siis luuakse see ning mängitavaks looks saab raw kaustast fail nimega jazzyfrenchy
        if (mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(this, R.raw.jazz);
        // mediaplayer käivitatakse
        mediaPlayer.start();
        // sharedpreferences abil saadakse kätte alguses salvestatud andmed elik siis mängijate nimed
        SharedPreferences sharedPreferences = getSharedPreferences("nimed", MODE_PRIVATE);
        String m1 = sharedPreferences.getString("nimi1","Ei leitud");
        String m2 = sharedPreferences.getString("nimi2","Ei leitud");
        // seon muutuja textview vidinaga
        pv1 = findViewById(R.id.pv1);
        pv2 = findViewById(R.id.pv2);
        // määran textview'de tekstiks mängijate nimed
        pv1.setText(m1);
        pv2.setText(m2);
        // seon muutujad piltide vidinatega
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
        /* määran piltide tagid. Sets the tag associated with this view. A tag can be used to mark a view in its hierarchy and does not have to be unique within the hierarchy.
         Tags can also be used to store data within a view without resorting to another data structure. */
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
        // laadin kaartide pildid
        frontOfKaardidRessurssid();
        // piltide segamine
        Collections.shuffle(Arrays.asList(piltideArray));
        // teise mängija teksti muutmine valgeks kui tegu on mitteaktiivse mängijaga
        pv2.setTextColor(Color.WHITE);
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr11,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr12,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr13,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr14,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr21,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr22,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr23,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr24,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr31,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr32,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr33,kaart);
            }
        });
        // piltidele klõpsates saab kaart vastava tagi ning käivitatakse meetod toimubTegevus, mis saab parameetriteks imageview ning kaarti
        pr34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kaart = Integer.parseInt((String)view.getTag());
                toimubTegevus(pr34,kaart);
            }
        });
    }
    // kirjutame toimubTegevus meetodi (parameetriteks saab imageview ja massiivist kaarti)
    private void toimubTegevus(ImageView pr, int kaarti){
        // määra õige pilt imageview'le
        if (piltideArray[kaarti] == 101){
            pr.setImageResource(pilt101);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 102){
            pr.setImageResource(pilt102);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 103){
            pr.setImageResource(pilt103);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 104){
            pr.setImageResource(pilt104);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 105){
            pr.setImageResource(pilt105);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 106){
            pr.setImageResource(pilt106);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 201){
            pr.setImageResource(pilt201);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 202){
            pr.setImageResource(pilt202);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 203){
            pr.setImageResource(pilt203);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 204){
            pr.setImageResource(pilt204);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 205){
            pr.setImageResource(pilt205);
        }// määra õige pilt imageview'le
        else if (piltideArray[kaarti] == 206){
            pr.setImageResource(pilt206);
        }
        // kontrolli milline kaart on valitud ning salvesta see ajutisse muutujasse.
        if (kaartiNr == 1){
            esimeneKaart = piltideArray[kaarti];
            if (esimeneKaart > 200){
                esimeneKaart = esimeneKaart - 100;
            }
            kaartiNr = 2;
            esimeneValik = kaarti;
            pr.setEnabled(false);
        } else if (kaartiNr == 2) {
            teineKaart = piltideArray[kaarti];
            if (teineKaart > 200) {
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
                    // kontrolli kas valitud pildid on võrdsed
                    arvuta();
                }
            }, 1000);
        }
    } // meetod arvuta kus kontrollime kas esimese ja teise kaarti pildid on samad
    private void arvuta(){
        // mängija andmete saamine shared preferencesist
        SharedPreferences sharedPreferences = getSharedPreferences("nimed", MODE_PRIVATE);
        String m1 = sharedPreferences.getString("nimi1","Ei leitud");
        String m2 = sharedPreferences.getString("nimi2","Ei leitud");

        // kui pildid on võrdsed eemalda need laualt ehk tee need nähtamatuks ja lisa punkt
        if (esimeneKaart == teineKaart){
            if (esimeneValik == 0){
                pr11.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 1){
                pr12.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 2){
                pr13.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 3){
                pr14.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 4){
                pr21.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 5){
                pr22.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 6){
                pr23.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 7){
                pr24.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 8){
                pr31.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 9){
                pr32.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 10){
                pr33.setVisibility(View.INVISIBLE);
            } else if (esimeneValik == 11){
                pr34.setVisibility(View.INVISIBLE);
            }
            // kui pildid on võrdsed eemalda need laualt ehk tee need nähtamatuks ja lisa punkt
            if (teineValik == 0){
                pr11.setVisibility(View.INVISIBLE);
            } else if (teineValik == 1){
                pr12.setVisibility(View.INVISIBLE);
            } else if (teineValik == 2){
                pr13.setVisibility(View.INVISIBLE);
            } else if (teineValik == 3){
                pr14.setVisibility(View.INVISIBLE);
            } else if (teineValik == 4){
                pr21.setVisibility(View.INVISIBLE);
            } else if (teineValik == 5){
                pr22.setVisibility(View.INVISIBLE);
            } else if (teineValik == 6){
                pr23.setVisibility(View.INVISIBLE);
            } else if (teineValik == 7){
                pr24.setVisibility(View.INVISIBLE);
            } else if (teineValik == 8){
                pr31.setVisibility(View.INVISIBLE);
            } else if (teineValik == 9){
                pr32.setVisibility(View.INVISIBLE);
            } else if (teineValik == 10){
                pr33.setVisibility(View.INVISIBLE);
            } else if (teineValik == 11){
                pr34.setVisibility(View.INVISIBLE);
            }
            //lisa punktid õigele mängijale aka kui mängija üks sai paari kokku siis saab punkti ja vastupidi
            if (kord == 1){
                punktidIsik1++;
                pv1.setText(m1 + ": " + punktidIsik1);
            }else if (kord == 2){
                punktidIsik2++;
                pv2.setText(m2 + ": " + punktidIsik2);
            }
        } // määran pildite väärtuseks küsimärgi pildi
        else  {
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

            // muuda mängija värvi, aktiivse mänija nimi ja skoor on värvuselt must, mitte aktiivne mängija tekst on valge värvusega
            if (kord == 1){
                kord = 2;
                pv1.setTextColor(Color.WHITE);
                pv2.setTextColor(Color.BLACK);
            } else if(kord == 2){
                kord = 1;
                pv2.setTextColor(Color.WHITE);
                pv1.setTextColor(Color.BLACK);
            }
        }
        // määran vaate lubatuks
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

        // kontrolli kas mäng on läbi
        kontrolliLõpp();
    }

    private void kontrolliLõpp(){
        // saan sharedpreferences abil loodud andmefailist nimed omale vajaliku andmed kätte
        SharedPreferences sharedPreferences = getSharedPreferences("nimed", MODE_PRIVATE);
        String m1 = sharedPreferences.getString("nimi1","Ei leitud");
        String m2 = sharedPreferences.getString("nimi2","Ei leitud");
        // Muudan määratud pildid nähtamatuks
        if (pr11.getVisibility() == View.INVISIBLE && pr12.getVisibility() == View.INVISIBLE &&
                pr13.getVisibility() == View.INVISIBLE && pr14.getVisibility() == View.INVISIBLE &&
                pr21.getVisibility() == View.INVISIBLE && pr22.getVisibility() == View.INVISIBLE &&
                pr23.getVisibility() == View.INVISIBLE && pr24.getVisibility() == View.INVISIBLE &&
                pr31.getVisibility() == View.INVISIBLE && pr32.getVisibility() == View.INVISIBLE &&
                pr33.getVisibility() == View.INVISIBLE && pr34.getVisibility() == View.INVISIBLE){
            // mediaplayer lõpetab muusika mängimise ja saab väärtuseks null
            mediaPlayer.stop();
            mediaPlayer = null;
            // Alertdialogi klass kasutab builderit et luua meie teavitus nimeline alertdialog, mida kuvame oma lehel
            AlertDialog.Builder teavitus = new AlertDialog.Builder(MainActivity.this);
            // kasutame layoutinflaterit et luua oma custom vaade alertdialogile
            LayoutInflater inflater = getLayoutInflater();
            // määrame ära et teavitus nimeline alertdialog saab oma vaateks custom_dialog layout kaustast
            teavitus.setView(inflater.inflate(R.layout.custom_dialog,null))
                    //määrame kuvatavaks sõnumiks saadud punkti skoori ja kasutaja poolt sisestatud nime mille saame sharedpreferences abil
                    .setMessage(m1+": "+punktidIsik1+"\n"+m2+": "+punktidIsik2)
                    .setCancelable(false)
                    // lisame nupu tekstiga uuesti, millele vajutades viiakse meid tagasi mängu algusesse aka laaditakse uuesti mainactivity leht
                    .setPositiveButton("UUESTI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    // lisame nupu tekstiga välju, millele vajutades lõpetatakse meie äpi tegevus ehk äpp sulgub
                    .setNeutralButton("VÄLJU", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            finish();
                        }
                    });
            // loome oma teavitus nimelise alertdialogi
            AlertDialog alertDialog = teavitus.create();
            // kuvame oma loodud alertdialogi
            alertDialog.show();
            // muudan alertdialogis kuvatava teksti suurust, seda saab teha alles pärast seda kui oled see loonud ja kuvanud selle. Leian kuvatava textview vidina viitan sellele kasutades tema id-d milleks on messade
            TextView textView=alertDialog.findViewById(android.R.id.message);
            // muudan, et textview teksti kuvatakse akna keskel
            textView.setGravity(Gravity.CENTER);
            // textview tekst on kõik suured tähed
            textView.setAllCaps(true);
            // textview teksti suuruseks määran 28
            textView.setTextSize(28);
        }
    }
    // frontOfKaardidRessurssid meetod, mille läbi omistame oma pildimuutujatele väärtuse ehk määrame pildi
    private void frontOfKaardidRessurssid() {
        pilt101 = R.drawable.cat;
        pilt102 = R.drawable.dog;
        pilt103 = R.drawable.horse;
        pilt104 = R.drawable.janes;
        pilt105 = R.drawable.squirrel;
        pilt106 = R.drawable.wolf;
        pilt201 = R.drawable.cat;
        pilt202 = R.drawable.dog;
        pilt203 = R.drawable.horse;
        pilt204 = R.drawable.janes;
        pilt205 = R.drawable.squirrel;
        pilt206 = R.drawable.wolf;
    }
}