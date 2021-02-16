package coleg.ejerc.colegioboston;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class DriveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("\n" +
                "https://drive.google.com/drive/folders/1niY-cHyF-lN_la6gcGlpi_vuD8JO_iHJ?usp=sharing");

    }

}