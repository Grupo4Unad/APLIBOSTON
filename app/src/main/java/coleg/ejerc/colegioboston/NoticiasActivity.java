package coleg.ejerc.colegioboston;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import coleg.ejerc.colegioboston.modelo.Noticia;

public class NoticiasActivity extends AppCompatActivity {
     ArrayList mData;
    private ListView listaNotas;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference noticiasRef = database.getReference("noticias");
        mData = new ArrayList();
        linearLayout = findViewById(R.id.list_view_noticias);

        noticiasRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                final Noticia n = snapshot.getValue(Noticia.class);
                System.out.println(" $%$$$·%&/" + n.getTitulo());
                TextView t = new TextView(NoticiasActivity.this);
                t.setTextSize(25);
                t.setText(n.getTitulo());
                TextView c = new TextView(NoticiasActivity.this);
                c.setText(n.getContenido());
                TextView u = new TextView(NoticiasActivity.this);
                u.setText(n.getUrl());
                u.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = n.getUrl();
                        Intent urlIntent = new Intent(Intent.ACTION_SENDTO);
                        urlIntent.setData(Uri.parse(url));

                        try {
                            startActivity(urlIntent);
                        } catch (ActivityNotFoundException e) {
                            Toast.makeText(NoticiasActivity.this,"Error en intent",Toast.LENGTH_LONG);
                        }
                    }
                });
                u.setWidth(80);
                linearLayout.addView(t);
                linearLayout.addView(c);
                linearLayout.addView(u);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //      Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}