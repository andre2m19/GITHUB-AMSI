package com.example.myapplicationtestproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class AppMainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private String user;
    private int backpress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main_menu);

        userdatareload();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.Nav_View);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){


            case R.id.nav_Qrcode:
                //todo do something pretty
                drawer.closeDrawer(GravityCompat.START);
                Intent intent2 = new Intent(this, QrCode.class);
                startActivity(intent2);

                break;

            case R.id.nav_items:
                //todo do something pretty

                drawer.closeDrawer(GravityCompat.START);
                Intent intent4 = new Intent(this, AppItemMenu.class);
                startActivity(intent4);

                break;

            case R.id.nav_orders:
                //todo do something pretty

                break;

            case R.id.nav_maps:
                //todo do something pretty
                drawer.closeDrawer(GravityCompat.START);
                Intent intent3 = new Intent(this, GoogleMaps.class);
                startActivity(intent3);

                break;

            case R.id.nav_profile:
                //todo do something pretty

            case R.id.nav_logout:
                logout();
                break;
        }

        return true;
    }

    private void logout(){
        Toast.makeText(this, "logout com sucesso ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            backpress = (backpress + 1);
            Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();

            if (backpress > 1) {
                super.onBackPressed();
            }
        }
    }


    private void userdatareload(){
        user=getIntent().getStringExtra("USER_NAME").toString();
        SharedPreferences sharedPreferencesInfoUser = getSharedPreferences("DADOS_USER", Context.MODE_PRIVATE);

        if(user!=null){
            //armazenar no shared
            SharedPreferences.Editor editor = sharedPreferencesInfoUser.edit();
            editor.putString("USER_NAME", user);
            editor.apply();
        }
    }
}