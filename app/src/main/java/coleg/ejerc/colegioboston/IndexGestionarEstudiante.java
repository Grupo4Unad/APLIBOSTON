package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IndexGestionarEstudiante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_gestionar_estudiante);
    }

    public void agregarEstudiante(View view)
    {

        Intent i = new Intent(this, AgregarEstudiantesActivity.class);
        startActivity(i);
    }

    public void consultarEstudiante(View view)
    {

        Intent i = new Intent(this, ConsultarEstudiantesActivity.class);
        startActivity(i);
    }
}