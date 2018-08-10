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
import com.weis.cloudcreate.bean.AddHumanBean;
import com.weis.cloudcreate.utils.DrawableUtils;
import com.weis.cloudcreate.utils.GlideUtils;
import com.weis.cloudcreate.utils.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/8/4.
 */

public class AddHumanAdapter extends RecyclerView.Adapter<AddHumanAdapter.MsgHolder> {
    private Context context;
    private List<AddHumanBean> dataList = null;

    public AddHumanAdapter(Context context, List<AddHumanBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MsgHolder holder = new MsgHolder(LayoutInflater.from(context).inflate(R.layout.item_add_human, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MsgHolder holder, int position) {
        AddHumanBean bean = dataList.get(position);
        if (position == 0) {
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_add_group);
            GlideUtils.setImageId(context
                    , R.mipmap.icon_add_contact
                    , holder.imgHead
                    , false);
            holder.txSex.setVisibility(View.GONE);
            holder.txNum.setVisibility(View.GONE);
        } else {
            GlideUtils.setImageId(context, R.mipmap.ic_launcher, holder.imgHead, true);
            holder.txSex.setVisibility(View.VISIBLE);
            holder.txSex.setText(bean.getage());
            DrawableUtils.setDrawable(context
                    , holder.txSex
                    , StringUtils.equals("male", bean.getSex()) ? R.mipmap.icon_add_male : R.mipmap.icon_add_female
                    , 0);
            holder.txNum.setVisibility(View.VISIBLE);
            holder.txNum.setText("(" + bean.getNum() + ")");
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
        TextView txNum;
        TextView txSex;
        TextView txSkill;

        public MsgHolder(View itemView) {
            super(itemView);
            imgHead = itemView.findViewById(R.id.img_head);
            txName = itemView.findViewById(R.id.tx_name);
            txNum = itemView.findViewById(R.id.tx_num);
            txSex = itemView.findViewById(R.id.tx_sex);
            txSkill = itemView.findViewById(R.id.tx_skill);
        }
    }
}
