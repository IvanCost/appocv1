package com.example.ivan.appoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class fazer_denuncia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_denuncia);

        WebView webview2 = (WebView) findViewById(R.id.webview1);
        webview2.setWebViewClient(new WebViewClient());
        webview2.loadUrl("https://www.delegaciaeletronica.policiacivil.sp.gov.br/ssp-de-cidadao/pages/acompanhar-andamento");

    }
}
