package com.example.gameteam;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gameteam.Utils.CharacterAdapter;
import com.example.gameteam.entity.Character;
import com.example.gameteam.entity.Doctor;
import com.example.gameteam.entity.Mage;
import com.example.gameteam.entity.Warrior;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView img1,img2,img3,img4;
    private ImageView fire1,fire2,fire3,fire4;
    private ListView lv;
    private TextView tv;
    private TextView c_info1,c_info2,c_info3,c_info4;

    private int aNow1=0,aNow2=0,aNow3=0,aNow4=0;
    private int img1_int,img2_int,img3_int,img4_int;
    private int atk1=0,atk2=0,atk3=0,atk4=0,atkall=0;
    private int atkw1=0,atkw2=0,atkw3=0,atkw4=0;

    private int p1=0,p2=0,p3=0,p4=0;

    private int itemLayout;

    private ArrayList<ImageView> aiv;
    private ArrayList<Character> characters;

    private CharacterAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
        lv.setAdapter(mAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(),CharacterInfoActivity.class);
                    intent.putExtra("character_profession", characters.get(position).getProfession());
                    intent.putExtra("character_atk", characters.get(position).getAtk());
                    startActivityForResult(intent, 1);
            }
        });
    }

    public void init(){
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);

        aiv = new ArrayList<>();
        aiv.add(img1);
        aiv.add(img2);
        aiv.add(img3);
        aiv.add(img4);

        img1_int = R.id.img1;
        img2_int = R.id.img2;
        img3_int = R.id.img3;
        img4_int = R.id.img4;

        fire1 = findViewById(R.id.fire1);
        fire2 = findViewById(R.id.fire2);
        fire3 = findViewById(R.id.fire3);
        fire4 = findViewById(R.id.fire4);

        c_info1 = findViewById(R.id.c_info1);
        c_info2 = findViewById(R.id.c_info2);
        c_info3 = findViewById(R.id.c_info3);
        c_info4 = findViewById(R.id.c_info4);


        fire1.setVisibility(View.INVISIBLE);
        fire2.setVisibility(View.INVISIBLE);
        fire3.setVisibility(View.INVISIBLE);
        fire4.setVisibility(View.INVISIBLE);

        itemLayout  = R.layout.item;
        lv = findViewById(R.id.lv);

        tv = findViewById(R.id.textView);

        characters = new ArrayList<>();

        characters.add(new Character(R.drawable.soldier,"张飞","战士",50));
        characters.add(new Character(R.drawable.soldier,"关于","战士",80));
        characters.add(new Character(R.drawable.soldier,"刘备","战士",60));
        characters.add(new Character(R.drawable.soldier,"赵云","战士",60));
        characters.add(new Character(R.drawable.soldier,"黄忠","战士",70));
        characters.add(new Character(R.drawable.master,"郭嘉","法师",50));
        characters.add(new Character(R.drawable.master,"诸葛亮","法师",80));
        characters.add(new Character(R.drawable.master,"马良","法师",50));
        characters.add(new Character(R.drawable.master,"黄月英","法师",60));
        characters.add(new Character(R.drawable.master,"小乔","法师",70));
        characters.add(new Character(R.drawable.doctor,"扁鹊","医生",50));
        characters.add(new Character(R.drawable.doctor,"华佗","医生",80));
        characters.add(new Character(R.drawable.doctor,"吴凤熙","医生",70));
        characters.add(new Character(R.drawable.doctor,"董卓","医生",50));
        characters.add(new Character(R.drawable.doctor,"炼金术士","医生",60));

        mAdapter = new CharacterAdapter(
          getApplicationContext(),
          itemLayout,
            characters
        );
    }

    public void setListener(){
        ImageListener il = new ImageListener();
        img1.setOnClickListener(il);
        img2.setOnClickListener(il);
        img3.setOnClickListener(il);
        img4.setOnClickListener(il);
    }

    public class ImageListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Intent intentImg = new Intent();
            intentImg.setClass(getApplicationContext(), WeaponActivity.class);
            intentImg.putExtra("img_number",v.getId());
            if(img1_int == v.getId()){
                     if(aNow1 == 0){
                         Toast.makeText(getApplicationContext(),"请选择第一个角色后操作",Toast.LENGTH_SHORT).show();
                     }else{
                         startActivityForResult(intentImg, 2);
                     }
            }

            if(img2_int == v.getId()){
                if(aNow2 == 0){
                    Toast.makeText(getApplicationContext(),"请选择第二个角色后操作",Toast.LENGTH_SHORT).show();
                }else{
                    startActivityForResult(intentImg, 2);
                }
            }

            if(img3_int == v.getId()){
                if(aNow3 == 0){
                    Toast.makeText(getApplicationContext(),"请选择第三个角色后操作",Toast.LENGTH_SHORT).show();
                }else{
                    startActivityForResult(intentImg, 2);
                }
            }

            if(img4_int == v.getId()){
                if(aNow4 == 0){
                    Toast.makeText(getApplicationContext(),"请选择第四个角色后操作",Toast.LENGTH_SHORT).show();
                }else{
                    startActivityForResult(intentImg, 2);
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            //Toast.makeText(getApplicationContext(),R.id.img1+"",Toast.LENGTH_SHORT).show();
            int character_icon = 0;
            int atk_now = 0;
            try {
                atk_now = data.getIntExtra("character_atk", 0);
            }catch (Exception e){e.printStackTrace();}

            String profession = null;
            try {
                profession = data.getStringExtra("character_profession");
                switch (profession) {
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
            }catch (Exception e){e.printStackTrace();}
            if(resultCode == 11){
                p1 =  character_icon;
                img1.setImageResource(character_icon);
                atk1 = atk_now;
                aNow1 = 1;
            }

            if(resultCode == 12){
                p2 =  character_icon;
                img2.setImageResource(character_icon);
                atk2 = atk_now;
                aNow2 = 1;
            }

            if(resultCode == 13){
                p3 =  character_icon;
                img3.setImageResource(character_icon);
                atk3 = atk_now;
                aNow3 = 1;
            }

            if(resultCode == 14){
                p4 =  character_icon;
                img4.setImageResource(character_icon);
                atk4 = atk_now;
                aNow4 = 1;
            }
        }

        if(requestCode == 2){
            int weapon_character = 0;

            String weapon_profession = null;
            try {
                weapon_profession = data.getStringExtra("weapon_profession");
                switch (weapon_profession){
                    case "战士":
                        weapon_character = R.drawable.soldier;
                        break;
                    case "法师":
                        weapon_character = R.drawable.master;
                        break;
                    case "医生":
                        weapon_character = R.drawable.doctor;
                        break;
                }
            }catch(Exception e){
                e.printStackTrace();
            }

int weapon_atk = 0;
try {
    weapon_atk = data.getIntExtra("weapon_atk", 0);
}catch (Exception e){e.printStackTrace();}

            if(resultCode == 21){
                if(p1 == weapon_character){
                    atkw1 = weapon_atk * 2;
                    fire1.setVisibility(View.VISIBLE);
                }else{
                    atkw1 = weapon_atk;
                    fire1.setVisibility(View.INVISIBLE);
                }
                c_info1.setText("角色ATK:" + atk1 + "武器ATK:" + atkw1);

            }

            if(resultCode == 22){

                if(p2 == weapon_character){
                    atkw2 = weapon_atk * 2;
                    fire2.setVisibility(View.VISIBLE);
                }else{
                    atkw2 = weapon_atk;
                    fire2.setVisibility(View.INVISIBLE);
                }
                c_info2.setText("角色ATK:" + atk2 + "武器ATK:" + atkw2);

            }

            if(resultCode == 23){

                if(p3 == weapon_character){
                    atkw3 = weapon_atk * 2;
                    fire3.setVisibility(View.VISIBLE);
                }else{
                    atkw3 = weapon_atk;
                    fire3.setVisibility(View.INVISIBLE);
                }
                c_info3.setText("角色ATK:" + atk3 + "武器ATK:" + atkw3);

            }

            if(resultCode == 24){
                if(p4 == weapon_character){
                    atkw4 = weapon_atk * 2;
                    fire4.setVisibility(View.VISIBLE);
                }else{
                    atkw4 = weapon_atk;
                    fire4.setVisibility(View.INVISIBLE);
                }
                c_info4.setText("角色ATK:" + atk4 + "武器ATK:" + atkw4);

            }
        }

        atkall = atk1 + atk2 + atk3 + atk4 + atkw1 + atkw2+ atkw3+ atkw4;
        tv.setText("组队总攻击力为: " + atkall);
    }
}
