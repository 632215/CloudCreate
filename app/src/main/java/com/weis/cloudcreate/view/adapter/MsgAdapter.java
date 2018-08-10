package com.weis.cloudcreate.view.adapter;

import android.content.Context;
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
        MsgBean bean = dataList.get(position);
//        Glide.with(context)
//                .load(R.mipmap.ic_launcher)
//                .apply(new RequestOptions()
//                        .bitmapTransform(new CircleCrop())
//                        .error(R.mipmap.icon_fail_pic)
//                        .placeholder(R.mipmap.icon_fail_pic))
//                .into( holder.imgHead);
        GlideUtils.setImageId(context,bean.getImgID(),holder.imgHead,true);
        holder.txName.setText(bean.getName());
        holder.txContent.setText(bean.getContent());
        holder.txNum.setText(bean.getNum());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MsgHolder extends RecyclerView.ViewHolder {
        ImageView imgHead;
        TextView txName;
        TextView txContent;
        TextView txNum;

        public MsgHolder(View itemView) {
            super(itemView);
            imgHead = itemView.findViewById(R.id.img_head);
            txName = itemView.findViewById(R.id.tx_name);
            txContent = itemView.findViewById(R.id.tx_content);
            txNum = itemView.findViewById(R.id.tx_num);
        }
    }
}
