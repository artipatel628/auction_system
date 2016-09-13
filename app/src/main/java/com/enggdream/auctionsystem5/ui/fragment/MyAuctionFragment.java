package com.enggdream.auctionsystem5.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.enggdream.auctionsystem5.R;
import com.enggdream.auctionsystem5.adapter.MyAuctionAdapter;
import com.enggdream.auctionsystem5.db.DatabaseHelper;
import com.enggdream.auctionsystem5.model.AuctionItem;
import com.enggdream.auctionsystem5.ui.activity.MainActivity;
import com.enggdream.auctionsystem5.util.PreferenceUtil;

import java.sql.SQLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PareshDudhat on 13-09-2016.
 */
public class MyAuctionFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView rvMyAuctions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_auction, container, false);
        ButterKnife.bind(this, view);
        try {
            List<AuctionItem> items = DatabaseHelper.getInstance(getContext()).getMyAuctions(
                    PreferenceUtil.getActiveUserID(getContext())
            );
            MyAuctionAdapter adapter = new MyAuctionAdapter(items);
            rvMyAuctions.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMyAuctions.setAdapter(adapter);
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), e.getLocalizedMessage(),
                    Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    @OnClick(R.id.fab)
    void createAuction() {
        ((MainActivity) getActivity()).displayFragment(
                MainActivity.FRAGMENT_CREATE_AUCTION,
                null, true);
    }
}
