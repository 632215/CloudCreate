package com.weis.cloudcreate.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weis.cloudcreate.R;

import java.util.List;

/**
 * Created by Administrator on 2018/8/4.
 */

public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.MsgHolder> {
    private Context context;
    private List<String> dataList = null;
    private ItemOnClickListener listener;

    public BusinessAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public BusinessAdapter(Context context, List<String> dataList, ItemOnClickListener listener) {
        this.context = context;
        this.dataList = dataList;
        this.listener =listener;
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void setListener(ItemOnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MsgHolder holder = new MsgHolder(LayoutInflater.from(context).inflate(R.layout.item_business, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MsgHolder holder, final int position) {
        holder.name.setText(dataList.get(position));
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null)
                    listener.onItemOnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface ItemOnClickListener {
        void onItemOnClick(int position);
    }

    public class MsgHolder extends RecyclerView.ViewHolder {
        TextView name;

        public MsgHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tx_name);
        }
    }
}
