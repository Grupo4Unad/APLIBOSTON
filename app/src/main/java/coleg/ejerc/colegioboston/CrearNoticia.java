package coleg.ejerc.colegioboston;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import coleg.ejerc.colegioboston.modelo.Notas;
import coleg.ejerc.colegioboston.modelo.Noticia;

public class CrearNoticia extends AppCompatActivity {

    private ProgressDialog dialog;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_noticia);
        dialog = new ProgressDialog(this);
        this.dialog.setCancelable(false);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("noticias");
    }

    public void noticiaCreada(){
        this.dialog.dismiss();
        Toast.makeText(this, "Noticia Creada", Toast.LENGTH_SHORT).show();
    }

    public void crear(View view) {
        this.dialog.setMessage("Creando noticia" + "...");
        this.dialog.show();
        final EditText titulo = findViewById(R.id.titulo_noticia);
        final MultiAutoCompleteTextView contenido = findViewById(R.id.contenido_noticia);
        final EditText url = findViewById(R.id.url_noticia);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                agregarNoticia(titulo.getText().toString(), contenido.getText().toString(), url.getText().toString() );
                Toast.makeText(CrearNoticia.this, "Noticia Creada", Toast.LENGTH_SHORT).show();
            }
        };
        new Handler().postDelayed(r
                , 3000);
    }

    public void agregarNoticia( String titulo,String contenido,String url )
    {



        //  Toast.makeText(getApplicationContext(), ciclo_seleccionado+"-"+curso_seleccionado+"-"+nota,Toast.LENGTH_SHORT).show();

            Noticia nuevaNoticia = new Noticia(titulo, contenido, url);
            myRef.push().setValue(nuevaNoticia).addOnSuccessListener(new OnSuccessListener<Void>() {
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
            Intent i = new Intent(this, MenuProfesorActivity.class);
            startActivity(i);


    }
}