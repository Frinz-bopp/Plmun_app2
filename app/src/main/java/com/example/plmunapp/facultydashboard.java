package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class facultydashboard extends Fragment {

    private CardView cardAppointmentManager, cardSchedule;
    private View navAppointments, navSchedule;

    public facultydashboard() {
    }

    public static facultydashboard newInstance() {
        return new facultydashboard();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facultydashboard, container, false);

        cardAppointmentManager = view.findViewById(R.id.cardAppointmentManager);
        cardSchedule = view.findViewById(R.id.cardSchedule);
        navAppointments = view.findViewById(R.id.navAppointments);
        navSchedule = view.findViewById(R.id.navSchedule);

        View.OnClickListener openAppointmentManager = v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            android.R.anim.fade_in,
                            android.R.anim.fade_out,
                            android.R.anim.fade_in,
                            android.R.anim.fade_out
                    )
                    .replace(android.R.id.content, new appointmentmanager())
                    .addToBackStack(null)
                    .commit();
        };

        View.OnClickListener openSchedule = v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            android.R.anim.fade_in,
                            android.R.anim.fade_out,
                            android.R.anim.fade_in,
                            android.R.anim.fade_out
                    )
                    .replace(android.R.id.content, new facultyschedule())
                    .addToBackStack(null)
                    .commit();
        };

        if (cardAppointmentManager != null) {
            cardAppointmentManager.setOnClickListener(openAppointmentManager);
        }

        if (navAppointments != null) {
            navAppointments.setOnClickListener(openAppointmentManager);
        }

        if (cardSchedule != null) {
            cardSchedule.setOnClickListener(openSchedule);
        }

        if (navSchedule != null) {
            navSchedule.setOnClickListener(openSchedule);
        }

        return view;
    }
}