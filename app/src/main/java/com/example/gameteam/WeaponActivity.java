package com.example.gameteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gameteam.Utils.WeaponAdapter;
import com.example.gameteam.entity.Weapon;

import java.util.ArrayList;

public class WeaponActivity extends AppCompatActivity {
    private ListView lv;
    private int itemLayout;
    private ArrayList<Weapon> mWeapon;
    private WeaponAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon);

    init();
    lv.setAdapter(mAdapter);
    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intentBack = new Intent();
            Weapon weapon = mWeapon.get(position);
            intentBack.putExtra("weapon_atk",weapon.getAtk());
            intentBack.putExtra("weapon_profession",weapon.getProfession());

            int img_number = getIntent().getIntExtra("img_number",0);

            switch(img_number) {
                case R.id.img1:
                    setResult(21,intentBack);
                    break;
                case R.id.img2:
                    setResult(22,intentBack);
                    break;
                case R.id.img3:
                    setResult(23,intentBack);
                    break;
                case R.id.img4:
                    setResult(24,intentBack);
                    break;
            }
            finish();
        }
    });
    }

    public void init(){
        lv = findViewById(R.id.lv_weapon);
        mWeapon = new ArrayList<>();
        mWeapon.add(new Weapon(R.drawable.weapon_01, "倚天剑", "atk30 厉害",30,"战士"));
        mWeapon.add(new Weapon(R.drawable.weapon_02, "青龙剑","atk40  狠", 40,"战士"));
        mWeapon.add(new Weapon(R.drawable.weapon_03, "青龙偃月刀","atk35  666", 35,"战士"));
        mWeapon.add(new Weapon(R.drawable.weapon_04, "冰魄剑", "atk40  你猜",40,"战士"));
        mWeapon.add(new Weapon(R.drawable.weapon_05, "破山剑", "atk30  厉害就完事了",30,"战士"));
        mWeapon.add(new Weapon(R.drawable.weapon_06, "火龙杖", "atk20  厉害就完事了",20,"法师"));
        mWeapon.add(new Weapon(R.drawable.weapon_07, "昆吾刀", "atk40  厉害就完事了",40,"法师"));
        mWeapon.add(new Weapon(R.drawable.weapon_08, "冰雪杖", "atk40  厉害就完事了",40,"法师"));
        mWeapon.add(new Weapon(R.drawable.weapon_09, "乾坤杖", "atk40  厉害就完事了",40,"法师"));
        mWeapon.add(new Weapon(R.drawable.weapon_10, "宝石杖", "atk45  厉害就完事了",45,"法师"));
        mWeapon.add(new Weapon(R.drawable.weapon_11, "附魔杖", "atk35  厉害就完事了",35,"医生"));
        mWeapon.add(new Weapon(R.drawable.weapon_12, "开山斧", "atk30  厉害就完事了",30,"医生"));
        mWeapon.add(new Weapon(R.drawable.weapon_13, "精灵杖", "atk35  厉害就完事了",35,"医生"));
        mWeapon.add(new Weapon(R.drawable.weapon_14, "回春杖", "atk45  厉害就完事了",45,"医生"));
        mWeapon.add(new Weapon(R.drawable.weapon_14, "仙女杖", "atk45  厉害就完事了",45,"医生"));

        itemLayout = R.layout.item_weapon;
        mAdapter = new WeaponAdapter(
                getApplicationContext(),
                itemLayout,
                mWeapon
        );
    }
}
