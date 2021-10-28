package amsi.dei.estg.ipleiria.projetoam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import amsi.dei.estg.ipleiria.projetoam.vistas.LoginActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent homeIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(homeIntent);
    }

}