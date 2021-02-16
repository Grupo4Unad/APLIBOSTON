package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActividadesActivity extends AppCompatActivity {
    Button btn_guias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        btn_guias= findViewById(R.id.btn_guias);



        btn_guias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActividadesActivity.this, DriveActivity.class));
            }});
    }
}

