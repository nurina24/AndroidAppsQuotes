package com.nurina.androidapps;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page_1 extends AppCompatActivity {

    private Button q1Fragment,q2Fragment,homebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);

        q1Fragment = findViewById(R.id.q1);
        q2Fragment = findViewById(R.id.q2);
        homebutton = findViewById(R.id.gotohome);


        q1Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Quote1Fragment());
            }
        });

        q2Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Quote2Fragment());
            }
        });

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fm = fragmentManager.beginTransaction();
        fm.replace(R.id.frame, fragment);
        fm.addToBackStack(null);
        fm.commit();
    }
    }

