package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class studentprofile extends Fragment {

    public studentprofile() {
    }

    public static studentprofile newInstance() {
        return new studentprofile();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_studentprofile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
                        .replace(android.R.id.content, new StudentDashboardFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

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

        View btnLogout = view.findViewById(R.id.menuLogout);
        if (btnLogout != null) {
            btnLogout.setOnClickListener(v -> {
                Toast.makeText(requireContext(), "Logging out...", Toast.LENGTH_SHORT).show();
                if (getActivity() != null) {
                    getActivity().finish();
                }
            });
        }
    }
}