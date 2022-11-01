package com.example.myapplicationmovil;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView btn_Registrar;

    /*
        Host: sql.freedb.tech
        port: 3306
        User: freedb_AdProTienAd
        Pass:  hwGsZ7PHU9egUT#
        DB: freedb_ProTienAd
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inicializadores();
        Iniciar();
        Barra();
        Ventana();
    }//FIN DEL ONCREATE

    private void Ventana(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
    }

    private void Barra(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void Inicializadores(){
        btn_Registrar = (TextView) findViewById(R.id.btn_Registrar_Login);
    }

    private void Iniciar(){
        btn_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegistrarUsuario.class));
            }
        });
    }
}