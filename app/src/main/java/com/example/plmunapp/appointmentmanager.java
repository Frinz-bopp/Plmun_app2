package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class appointmentmanager extends Fragment {

    private Button btnTabUpcoming, btnTabPast;

    public appointmentmanager() {
    }

    public static appointmentmanager newInstance() {
        return new appointmentmanager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_appointmentmanager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnTabUpcoming = view.findViewById(R.id.btnTabUpcoming);
        btnTabPast = view.findViewById(R.id.btnTabPast);

        if (btnTabUpcoming != null && btnTabPast != null) {
            btnTabUpcoming.setOnClickListener(v -> {
                btnTabUpcoming.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF063A18));
                btnTabUpcoming.setTextColor(0xFFFFFFFF);

                btnTabPast.setBackgroundTintList(android.content.res.ColorStateList.valueOf(android.graphics.Color.TRANSPARENT));
                btnTabPast.setTextColor(0xFF666666);
            });

            btnTabPast.setOnClickListener(v -> {
                btnTabPast.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF063A18));
                btnTabPast.setTextColor(0xFFFFFFFF);

                btnTabUpcoming.setBackgroundTintList(android.content.res.ColorStateList.valueOf(android.graphics.Color.TRANSPARENT));
                btnTabUpcoming.setTextColor(0xFF666666);
            });
        }

        View btnBack = view.findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                if (getActivity() != null) {
                    getActivity().onBackPressed();
                }
            });
        }

        LinearLayout navHome = view.findViewById(R.id.navHome);
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                android.R.anim.fade_in,
                                android.R.anim.fade_out,
                                android.R.anim.fade_in,
                                android.R.anim.fade_out
                        )
                        .replace(android.R.id.content, new facultydashboard())
                        .addToBackStack(null)
                        .commit();
            });
        }

        LinearLayout navSchedule = view.findViewById(R.id.navSchedule);
        if (navSchedule != null) {
            navSchedule.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                android.R.anim.fade_in,
                                android.R.anim.fade_out,
                                android.R.anim.fade_in,
                                android.R.anim.fade_out
                        )
                        .replace(android.R.id.content, new facultyschedule())
                        .addToBackStack(null)
                        .commit();
            });
        }

        LinearLayout navProfile = view.findViewById(R.id.navProfile);
        if (navProfile != null) {
            navProfile.setOnClickListener(v -> {
                Toast.makeText(requireContext(), "Profile clicked", Toast.LENGTH_SHORT).show();
            });
        }
    }
}