package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FacultyProfileFragment extends Fragment {

    private ImageView btnBack;
    private Button btnBookAppointmentAction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculty_profile, container, false);

        btnBack = view.findViewById(R.id.btnBack);
        btnBookAppointmentAction = view.findViewById(R.id.btnBookAppointmentAction);

        btnBack.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        btnBookAppointmentAction.setOnClickListener(v -> {
        });

        return view;
    }
}