package com.kummgab.speedquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.UiModeManager;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private UiModeManager uiModeManager;
    public Button bt_para_retour;
    public Button bt_jouer;

    public ConstraintLayout para_layout;
    public ConstraintLayout main_log_layout;

    public TextView main_joueur_1;
    public TextView main_joueur_2;

    public SwitchCompat switch_night_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uiModeManager = (UiModeManager) getSystemService(UI_MODE_SERVICE);
        setContentView(R.layout.activity_main);


        Toolbar mainToolbar = findViewById(R.id.main_toolBar);
        setSupportActionBar(mainToolbar);

        switch_night_mode = findViewById(R.id.switch_night_mode);
        bt_para_retour = findViewById(R.id.bt_para_retour);
        para_layout = findViewById(R.id.para_layout);
        main_log_layout = findViewById(R.id.main_log_layout);
        bt_jouer = findViewById(R.id.bt_jouer);

        main_joueur_1 = findViewById(R.id.main_joueur_1);
        main_joueur_2 = findViewById(R.id.main_joueur_2);

        /*

        Toolbar mainToolbar = findViewById(R.id.main_toolBar);
        setSupportActionBar(mainToolbar);

         */
    }

    public void NightModeON(){
        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_YES);
    }

    public void NightModeOFF(){
        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean isON = false;

        if (switch_night_mode.isChecked()) {
            if (isON = false) {
                NightModeON();
            } else {
                NightModeOFF();
            }
            isON = true;
        };

        bt_para_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                para_layout.setVisibility(View.GONE);
                main_log_layout.setVisibility(View.VISIBLE);
            }
        });

        bt_jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainGame.class);
                intent.putExtra("Joueur1", main_joueur_1.getText());
                intent.putExtra("Joueur2", main_joueur_2.getText());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_parametre:
                para_layout.setVisibility(View.VISIBLE);
                main_log_layout.setVisibility(View.GONE);
                break;
            case R.id.action_questions:

                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}