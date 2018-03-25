package com.example.hnf.qoryummuhanifah_1202154357_modul5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.holder> {

    //deklarasi komponen yang akan digunakan
    private Context mContext;
    int mColor;
    private List<AddData> mList;
    public TextView ToDo, Description, Priority;
    public CardView Cardvw;

    //Constructor
    public Adapter(Context cntx, ArrayList<AddData> list, int color){
        this.mContext=cntx;
        this.mList=list;
        this.mColor=color;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //membuat view baru
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardviewlist, parent, false);
        holder Hold = new holder(view);
        return Hold;
    }

    //menyetting nilai yang didapatkan pada viewholder
    @Override
    public void onBindViewHolder(holder holder, int position) {
        AddData data = mList.get(position);
        ToDo.setText(data.getTodo());
        Description.setText(data.getDesc());
        Priority.setText(data.getPrior());
        Cardvw.setCardBackgroundColor(mContext.getResources().getColor(this.mColor));
    }

    //mendapatkan jumlah list
    @Override
    public int getItemCount() {
        return mList.size();
    }

    //mendapatkan list data
    public AddData getData(int position){
        return mList.get(position);
    }

    //untuk menghapus list
    public void deleteData(int del){
        //remove item yang terpilih
        mList.remove(del);
        //memberi notifikasi item yang di remove
        notifyItemRemoved(del);
        notifyItemRangeChanged(del, mList.size());
    }

    class holder extends RecyclerView.ViewHolder{
        public holder(View itemView){
            super(itemView);
            //melakukan referrencing pada layout
            ToDo = itemView.findViewById(R.id.headline);
            Description = itemView.findViewById(R.id.explanation);
            Priority = itemView.findViewById(R.id.number);
            Cardvw = itemView.findViewById(R.id.cardlist);
        }
    }
}
