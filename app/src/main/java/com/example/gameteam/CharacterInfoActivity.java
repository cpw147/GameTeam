package com.example.gameteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gameteam.entity.Character;
import com.example.gameteam.entity.Doctor;

import java.util.ArrayList;

public class CharacterInfoActivity extends AppCompatActivity {
    private ImageView img_character_info;
    private Button btn_1,btn_2,btn_3,btn_4,btn_cancel;
    private TextView tv_atk;

    private ArrayList<Character> characters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_info);

        init();
setListener();
    }

    private void init(){
        img_character_info = findViewById(R.id.img_character_icon);

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_cancel = findViewById(R.id.btn_cancel);

        tv_atk = findViewById(R.id.tv_atk);

        characters = new ArrayList<>();

        tv_atk.setText("攻击力: " + getIntent().getIntExtra("character_atk",0) + "");

        int character_icon = 0;
        String profession = getIntent().getStringExtra("character_profession");
        switch (profession){
            case "战士":
                character_icon = R.drawable.soldier;
                break;
            case "法师":
                character_icon = R.drawable.master;
                break;
            case "医生":
                character_icon = R.drawable.doctor;
                break;
        }

        img_character_info.setImageResource(character_icon);
    }

  private void setListener(){
        ButtonListener bl = new ButtonListener();
        btn_1.setOnClickListener(bl);
        btn_2.setOnClickListener(bl);
        btn_3.setOnClickListener(bl);
        btn_4.setOnClickListener(bl);
        btn_cancel.setOnClickListener(bl);
  }

    public class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intentBack = new Intent();
            intentBack.putExtra("character_profession", getIntent().getStringExtra("character_profession"));
            intentBack.putExtra("character_atk", getIntent().getIntExtra("character_atk",0));
            switch (v.getId()){
                case R.id.btn_1:
                        setResult(11,intentBack);
                        finish();
                case R.id.btn_2:
                    setResult(12,intentBack);
                    finish();
                case R.id.btn_3:
                    setResult(13,intentBack);
                    finish();
                case R.id.btn_4:
                    setResult(14,intentBack);
                    finish();
                case R.id.btn_cancel:
                    setResult(15,intentBack);
                    finish();
            }
        }
    }
}
