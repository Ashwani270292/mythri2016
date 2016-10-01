package com.jss.jssatenmythri2016_17.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jss.jssatenmythri2016_17.R;
import com.jss.jssatenmythri2016_17.util.Text_Getter_Setter;

import java.util.ArrayList;

/**
 * Created by user1 on 29-Sep-16.
 */
public class Event_Adapter extends RecyclerView.Adapter <Event_Adapter.Myholder>{
    ArrayList<Text_Getter_Setter> Name=new ArrayList<Text_Getter_Setter>();
  Context context;
    public Event_Adapter(ArrayList<Text_Getter_Setter> text_getter_setters,Context context) {
        this.context=context;
        this.Name=text_getter_setters;
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        Myholder viewholder=new Myholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        final Text_Getter_Setter name=Name.get(position);
        holder.name.setText(name.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=name.getName();
                 switch (string){

                 }
            }
        });

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }
    public static class Myholder extends RecyclerView.ViewHolder{
        TextView name;
        public Myholder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
