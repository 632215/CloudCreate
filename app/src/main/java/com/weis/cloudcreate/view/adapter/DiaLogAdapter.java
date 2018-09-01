package com.weis.cloudcreate.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.DialogBean;
import com.weis.cloudcreate.utils.GlideUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/8/4.
 */

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.MsgHolder> {
    private Context context;
    private List<DialogBean> dataList = null;

    public DialogAdapter(Context context, List<DialogBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MsgHolder holder = new MsgHolder(LayoutInflater.from(context).inflate(R.layout.item_dialog, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MsgHolder holder, int position) {
        final DialogBean bean = dataList.get(position);
        holder.rlLeft.setVisibility(View.GONE);
        holder.imgHeadLeft.setVisibility(View.GONE);
        holder.txMsgLeft.setVisibility(View.GONE);
        holder.imgMsgLeft.setVisibility(View.GONE);
        holder.rlRight.setVisibility(View.GONE);
//        holder.imgHeadRight.setVisibility(View.GONE);
        holder.txMsgRight.setVisibility(View.GONE);
        holder.imgMsgRight.setVisibility(View.GONE);
        holder.txTime.setVisibility(View.GONE);
        switch (bean.getSourceType()) {
            case 0:
                holder.rlLeft.setVisibility(View.VISIBLE);
                holder.imgHeadLeft.setVisibility(View.VISIBLE);
                GlideUtils.setImageId(context, R.mipmap.ic_launcher_round, holder.imgHeadLeft, true);
                switch (bean.getMsgTpye()) {
                    case 0://文字
                        holder.txMsgLeft.setVisibility(View.VISIBLE);
                        holder.txMsgLeft.setText(bean.getContent());
                        break;
                    case 1://图片
                        holder.imgMsgLeft.setVisibility(View.VISIBLE);
                        GlideUtils.setImageId(context, R.mipmap.qq, holder.imgMsgLeft, false);
                        break;
                }
                break;
            case 1:
                holder.rlRight.setVisibility(View.VISIBLE);
                switch (bean.getMsgTpye()) {
                    case 0://文字
                        holder.txMsgRight.setVisibility(View.VISIBLE);
                        holder.txMsgRight.setText(bean.getContent());
                        break;
                    case 1://图片
                        holder.imgMsgRight.setVisibility(View.VISIBLE);
                        GlideUtils.setImageId(context, R.mipmap.qq, holder.imgMsgRight, false);
                        break;
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MsgHolder extends RecyclerView.ViewHolder {
        RelativeLayout rlLeft;
        ImageView imgHeadLeft;
        TextView txMsgLeft;
        ImageView imgMsgLeft;

        RelativeLayout rlRight;
        //        ImageView imgHeadRight;
        TextView txMsgRight;
        ImageView imgMsgRight;

        TextView txTime;

        public MsgHolder(View itemView) {
            super(itemView);
            rlLeft = itemView.findViewById(R.id.rl_left);
            imgHeadLeft = itemView.findViewById(R.id.img_head_left);
            txMsgLeft = itemView.findViewById(R.id.tx_msg_left);
            imgMsgLeft = itemView.findViewById(R.id.img_msg_left);

            rlRight = itemView.findViewById(R.id.rl_right);
//            imgHeadRight = itemView.findViewById(R.id.img_head_right);
            txMsgRight = itemView.findViewById(R.id.tx_msg_right);
            imgMsgRight = itemView.findViewById(R.id.img_msg_right);

            txTime = itemView.findViewById(R.id.tx_time);
        }
    }
}
