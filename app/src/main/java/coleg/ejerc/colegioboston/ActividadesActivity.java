package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActividadesActivity extends AppCompatActivity {
    Button btn_guias;
    Button btn_contacto;
    Button btn_calificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        btn_guias= findViewById(R.id.btn_guias);

        btn_calificar = findViewById(R.id.calificar);
        btn_calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActividadesActivity.this, Calificacion.class));
            }
        });

        btn_guias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActividadesActivity.this, DriveActivity.class));
            }});
        btn_contacto = findViewById(R.id.contactar_profe);
        btn_contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActividadesActivity.this, Contacto.class));
            }});


    }

    public void onClickCalificar(View v)
    {

    }
}

