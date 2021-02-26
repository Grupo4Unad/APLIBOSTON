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
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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



        mAuth=FirebaseAuth.getInstance(); btn_cerrar = findViewById(R.id.btn_cerrar);

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) { mAuth.signOut();
            Intent i = new Intent(MenuActivity.this,MainActivity.class); startActivity(i);
            finish();


        }
        });







    }



}