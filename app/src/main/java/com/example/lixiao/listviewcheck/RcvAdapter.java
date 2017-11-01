package com.example.lixiao.listviewcheck;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lixiao on 2017/10/29.
 */

public class RcvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<DataBean> dataBeen ;
    private Context context;

    public RcvAdapter(List<DataBean> dataBeen, Context context) {
        this.dataBeen = dataBeen;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.data_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.tv_name.setText(dataBeen.get(position).getName());
        viewHolder.cb.setChecked(dataBeen.get(position).ischeck());
        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // singleSelect(position);
               mutilSelect(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_name;
        private final CheckBox cb;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            cb = itemView.findViewById(R.id.cb);
        }
    }
    public void mutilSelect(int position){
        DataBean dataBean = dataBeen.get(position);
        boolean ischeck = dataBean.ischeck();
        if(ischeck){
            dataBean.setIscheck(false);
        }else {
            dataBean.setIscheck(true);
        }
        notifyDataSetChanged();
    }
    public void singleSelect(int position){
        for (int i=0;i<dataBeen.size();i++){
            DataBean dataBean = dataBeen.get(i);
            dataBean.setIscheck(false);
        }
        DataBean b = dataBeen.get(position);
        b.setIscheck(true);
        notifyDataSetChanged();
    }

    public void allSelect(){
        for (int i=0;i<dataBeen.size();i++){
            DataBean dataBean = dataBeen.get(i);
            dataBean.setIscheck(true);
        }
        notifyDataSetChanged();

    }
    public void invertSelect(){
        for(int i=0;i<dataBeen.size();i++){
            DataBean bean = dataBeen.get(i);
            if(bean.ischeck()){
                bean.setIscheck(false);
            }else {
                bean.setIscheck(true);
            }
        }
        notifyDataSetChanged();

    }
    public void cancelSelect(){
        for (int i=0;i<dataBeen.size();i++){
            DataBean dataBean = dataBeen.get(i);
            dataBean.setIscheck(false);
        }
        notifyDataSetChanged();

    }
}
