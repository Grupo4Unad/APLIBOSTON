package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    ImageView img_estudiantes;
    ImageView img_docentes;
    Button btn_cerrar;
    Button btn_ayudas;
    Button btn_agenda;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_agenda=findViewById ( R.id.btn_agenda );


        img_estudiantes = findViewById(R.id.img_estudiantes);

        img_estudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MenuActivity.this, ActividadesActivity.class));

            }
        });

        img_docentes = findViewById(R.id.img_docentes);

        img_docentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MenuActivity.this, ValidarContrasenaProfesor .class));

            }
        });



        mAuth=FirebaseAuth.getInstance();
        btn_cerrar = findViewById(R.id.btn_cerrar);

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) { mAuth.signOut();
            Intent i = new Intent(MenuActivity.this,MainActivity.class); startActivity(i);
            finish();


        }
        });

        btn_ayudas=findViewById(R.id.btn_ayudas);
        btn_ayudas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente=new Intent(MenuActivity.this, MainActivityAyudas.class);
                startActivity(siguiente);
            }
        });

        btn_agenda=findViewById(R.id.btn_agenda);
        btn_agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente=new Intent(MenuActivity.this, Fechas_y_eventos.class);
                startActivity(siguiente);
            }
        });

    }



}