package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuProfesorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_profesor);
    }

    public void indexNotas(View view)
    {

       Intent i = new Intent(this, MenuNotasActivity.class);
       startActivity(i);
    }

    public void abrirCrearNoticia(View view) {
        Intent i = new Intent(this, CrearNoticia.class);
        startActivity(i);
    }
}