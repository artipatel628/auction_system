package com.enggdream.auctionsystem5.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.enggdream.auctionsystem5.R;
import com.enggdream.auctionsystem5.model.AuctionItem;
import com.enggdream.auctionsystem5.viewholder.AuctionViewHolder;

import java.util.List;

/**
 * Created by PareshDudhat on 13-09-2016.
 */
public class MyAuctionAdapter extends RecyclerView.Adapter<AuctionViewHolder> {
    List<AuctionItem> items;

    public MyAuctionAdapter(List<AuctionItem> items) {
        this.items = items;
    }

    @Override
    public AuctionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AuctionViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder_auction_item, parent, false));
    }

    @Override
    public void onBindViewHolder(AuctionViewHolder holder, int position) {
        AuctionItem item = items.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvDesc.setText(item.getDescription());
        holder.tvBasePrice.setText(String.valueOf(item.getBasePrice()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
