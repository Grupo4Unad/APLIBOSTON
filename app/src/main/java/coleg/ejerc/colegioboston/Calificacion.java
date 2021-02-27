package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Calificacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        WebView w = findViewById(R.id.webview);
        w.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSen-6_SCpyCfmR8F-plPCXASkYoaSWW5XsPshBlmPpSdDueHA/viewform?usp=sf_link");

    }
}