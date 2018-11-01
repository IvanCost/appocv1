package com.example.ivan.appoc;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        Button feed = (Button) findViewById(R.id.button_feed);
        Button mensagens = (Button) findViewById(R.id.button_mensagens);
        Button sos = (Button) findViewById(R.id.button_sos);
        Button mapa_homofobia = (Button) findViewById(R.id.button_mapahomo);
        Button configuracoes = (Button) findViewById(R.id.button_config);
        Button sobre = (Button) findViewById(R.id.button_sobre);


        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_feed = new Intent(Home.this, feed.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_feed, scaleBundle);
            }
        });

        mensagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_mensagens = new Intent(Home.this, mensagens.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_mensagens, scaleBundle);
            }
        });

        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_sos = new Intent(Home.this, before_sos.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_sos, scaleBundle);
            }
        });

        mapa_homofobia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_mapa = new Intent(Home.this, mapa_homofobia.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_mapa, scaleBundle);
            }
        });

        configuracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_config = new Intent(Home.this, configuracoes.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_config, scaleBundle);
            }
        });

        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_sobre = new Intent(Home.this, sobre.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_sobre, scaleBundle);
            }
        });


    }
}
