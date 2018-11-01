package com.example.ivan.appoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class denunciar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denunciar);

        WebView webview = (WebView) findViewById(R.id.webview2);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://www.delegaciaeletronica.policiacivil.sp.gov.br/ssp-de-cidadao/pages/comunicar-ocorrencia/injuria-calunia-ou-difamacao/triagem-agressao-fisica");

    }
}
