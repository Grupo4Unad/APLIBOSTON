package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivityAyudas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ayudas);
    }
    public void irprofes(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.superprof.co/"));
        startActivity(i);
    }

    public void deportes(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://educacionfisica30.blogspot.com.es/"));
        startActivity(i);
    }
    public void ciencias(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.anatomia.tripod.com/"));
        startActivity(i);
    }
    public void matematicas(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://es.khanacademy.org/math"));
        startActivity(i);
    }
    public void tecnologia(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://infotechnology.com.ar"));
        startActivity(i);
    }
    public void lbrosgratis(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://librosgratis.com.es/"));
        startActivity(i);
    }
    public void youtube(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://youtube.com"));
        startActivity(i);
    }
    public void google(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
        startActivity(i);
    }
    public void facebok(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com"));
        startActivity(i);
    }
    public void twitter(View view){
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com"));
        startActivity(i);
    }

}