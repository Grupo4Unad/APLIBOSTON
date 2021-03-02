package coleg.ejerc.colegioboston;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import coleg.ejerc.colegioboston.modelo.Curso;
//import coleg.ejerc.colegioboston.modelo.CursosManager;
import coleg.ejerc.colegioboston.modelo.Notas;

public class AgregarNotasActivity extends AppCompatActivity {

    Spinner lista_ciclos;
    Spinner lista_cursos;
    String [] datos_ciclos = {"ciclo1", "ciclo2", "ciclo3"};
    String [] datos_cursos = {" Algebra", "Filosofia","Inglés"};
    //private CursosManager cursosManager;
    private EditText notas;
    private EditText documento;
    private FirebaseDatabase database;
    private  DatabaseReference myRef;
    private Button guardar;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //cursosManager = new CursosManager();
        //cursosManager.agregarCurso(new Curso("Inglés"));
        //cursosManager.agregarCurso(new Curso("Filosofía"));
        //cursosManager.agregarCurso(new Curso("Álgebra"));
        setContentView(R.layout.activity_agregar_notas);
        lista_ciclos = findViewById(R.id.lst_ciclo);
        lista_cursos = findViewById(R.id.lst_curso);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos_ciclos);
        //ArrayAdapter<String> adaptador_curso = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,cursosManager.listaEnStrings());
        lista_ciclos.setAdapter(adaptador);
        //lista_cursos.setAdapter(adaptador_curso);
        notas = findViewById(R.id.txtNota);
        documento = findViewById(R.id.txtDocumento);
        guardar =findViewById(R.id.btn_agregar_nota);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("notas_estudiante");

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNota(lista_ciclos.getSelectedItem().toString(),lista_cursos.getSelectedItem().toString(),Double.parseDouble(notas.getText().toString().trim()),documento.getText().toString().trim());
            }
        });


    }
    public void agregarNota( String ciclo_seleccionado,String curso_seleccionado,Double nota ,String documento_estudiante )
    {



      //  Toast.makeText(getApplicationContext(), ciclo_seleccionado+"-"+curso_seleccionado+"-"+nota,Toast.LENGTH_SHORT).show();
        if(auth.getCurrentUser()!=null){
            Notas AgregarNota = new Notas(nota);
            myRef.child(documento_estudiante).child(ciclo_seleccionado).child(curso_seleccionado).setValue(AgregarNota).addOnSuccessListener(new OnSuccessListener<Void>() {
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
            Intent i = new Intent(this, MenuNotasActivity.class);
            startActivity(i);
        }

    }


}