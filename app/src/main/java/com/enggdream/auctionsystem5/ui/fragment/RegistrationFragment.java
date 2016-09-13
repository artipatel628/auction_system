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
import com.enggdream.auctionsystem5.model.User;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PareshDudhat on 12-09-2016.
 */
public class RegistrationFragment extends Fragment {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_full_name)
    EditText etFullName;
    @BindView(R.id.et_password)
    EditText etPassword;
    DatabaseHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,
                container, false);
        ButterKnife.bind(this,view);
        dbHelper = DatabaseHelper.getInstance(getContext());
        return view;
    }

    @OnClick(R.id.btn_register)
    void register()  {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String fullName = etFullName.getText().toString();
        User oldUser = null;
        try {
            oldUser = dbHelper.getUserByUsername(username);
            if (oldUser != null) {
                Toast.makeText(getContext(), "Username " + username + " is reserved by" +
                        " " + oldUser.getFullName(), Toast.LENGTH_SHORT).show();
            } else {
                User user = new User();
                user.setUsername(username);
                user.setFullName(fullName);
                user.setPassword(password);
                dbHelper.getUserDao().create(user);
                Toast.makeText(getContext(), "Welcome " + user.getUsername()
                        + " your id is " + user.getUserId(), Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(getContext(),"Error "+e.getLocalizedMessage()
                    , Toast.LENGTH_SHORT).show();

        }

    }
}
