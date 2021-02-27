package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_notas);
    }

    public void agregarNotas(View view)
    {

        Intent i = new Intent(this, AgregarNotasActivity.class);
        startActivity(i);
    }
    public void consultarNotas(View view)
    {

        Intent i = new Intent(this, ConsultarNotasActivity.class);
        startActivity(i);
    }
}