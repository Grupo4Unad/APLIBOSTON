package coleg.ejerc.colegioboston;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;


public class recuperarPassActivity extends AppCompatActivity {

    private Button btn_verificar;
    private EditText et_mail;
    AwesomeValidation awesomeValidation;
    FirebaseAuth firebaseAuth;

    private  String correo;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_pass);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        firebaseAuth = FirebaseAuth.getInstance();
        mAuth=FirebaseAuth.getInstance();
        et_mail = findViewById(R.id.et_mail);
        btn_verificar= findViewById(R.id.btn_verificar);

//Boton verificar
        btn_verificar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               correo =et_mail.getText().toString().trim();
                if (!correo.isEmpty() ){
                getEnviarCorreo();
                }
                else{
                    Toast.makeText(recuperarPassActivity.this, "Falta que coloque mail", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    //metodo para recuperar correo
    private void getEnviarCorreo(){
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(correo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(awesomeValidation.validate()){
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "se envío correo.",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();
                    dameToastdeerror(errorCode);
            }

                }else {
                    Toast.makeText(recuperarPassActivity.this, "Completa todos los datos..!!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private void dameToastdeerror(String error) {

        switch (error) {
            case "ERROR_INVALID_EMAIL":
                Toast.makeText(recuperarPassActivity.this, "La dirección de correo electrónico está mal formateada.", Toast.LENGTH_LONG).show();
                et_mail.setError("La dirección de correo electrónico está mal formateada.");
                et_mail.requestFocus();
                break;

            case "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL":
                Toast.makeText(recuperarPassActivity.this, "Ya existe una cuenta con la misma dirección de correo electrónico pero diferentes credenciales de inicio de sesión. Inicie sesión con un proveedor asociado a esta dirección de correo electrónico.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_EMAIL_ALREADY_IN_USE":
                Toast.makeText(recuperarPassActivity.this, "La dirección de correo electrónico ya está siendo utilizada por otra cuenta..   ", Toast.LENGTH_LONG).show();
                et_mail.setError("La dirección de correo electrónico ya está siendo utilizada por otra cuenta.");
                et_mail.requestFocus();
                break;



            case "ERROR_USER_DISABLED":
                Toast.makeText(recuperarPassActivity.this, "La cuenta de usuario ha sido inhabilitada por un administrador..", Toast.LENGTH_LONG).show();
                break;



            case "ERROR_USER_NOT_FOUND":
                Toast.makeText(recuperarPassActivity.this, "No hay ningún registro de usuario que corresponda a este identificador. Es posible que se haya eliminado al usuario.", Toast.LENGTH_LONG).show();
                break;



        }

    }

}
