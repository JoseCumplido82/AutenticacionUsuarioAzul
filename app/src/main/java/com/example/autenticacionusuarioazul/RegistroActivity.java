package com.example.autenticacionusuarioazul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autenticacionusuarioazul.clases.Usuario;

public class RegistroActivity extends AppCompatActivity {
    public static final String EXTRA_OBJETO_USUARIO ="usuario" ;
    EditText edt_password1 = null;
    EditText edt_password2 = null;
    EditText edt_nombre_r =null;
    EditText edt_direccion_r=null;
    EditText edt_telefono_r=null;
    EditText edt_email_r = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edt_password1=(EditText)findViewById(R.id.edt_password_r);
        edt_password2=(EditText)findViewById(R.id.edt_password2_r);
        edt_direccion_r=(EditText)findViewById(R.id.edt_direccion_r);
        edt_nombre_r=(EditText)findViewById(R.id.edt_nombre_r);
        edt_telefono_r=(EditText)findViewById(R.id.edt_phone_r);
        edt_email_r=(EditText)findViewById(R.id.edt_email_r);
    }

    public void crear(View view) {
        //1 comprobar que los passwords coinciden
        String password1 = String.valueOf(edt_password1.getText());
        String password2 = String.valueOf(edt_password2.getText());
        if(! password1.equals(password2)){
            Toast.makeText(this, "las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            edt_password1.setBackgroundResource(R.color.colorError);
            edt_password2.setBackgroundColor(getResources().getColor(R.color.colorError));
            return;
        }

        //2 crear un objeto de tipo usuario
        String nombre = String.valueOf(edt_nombre_r.getText());
        String direccion = String.valueOf(edt_direccion_r.getText());
        String telefono = String.valueOf(edt_telefono_r.getText());
        String email= String.valueOf(edt_email_r.getText());
        Usuario u = new Usuario(nombre,direccion,telefono,email,password1);
        Log.i("usuarios", u.toString());// es como el printLn

        //3 redireccionar al HomeActivity
        Intent intent = new Intent(this, ActivityHome.class);
        intent.putExtra(EXTRA_OBJETO_USUARIO, u);//para recoger esa variable en el objeto home
        startActivity(intent);

    }
}