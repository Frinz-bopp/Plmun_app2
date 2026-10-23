package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentDashboardFragment extends Fragment {

    public StudentDashboardFragment() {
    }

    public static StudentDashboardFragment newInstance() {
        return new StudentDashboardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout navAppointments = view.findViewById(R.id.navAppointments);
        if (navAppointments != null) {
            navAppointments.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                android.R.anim.fade_in,
                                android.R.anim.fade_out,
                                android.R.anim.fade_in,
                                android.R.anim.fade_out
                        )
                        .replace(android.R.id.content, new studentappointments())
                        .addToBackStack(null)
                        .commit();
            });
        }

        LinearLayout navProfile = view.findViewById(R.id.navProfile);
        if (navProfile != null) {
            navProfile.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                android.R.anim.fade_in,
                                android.R.anim.fade_out,
                                android.R.anim.fade_in,
                                android.R.anim.fade_out
                        )
                        .replace(android.R.id.content, new studentprofile())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}