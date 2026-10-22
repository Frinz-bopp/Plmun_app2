package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {

    private EditText etFullName, etRegId, etRegPassword;
    private Button btnSubmitRegister;
    private TextView tvBackToLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        etFullName = view.findViewById(R.id.etFullName);
        etRegId = view.findViewById(R.id.etRegId);
        etRegPassword = view.findViewById(R.id.etRegPassword);
        btnSubmitRegister = view.findViewById(R.id.btnSubmitRegister);
        tvBackToLogin = view.findViewById(R.id.tvBackToLogin);

        btnSubmitRegister.setOnClickListener(v -> handleRegistration());


        tvBackToLogin.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }

    private void handleRegistration() {
        String fullName = etFullName.getText().toString().trim();
        String id = etRegId.getText().toString().trim();
        String password = etRegPassword.getText().toString().trim();

        if (fullName.isEmpty() || id.isEmpty() || password.isEmpty()) {
            Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Account registered successfully!", Toast.LENGTH_SHORT).show();
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        }
    }
}