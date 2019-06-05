package com.ks.dayfx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.ks.dayfx.R;
import com.ks.dayfx.bean.Hot;

import java.util.ArrayList;

/**
 * Created by F0519 on 2019/6/5.
 */

public class RCLhotMyadapter extends RecyclerView.Adapter<RCLhotMyadapter.ViewHolder> {
    private ArrayList<Hot.RecentBean> mRecentBeans;
    private Context context;

    public RCLhotMyadapter(ArrayList<Hot.RecentBean> recentBeans, Context context) {
        mRecentBeans = recentBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hot.RecentBean bean = mRecentBeans.get(position);
        holder.tv.setText(bean.getTitle());
        RoundedCorners corners = new RoundedCorners(30);
        RequestOptions options = RequestOptions.bitmapTransform(corners);
        Glide.with(context).load(bean.getThumbnail()).apply(options).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return mRecentBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
           iv= itemView.findViewById(R.id.iv);
           tv=itemView.findViewById(R.id.tv);
        }
    }
}
