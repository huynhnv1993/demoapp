package com.example.windows10gamer.demo1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windows10gamer.demo1.R;
import com.example.windows10gamer.demo1.model.Categ;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Windows 10 Gamer on 30/05/2017.
 */

public class CategAdapter extends BaseAdapter{
    ArrayList<Categ> arrayListcateg;
    Context context;

    public CategAdapter(ArrayList<Categ> arrayListcateg, Context context) {
        this.arrayListcateg = arrayListcateg;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListcateg.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListcateg.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        TextView txtnamecateg;
        ImageView imgcateg;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder =null;
        if (view ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.line_listview_categ,null);
            viewHolder.txtnamecateg = (TextView) view.findViewById(R.id.textviewsubcateg);
            viewHolder.imgcateg = (ImageView) view.findViewById(R.id.imagecateg);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
            Categ categ= (Categ) getItem(i);
            viewHolder.txtnamecateg.setText(categ.getName());
            Picasso.with(context).load(categ.getImage())
                    .placeholder(R.drawable.noimage)
                    .error(R.drawable.error)
                    .into(viewHolder.imgcateg);
        }
        return view;
    }
}
