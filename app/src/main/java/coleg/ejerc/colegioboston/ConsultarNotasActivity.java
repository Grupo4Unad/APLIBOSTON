package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class ConsultarNotasActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private  DatabaseReference myRef;
    private TextView verNotas;
    private ListView listaNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_notas);

        listaNotas = findViewById(R.id.list_view_estudiantes);
        final ArrayList mData;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("notas_estudiante");
        mData = new ArrayList();

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> mapita = (Map<String, Object>) dataSnapshot.getValue();
              //  String value = dataSnapshot.getValue(String.class);
               // Toast.makeText(getApplicationContext(), value,Toast.LENGTH_SHORT).show();

                mData.addAll(mapita.entrySet());
ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,mData);
listaNotas.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
          //      Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}