package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }
    public void onClickWhatsapp(View v)
    {

        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://wa.me/+573124474418")));

    }

    public void onClickMail(View v)
    {
        String mailto = "mailto:amvargasarc@unadvirtual.edu.co" +
                "?" +
                "subject=" + Uri.encode("Asunto: ") +
                "&body=" + Uri.encode("");

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));

        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this,"Error en intent",Toast.LENGTH_LONG);
        }
    }
}