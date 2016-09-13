package com.enggdream.auctionsystem5.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.enggdream.auctionsystem5.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PareshDudhat on 13-09-2016.
 */
public class AuctionViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.tv_desc)
    public TextView tvDesc;
    @BindView(R.id.tv_base_price)
    public TextView tvBasePrice;

    public AuctionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
