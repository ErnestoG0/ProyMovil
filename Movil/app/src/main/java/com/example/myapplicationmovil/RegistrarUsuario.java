package com.example.myapplicationmovil;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class RegistrarUsuario extends AppCompatActivity {
    private TextInputLayout til_correo_r,til_usuario_r,til_password_r;
    private Button btn_registrar_r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        Inicializadores();
        Registrar_Usuario();
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
        actionBar.setTitle(R.string.txt_registro);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void Inicializadores(){
        til_correo_r = (TextInputLayout) findViewById(R.id.til_Correo_Registro);
        til_usuario_r = (TextInputLayout) findViewById(R.id.til_Usuario);
        til_password_r = (TextInputLayout) findViewById(R.id.til_Password_Registro);
        btn_registrar_r = (Button) findViewById(R.id.btn_Registrar);
    }

    private void Registrar_Usuario(){
        btn_registrar_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_correo_r = "";
                String s_usuario_r = "";
                String s_password_r = "";
                s_correo_r = til_correo_r.getEditText().getText().toString();
                s_usuario_r = til_usuario_r.getEditText().getText().toString();
                s_password_r = til_password_r.getEditText().getText().toString();
                if(s_correo_r.isEmpty() || !s_correo_r.contains("@")){
                    ShowError(til_correo_r, "Correo Incorrecto");
                }if(s_usuario_r.isEmpty() || s_usuario_r.length() < 5){
                    ShowError(til_usuario_r, "Nombre de Usuario corto");
                }if(s_password_r.isEmpty() || s_password_r.length()<6){
                    ShowError(til_password_r, "Contraseña Muy Debil");
                }else {
                    //Aquiva el codigo del registro
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    //FUNCION DE ERROR
    private void ShowError(TextInputLayout inputEditText, String s){
        inputEditText.setError(s);
        inputEditText.requestFocus();
    }//FIN DE LA FUNCION ERROR
}