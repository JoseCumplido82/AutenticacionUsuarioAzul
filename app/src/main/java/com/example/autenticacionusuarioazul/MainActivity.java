package com.example.autenticacionusuarioazul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_EMAIL = "email";
    EditText edt_email= null;
    EditText edt_password= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_email =(EditText)findViewById(R.id.edt_email_r);
        edt_password= (EditText)findViewById(R.id.edt_password_r);
    }

    public void entrar(View view) {
        //primero - recoger el email y el password
         String email= String.valueOf(edt_email.getText());
         String password = String.valueOf(edt_password.getText());
        //segundo - validarlo email y password
         boolean accesoOK= validarUsuario(email, password);

        //tercero - entrar o mostrar error
        if(accesoOK==false){
            edt_email.setError("email o password incorrectos");
            Toast.makeText(this, "email o clave erroneas", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent= new Intent(this, ActivityHome.class);
            intent.putExtra(EXTRA_EMAIL, email);
            startActivity(intent);
            finish();
        }
    }

    private boolean validarUsuario(String email, String password) {
        if(email.equalsIgnoreCase("usuario1@gmail.com")&& password.equals("1234")){
            return true;
        } else{
            return false;
        }
    }

    public void registrarse(View view) {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}