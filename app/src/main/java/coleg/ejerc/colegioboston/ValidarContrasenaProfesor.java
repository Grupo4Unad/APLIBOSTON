package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ValidarContrasenaProfesor extends AppCompatActivity {

// se instancia

    private EditText contrasena;
    @Override
    // se inicializa
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_contrasena_profesor);
        contrasena = findViewById(R.id.txtContrasena);
    }


    public void indexVolverAtras(View view)
    {

        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
    public void validarContrasena(View view)
    {
        String contraseña = "123";
        String contraseña_view = contrasena.getText().toString();

        // poner equals
        if(contraseña.equals(contraseña_view))
        {

            Intent i = new Intent(this, MenuProfesorActivity.class);
            startActivity(i);

        }else
        {
            Toast.makeText(getApplicationContext(), "Contraseña incorrecta.",Toast.LENGTH_SHORT).show();
        }

    }
}