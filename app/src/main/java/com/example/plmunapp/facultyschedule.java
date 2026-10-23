package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class facultyschedule extends Fragment {

    private CalendarView calendarView;
    private TextView tvAppointmentsTitle;

    public facultyschedule() {
    }

    public static facultyschedule newInstance() {
        return new facultyschedule();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_facultyschedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        calendarView = view.findViewById(R.id.calendarView);
        tvAppointmentsTitle = view.findViewById(R.id.tvAppointmentsTitle);

        if (calendarView != null) {
            calendarView.setDate(System.currentTimeMillis(), false, true);

            calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
                String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                String selectedDate = monthNames[month] + " " + dayOfMonth + ", " + year;
                if (tvAppointmentsTitle != null) {
                    tvAppointmentsTitle.setText("Appointments for " + selectedDate);
                }
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
                        .replace(android.R.id.content, new appointmentmanager())
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