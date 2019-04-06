package com.example.gameteam.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameteam.R;
import com.example.gameteam.entity.Character;
import com.example.gameteam.entity.Warrior;

import java.util.ArrayList;

public class CharacterAdapter extends BaseAdapter {
    private Context mContext;
    private int itemLayout;
    private ArrayList<Character> characters;

    public CharacterAdapter(Context mContext, int itemLayout, ArrayList<Character> characters) {
        this.mContext = mContext;
        this.itemLayout = itemLayout;
        this.characters = characters;
    }

    @Override
    public int getCount() {
        return characters.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(itemLayout,parent,false);
            holder = new ViewHolder();

            holder.img = convertView.findViewById(R.id.character_icon);
            holder.tv_name = convertView.findViewById(R.id.character_name);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Warrior warriorInfo;
        Character character = characters.get(position);

        holder.img.setImageResource(R.drawable.role_icon);
        holder.tv_name.setText(character.getName());

        return convertView;
    }

    //缓存条目
    private class ViewHolder{
        ImageView img;
        TextView tv_name;
    }
}
