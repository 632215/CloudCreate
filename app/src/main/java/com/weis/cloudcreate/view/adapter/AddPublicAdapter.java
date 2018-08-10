package com.weis.cloudcreate.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.AddPublicBean;
import com.weis.cloudcreate.utils.DrawableUtils;
import com.weis.cloudcreate.utils.GlideUtils;
import com.weis.cloudcreate.utils.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/8/4.
 */

public class AddPublicAdapter extends RecyclerView.Adapter<AddPublicAdapter.MsgHolder> {
    private Context context;
    private List<AddPublicBean> dataList = null;

    public AddPublicAdapter(Context context, List<AddPublicBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MsgHolder holder = new MsgHolder(LayoutInflater.from(context).inflate(R.layout.item_add_public, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MsgHolder holder, int position) {
        AddPublicBean bean = dataList.get(position);
        GlideUtils.setImageId(context, R.mipmap.ic_launcher, holder.imgHead, true);
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
        TextView txSkill;

        public MsgHolder(View itemView) {
            super(itemView);
            imgHead = itemView.findViewById(R.id.img_head);
            txName = itemView.findViewById(R.id.tx_name);
            txSkill = itemView.findViewById(R.id.tx_skill);
        }
    }
}
