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

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextView btn_iniciar,btn_registrar;
    private TextInputLayout til_correo, til_password;
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
        Registrar();
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
        btn_iniciar = (Button) findViewById(R.id.btn_Iniciar);
        btn_registrar = (TextView) findViewById(R.id.btn_Registrar_Login);
        til_correo = (TextInputLayout) findViewById(R.id.til_Correo);
        til_password = (TextInputLayout) findViewById(R.id.til_Password);
    }

    private void Iniciar(){
        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_correo_login = "";
                String s_password_login = "";
                s_correo_login = til_correo.getEditText().getText().toString();
                s_password_login = til_password.getEditText().getText().toString();
                if(s_correo_login.isEmpty() || !s_correo_login.contains("@")){
                    ShowError(til_correo, "Correo Incorrecto");
                }if(s_password_login.isEmpty() || s_password_login.length()<6){
                    ShowError(til_password,"Contraseña Incorrecta");
                }else {
                    //Aqui va la funcion para iniciar sesion
                }
            }
        });
    }

    private void Registrar(){
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegistrarUsuario.class));
            }
        });
    }

    //FUNCION DE ERROR
    private void ShowError(TextInputLayout inputEditText, String s){
        inputEditText.setError(s);
        inputEditText.requestFocus();
    }//FIN DE LA FUNCION ERROR
}