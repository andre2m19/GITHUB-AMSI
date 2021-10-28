package amsi.dei.estg.ipleiria.projetoam.vistas;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import amsi.dei.estg.ipleiria.projetoam.MainActivity;
import amsi.dei.estg.ipleiria.projetoam.R;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail, etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        etEmail=findViewById(R.id.etEmail);
        etpass=findViewById(R.id.etpass);
    }

    public void OnClickLogin(View view) {
        String email = etEmail.getText().toString();
        String password = etpass.getText().toString();

        if (!isEmailValido(email)) {
            etEmail.setError("Email invalido");
            return;
        }

        if (!isPasswordValido(password)) {
            etpass.setError("Password invalida");
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EMAIL", email);
        startActivity(intent);
        finish();

        }

        private boolean isEmailValido(String email){
            if(email==null)
                return false;

            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

        private boolean isPasswordValido(String password){
            if(password==null)
                return false;

            return password.length()>=4;
        }
    }