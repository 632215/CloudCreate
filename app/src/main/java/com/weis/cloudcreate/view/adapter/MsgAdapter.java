package com.weis.cloudcreate.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.MsgBean;
import com.weis.cloudcreate.utils.GlideUtils;
import com.weis.cloudcreate.view.activity.DialogActivity;

import java.util.List;

/**
 * Created by Administrator on 2018/8/4.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgHolder> {
    private Context context;
    private List<MsgBean> dataList = null;

    public MsgAdapter(Context context, List<MsgBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MsgHolder holder = new MsgHolder(LayoutInflater.from(context).inflate(R.layout.item_msg, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MsgHolder holder, int position) {
        final MsgBean bean = dataList.get(position);
        GlideUtils.setImageId(context, bean.getImgID(), holder.imgHead, true);
        holder.txName.setText(bean.getName());
        holder.txContent.setText(bean.getContent());
        holder.txNum.setText(bean.getNum());
        holder.clRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,DialogActivity.class).putExtra("MsgBean",bean));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MsgHolder extends RecyclerView.ViewHolder {
        ConstraintLayout clRoot;
        ImageView imgHead;
        TextView txName;
        TextView txContent;
        TextView txNum;

        public MsgHolder(View itemView) {
            super(itemView);
            clRoot = itemView.findViewById(R.id.cl_root);
            imgHead = itemView.findViewById(R.id.img_head);
            txName = itemView.findViewById(R.id.tx_name);
            txContent = itemView.findViewById(R.id.tx_content);
            txNum = itemView.findViewById(R.id.tx_num);
        }
    }
}
