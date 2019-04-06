package com.example.gameteam.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameteam.R;
import com.example.gameteam.entity.Weapon;

import java.util.ArrayList;

public class WeaponAdapter extends BaseAdapter {
    private Context mContext;
    private int itemLayout;
    private ArrayList<Weapon> mData;

    public WeaponAdapter(Context mContext, int itemLayout, ArrayList<Weapon> mData) {
        this.mContext = mContext;
        this.itemLayout = itemLayout;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
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
        //判断是否有移除屏幕的条目布局对象
        if(convertView == null){
            //把条目布局转换成view
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(itemLayout,parent,false);
            holder = new ViewHolder();
            //获取控件
            holder.img = convertView.findViewById(R.id.weapon_icon);
            holder.tv_info = convertView.findViewById(R.id.tv_info);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            //把控件缓存对象和复用的条目布局绑定
            convertView.setTag(holder);
        }else{
            //从复用的条目布局中去除空间缓存对象
            holder = (ViewHolder) convertView.getTag();
        }
        //获取单条数据
        Weapon weapon = mData.get(position);
        //绑定数据
        holder.img.setImageResource(weapon.getIcon());
        holder.tv_name.setText(weapon.getName());
        holder.tv_info.setText(weapon.getInfo());
        return convertView;
    }

    /**
     * 缓存条目布局中的控件
     */
    private class ViewHolder{
        ImageView img;
        TextView tv_name;
        TextView tv_info;
    }
}
