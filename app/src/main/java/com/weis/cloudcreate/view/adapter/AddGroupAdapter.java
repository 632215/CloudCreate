package com.weis.cloudcreate.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.AddGroupBean;
import com.weis.cloudcreate.utils.DrawableUtils;
import com.weis.cloudcreate.utils.GlideUtils;
import com.weis.cloudcreate.utils.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/8/4.
 */

public class AddGroupAdapter extends RecyclerView.Adapter<AddGroupAdapter.MsgHolder> {
    private Context context;
    private List<AddGroupBean> dataList = null;

    public AddGroupAdapter(Context context, List<AddGroupBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MsgHolder holder = new MsgHolder(LayoutInflater.from(context).inflate(R.layout.item_add_group, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MsgHolder holder, int position) {
        AddGroupBean bean = dataList.get(position);
        if (position == 0) {
            GlideUtils.setImageId(context, R.mipmap.icon_add_group, holder.imgHead, false);
            holder.txNum.setVisibility(View.GONE);
            holder.txSpecial.setVisibility(View.GONE);
        } else {
            GlideUtils.setImageId(context, R.mipmap.ic_launcher, holder.imgHead, true);
            holder.txNum.setVisibility(View.VISIBLE);
            holder.txNum.setText(bean.getNum());
            holder.txSpecial.setVisibility(View.VISIBLE);
            holder.txSpecial.setText(bean.getSpecial());
        }
        holder.txName.setText(bean.getName());
        holder.txSkill.setText(bean.getSkill());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MsgHolder extends RecyclerView.ViewHolder {
        ImageView imgHead;
        TextView txName;
        TextView txSpecial;
        TextView txNum;
        TextView txSkill;

        public MsgHolder(View itemView) {
            super(itemView);
            imgHead = itemView.findViewById(R.id.img_head);
            txName = itemView.findViewById(R.id.tx_name);
            txSpecial = itemView.findViewById(R.id.tx_special);
            txNum = itemView.findViewById(R.id.tx_num);
            txSkill = itemView.findViewById(R.id.tx_skill);
        }
    }
}
