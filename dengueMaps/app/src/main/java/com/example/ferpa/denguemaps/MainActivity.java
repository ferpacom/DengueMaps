package com.example.ferpa.denguemaps;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ferpa.denguemaps.entities.PlaceEntity;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ImageView ivswichter;
    private ImageButton bt1;
    private ImageButton bt2;
    private ImageButton bt3;
    private ImageButton bt4;
    private ImageButton bt5;
    private ImageButton btMap;
    private ImageButton btVoluntario;
    private TextView tvSobre;
    private PlaceEntity place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtTitulo = (TextView) findViewById(R.id.texto_fonte);
        TextView txtSobre = (TextView) findViewById(R.id.tv_sobre);
        Typeface fontTitulo = Typeface.createFromAsset(getAssets(), "disoluta-font-FFP.ttf");
        Typeface fontSobre = Typeface.createFromAsset(getAssets(), "Bunaken_Underwater.ttf");
        txtTitulo.setTypeface(fontTitulo);
        txtSobre.setTypeface(fontSobre);
        setUI();
        setData();
        setActions();
    }

    public void clickVoluntario() {
// TODO Auto-generated method stub
        String end = "http://www.curitiba.pr.gov.br/cadastro-voluntario-aedes/";
        Uri uri = Uri.parse(end);
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(uri)));
        startActivity(it);
    }
    private void setData(){
        place = new PlaceEntity();
        place.setLat(-25.385076);
        place.setLng(-49.276626);
    }

    //Aqui que fazemos o Cast dos objetos do .XML para o .JAVA
    private void setUI(){
        ivswichter = (ImageView) findViewById(R.id.iv_swichter);
        bt1 = (ImageButton) findViewById(R.id.bt_1);
        bt2 = (ImageButton) findViewById(R.id.bt_2);
        bt3 = (ImageButton) findViewById(R.id.bt_3);
        bt4 = (ImageButton) findViewById(R.id.bt_4);
        bt5 = (ImageButton) findViewById(R.id.bt_5);
        btMap = (ImageButton) findViewById(R.id.bt_map);
        btVoluntario = (ImageButton) findViewById(R.id.bt_voluntario);
        tvSobre = (TextView) findViewById(R.id.tv_sobre);
    }

    //Aqui é onde aplico o clique dos botoes
    private void setActions(){
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //o que vai acontecer quando o usuario clicar
                ivswichter.setImageResource(R.drawable.imgdengue1);
                Log.i(TAG, "botao 1"); // apenas para mostra no logcat

            }
        });
        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                ivswichter.setImageResource(R.drawable.imgdengue2);
                Log.i(TAG, "botao 2"); // apenas para mostra no logcat

            }
        });
        bt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                ivswichter.setImageResource(R.drawable.imgdengue3);
                Log.i(TAG, "botao 3");// apenas para mostra no logcat

            }
        });
        bt4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                ivswichter.setImageResource(R.drawable.imgdengue4);
                Log.i(TAG, "botao 4");// apenas para mostra no logcat

            }
        });
        bt5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                ivswichter.setImageResource(R.drawable.imgdengue5);
                Log.i(TAG, "botao 5");// apenas para mostra no logcat

            }
        });
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMaps(place);
            }
        });

        btVoluntario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickVoluntario();
            }
        });
        tvSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sobreDengueMaps();
            }
        });
    }
    //Passa os parametros para a MapsActivity
    private void goToMaps(PlaceEntity place){
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        intent.putExtra("place", place);
        startActivity(intent);
    }
    //AlertDialog falando sobre o APP
    public void sobreDengueMaps() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("O que é o DengueMaps?");
        builder.setMessage("DengueMaps é um app que tem como objetivo apontar onde está o foco de Dengue, bem como instruir seus usuários a combater a Dengue. Além disso você pode se candidatar como voluntario para combater esse mosquito, que está tirando o sono da população!! SEJA UM HEROI E AJUDE A SALVAR O MUNDO !!");
        builder.setPositiveButton("Ok", null);
        builder.create();
        builder.show();
    }

}
