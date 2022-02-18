package com.kummgab.speedquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainGame extends AppCompatActivity {
    Runnable questionRunnable = null;

    public Button bt_retour;

    public TextView pseudo_jr_1;
    public TextView pseudo_jr_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bt_retour = findViewById(R.id.bt_retour);

        pseudo_jr_1 = findViewById(R.id.pseudo_jr_1);
        pseudo_jr_2 = findViewById(R.id.pseudo_jr_2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        pseudo_jr_1.setText(getIntent().getExtras().getString("Joueur1"));
        pseudo_jr_2.setText(getIntent().getExtras().getString("Joueur2"));

        bt_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainGame.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}