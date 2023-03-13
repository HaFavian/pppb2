package com.example.pppb2_tugasweek2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean isDynamic = false;
    private Button ganti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ganti = findViewById(R.id.tombol_ganti);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StaticFragment staticFragment = new StaticFragment();
        fragmentTransaction.add(R.id.frag,staticFragment).commit();
        ganti.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!isDynamic){
                    displayFragment();
                    }
                else
                {
                    changeFragment();
                    }
            }
        }
        );
    }

    private void displayFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DynamicFragment dynamicFragment = DynamicFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag,dynamicFragment).commit();
        isDynamic = true;
        ganti.setText("Kembali");
    }

    private void changeFragment() {
        FragmentManager fragmentManager =getSupportFragmentManager();
        DynamicFragment dynamicFragment = (DynamicFragment)fragmentManager.findFragmentById(R.id.frag);
        if (dynamicFragment!=null){
            FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frag,new StaticFragment()).commit();
        }
        isDynamic = false;
        ganti.setText("Selanjutnya");

    }

}