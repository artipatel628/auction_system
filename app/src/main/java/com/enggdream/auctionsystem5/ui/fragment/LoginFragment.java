package com.enggdream.auctionsystem5.ui.fragment;

import android.content.Intent;
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
import com.enggdream.auctionsystem5.model.User;
import com.enggdream.auctionsystem5.ui.activity.MainActivity;
import com.enggdream.auctionsystem5.util.PreferenceUtil;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PareshDudhat on 12-09-2016.
 */
public class LoginFragment extends Fragment {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_login)
    void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(getContext());
        try {
            User user = dbHelper.checkLogin(username, password);
            if (user != null) {
                if (PreferenceUtil.setActiveUserID(getContext(), user.getUserId())) {
                    Toast.makeText(getContext(), "Welcome " + user.getFullName(),
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    Toast.makeText(getContext(), "There is some error",
                            Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "wrong username and password",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), e.getLocalizedMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
