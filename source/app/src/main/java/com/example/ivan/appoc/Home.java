package com.example.ivan.appoc;

import android.app.ActivityOptions;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.ivan.appoc.acitivity.configuracoes_mensagens;
import com.example.ivan.appoc.acitivity.conversas;
import com.example.ivan.appoc.config.ConfiguracaoFirebase;
import com.example.ivan.appoc.helper.UsuarioFirebase;
import com.example.ivan.appoc.model.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.StorageReference;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import com.example.ivan.appoc.acitivity.mensagens;

public class Home extends AppCompatActivity {

    FirebaseAuth autenticacao;

    private StorageReference storageReference;
    private String identificadorDoUsuario;
    private Usuario usuarioLogado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();


        storageReference = ConfiguracaoFirebase.getFirebaseStorage();
        identificadorDoUsuario = UsuarioFirebase.getIdentificadorUsuario();
        usuarioLogado = UsuarioFirebase.getDadosUsuarioLogado();


        createDrawer();

        WebView webview = findViewById(R.id.webViewHome);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://medium.com/pirata-cultural/o-que-%C3%A9-o-q-de-lgbtq-7556af6d8d6f");

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);


        Intent intent = new Intent(Home.this, configuracoes.class);

        final Button desabafa = findViewById(R.id.button14);
        Button mensagens = findViewById(R.id.button15);
        Button denuncia = findViewById(R.id.button16);
        Button perfil = findViewById(R.id.button_perfil);
        final Button configuracoes = findViewById(R.id.button19);
        Button informacoes = findViewById(R.id.button20);
        //Button perfil = (Button) findViewById(R.id.button_perfil);


        desabafa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_desabafa = new Intent(Home.this, com.example.ivan.appoc.desabafa.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_desabafa, scaleBundle);
            }
        });

        mensagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_mensagens = new Intent(Home.this, conversas.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_mensagens, scaleBundle);
            }
        });

        denuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_denuncia = new Intent(Home.this, before_denuncia.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_denuncia, scaleBundle);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_perfil = new Intent(Home.this, mapeamentoHomo.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_perfil, scaleBundle);
            }
        });

        configuracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_config = new Intent(Home.this, configuracoes_mensagens.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_config, scaleBundle);
            }
        });

        informacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_info = new Intent(Home.this, Sobre.class);
                Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(
                        v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                startActivity(int_info, scaleBundle);
            }
        });


    }

    private void createDrawer() {

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar);
        toolbar.setTitle( "Feed" );
        //( "Feed" );
        //final TextView textView = (TextView) findViewById(R.id.tvimenu);




        //Itens do Drawer
        final PrimaryDrawerItem nav_perfil = new PrimaryDrawerItem().withIdentifier( 1 ).withName( "Meu Perfil" ).withIcon(R.drawable.man);
        final PrimaryDrawerItem nav_denuncia = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Denuncie").withIcon(R.drawable.denunciar);
        final PrimaryDrawerItem nav_mapaHomo = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Mapa da LGBTQFobia").withIcon(R.drawable.mapeamento);
        final PrimaryDrawerItem nav_agendaSP = new PrimaryDrawerItem().withIdentifier( 1 ).withName( "Agenda São Paulo" ).withIcon(R.drawable.agenda);
        final PrimaryDrawerItem nav_atendimento = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Agendamento de Atendimento" ).withIcon(R.drawable.helpdoctor);
        final PrimaryDrawerItem nav_chat = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Chat" ).withIcon(R.drawable.chatgay);
        //final PrimaryDrawerItem nav_cuidese = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Health Care" ).withIcon(R.drawable.care);
        //final PrimaryDrawerItem nav_exercicios = new PrimaryDrawerItem().withIdentifier( 3 ).withName( "Contador de Exercícios").withIcon( R.drawable.iconexer );
        final PrimaryDrawerItem nav_config = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Configurações" ).withIcon(R.drawable.settigsss);
        PrimaryDrawerItem nav_share = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Compartilhar Aplicativo" ).withIcon(R.drawable.ic_menu_share);
        PrimaryDrawerItem nav_about = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Sobre o Aplicativo" ).withIcon(R.drawable.ic_info_black_24dp);
        PrimaryDrawerItem nav_hate = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Hate Us" ).withIcon(R.drawable.ic_show_chart_black_24dp);
        final PrimaryDrawerItem nav_logout = new PrimaryDrawerItem().withIdentifier( 2 ).withName( "Logout" ).withIcon(R.drawable.sair);





        //Definição do Drawer
        Drawer drawer = new DrawerBuilder()
                .withActivity( this )
                .withToolbar(toolbar)
                .withHeader( R.layout.nav_header)
                .addDrawerItems(
                        nav_perfil,
                        new DividerDrawerItem(),//Divisor
                        nav_denuncia,
                        new DividerDrawerItem(),
                        nav_mapaHomo,
                        new DividerDrawerItem(),
                        nav_agendaSP,
                        new DividerDrawerItem(),
                        nav_atendimento,
                        /*new DividerDrawerItem(),
                        nav_chat,

                        /*new DividerDrawerItem(),
                        nav_calc,
                        new DividerDrawerItem(),
                        nav_cuidese,
                        new DividerDrawerItem(),
                        nav_exercicios,*/


                        new DividerDrawerItem(),
                        nav_config,
                        new SectionDrawerItem().withName( "Informações" ),//Seção
                        nav_share,
                        new DividerDrawerItem(),
                        nav_about,
                        new DividerDrawerItem(),
                        nav_hate,
                        new DividerDrawerItem(),
                        nav_logout

                )
                .withOnDrawerItemClickListener( new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if(drawerItem == nav_perfil) abrirPerfil();
                        else if (drawerItem == nav_denuncia) abrirTelaDenuncia();
                        else if (drawerItem == nav_mapaHomo) abrirTelaMapa();
                        else if (drawerItem == nav_agendaSP) abrirTelaAgendaSP();
                        else if (drawerItem == nav_atendimento) abrirTelaAtendimento();

                        else if (drawerItem == nav_chat) abrirTelaChat();
                        //else if (drawerItem == nav_cuidese) abrirTelaHealthCare();
                        //else if (drawerItem == nav_exercicios) abrirTelaExercicios();


                        else if (drawerItem == nav_logout) deslogarUsuario(view);
                        else if (drawerItem == nav_config) abrirTelaConfiguracoes();
                        //textView.setText( "Você clicou em: " + ((Nameable) drawerItem).getName().getText( CalendarioMain.this ) );

                        return false;
                    }
                } )
                //.withSelectedItemByPosition( 0 )
                .build();
    }

    //metodos para abrir as telas

    public void abrirPerfil (){

        Intent chamaMetodo = new Intent( getApplicationContext(), configuracoes_mensagens.class );
        startActivity( chamaMetodo );
    }

    public void abrirTelaDenuncia () {

        Intent chamaMetodo = new Intent( getApplicationContext(), before_denuncia.class );
        startActivity( chamaMetodo );
    }

    public void abrirTelaMapa () {

        Intent chamaMetodo = new Intent( getApplicationContext(), mapeamentoHomo.class );
        startActivity( chamaMetodo );
    }

    public void abrirTelaAtendimento () {

        Intent chamaMetodo = new Intent( getApplicationContext(), desabafa.class );
        startActivity( chamaMetodo );
    }

    public void abrirTelaAgendaSP () {

        Intent chamaMetodo = new Intent( getApplicationContext(), agendaSP.class );
        startActivity( chamaMetodo );
    }

    public void abrirTelaChat() {

        Intent chamaMetodo = new Intent( getApplicationContext(), conversas.class );
        startActivity( chamaMetodo );
    }

    /*public void abrirTelaCalculadora () {

        Intent chamaMetodo = new Intent( getApplicationContext(), calculadoraDeCarboidratos.class );
        startActivity( chamaMetodo );
    }

    public void abrirTelaHealthCare() {

        Intent chamaMetodo = new Intent( getApplicationContext(), healthCare.class );
        startActivity( chamaMetodo );
    }

    public void abrirTelaDieta() {

        Intent chamaMetodo = new Intent( getApplicationContext(), minhaDieta.class );
        startActivity( chamaMetodo );
    }*/

    public void abrirTelaConfiguracoes() {

        Intent intent = new Intent(getApplicationContext(), configuracoes.class);
        final NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        //mBuilder.setContentText("Clique Aqui para configurar as suas notificações e pop-ups");
        mBuilder.setContentTitle("BEM VINDO(A)!!!");
        mBuilder.setContentIntent(android.app.PendingIntent.getActivity(this, 0, intent, 0));
        mBuilder.setSmallIcon(R.drawable.logo);
        mBuilder.setAutoCancel(true);

        mBuilder.getNotification().flags|= Notification.FLAG_AUTO_CANCEL;




        Notification n = mBuilder.build();
        n.vibrate = new long[]{150, 300,150,600};
        nm.notify(R.drawable.logo, n);

        startActivity( intent );
    }

    public void abrirTelaExercicios() {

        Intent chamaMetodo = new Intent( getApplicationContext(), Home.class );
        startActivity( chamaMetodo );
    }

    public void deslogarUsuario(View view) {
        try {
            autenticacao.signOut();
            voltarLogin(view);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void voltarLogin(View view){
        Intent intent = new Intent (Home.this, mensagens.class);
        startActivity(intent);

    }

}


