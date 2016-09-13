package com.enggdream.auctionsystem5.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.enggdream.auctionsystem5.R;
import com.enggdream.auctionsystem5.db.DatabaseHelper;
import com.enggdream.auctionsystem5.model.AuctionItem;
import com.enggdream.auctionsystem5.model.User;
import com.enggdream.auctionsystem5.util.PreferenceUtil;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PareshDudhat on 13-09-2016.
 */
public class CreateAuctionFragment extends Fragment {
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_description)
    EditText etDesc;
    @BindView(R.id.et_base_price)
    EditText etBasePrice;
    @BindView(R.id.et_end_time)
    EditText etEndTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_auction, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.fab)
    void saveAuction() {
        String title = etTitle.getText().toString();
        String desc = etDesc.getText().toString();
        int basePrice = Integer.parseInt(etBasePrice.getText().toString());
        User user = DatabaseHelper.getInstance(getContext()).getUserDao().queryForId(
                PreferenceUtil.getActiveUserID(getContext())
        );
        AuctionItem item = new AuctionItem();
        item.setTitle(title);
        item.setDescription(desc);
        item.setBasePrice(basePrice);
        item.setCreateDate(new Date());
        item.setOwner(user);
        DatabaseHelper.getInstance(getContext()).getItemDao().create(item);
        Toast.makeText(getContext(), "Auction created with id:" + item.getId(),
                Toast.LENGTH_SHORT).show();
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
