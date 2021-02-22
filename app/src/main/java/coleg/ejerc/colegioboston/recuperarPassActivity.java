package coleg.ejerc.colegioboston;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class recuperarPassActivity extends AppCompatActivity {

    private Button btn_verificar;
    private EditText et_mail;
    AwesomeValidation awesomeValidation;
    FirebaseAuth firebaseAuth;

    private  String mail="";
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_pass);
        firebaseAuth = FirebaseAuth.getInstance();
        mAuth=FirebaseAuth.getInstance();
        et_mail = findViewById(R.id.et_mail);
        btn_verificar= findViewById(R.id.btn_verificar);

//Boton verificar
        btn_verificar.setOnClickListener(new View.OnClickListener() {
            String mail="";
            @Override
            public void onClick(View view) {
                mail = et_mail.getText().toString().trim();
                getEnviarCorreo();
            }
        });

    }
    //metodo para recuperar correo
    private void getEnviarCorreo(){
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                startActivity(new Intent(recuperarPassActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
