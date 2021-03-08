package coleg.ejerc.colegioboston;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import coleg.ejerc.colegioboston.modelo.Estudiante;
import coleg.ejerc.colegioboston.modelo.Notas;

public class AgregarEstudiantesActivity extends AppCompatActivity {



    private EditText nombres;
    private EditText apellidos;
    private EditText documento;
    private FirebaseDatabase database;
    private  DatabaseReference myRef;
    private Button guardar;
    FirebaseAuth auth;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_estudiantes);

        nombres = findViewById(R.id.txtNombres);
        apellidos = findViewById(R.id.txtApellidos);
        documento = findViewById(R.id.txtDocumento);
        guardar =findViewById(R.id.btn_agregar_estudiante);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("estudiantes");

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarEstudiante(nombres.getText().toString().trim(),apellidos.getText().toString().trim(),documento.getText().toString().trim());
            }
        });
    }

    public void agregarEstudiante( String nombres,String apellidos,String documento_estudiante )
    {



        //  Toast.makeText(getApplicationContext(), ciclo_seleccionado+"-"+curso_seleccionado+"-"+nota,Toast.LENGTH_SHORT).show();
        if(auth.getCurrentUser()!=null){
            Estudiante AgregarEstudiante = new Estudiante(documento_estudiante);
            myRef.child(documento_estudiante).setValue(nombres + " " +apellidos).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(), "Se ha guardado exitosamente",Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "No se logro guardar la información",Toast.LENGTH_SHORT).show();
                }

            });
            Intent i = new Intent(this, IndexGestionarEstudiante.class);
            startActivity(i);
        }

    }
}