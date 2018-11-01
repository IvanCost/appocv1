package com.example.ivan.appoc;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class before_sos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_sos);

        final Button acompanhar = (Button) findViewById(R.id.button_acompanhar);
        final Button fazer_denuncia = (Button) findViewById(R.id.button_denunciar);


        acompanhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_acompanhar = new Intent(before_sos.this, denunciar.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_acompanhar, scaleBundle);
            }
        });

        fazer_denuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_denunciar = new Intent(before_sos.this, fazer_denuncia.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_denunciar, scaleBundle);
            }
        });


    }
}
