package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class StudentDashboardFragment extends Fragment {

    private CardView cardSearchFaculty, cardMyAppointments, cardBookAppointment, cardNotifications;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_dashboard, container, false);

        cardSearchFaculty = view.findViewById(R.id.cardSearchFaculty);
        cardMyAppointments = view.findViewById(R.id.cardMyAppointments);
        cardBookAppointment = view.findViewById(R.id.cardBookAppointment);
        cardNotifications = view.findViewById(R.id.cardNotifications);


        applyPressEffect(cardSearchFaculty);
        applyPressEffect(cardMyAppointments);
        applyPressEffect(cardBookAppointment);
        applyPressEffect(cardNotifications);


        cardSearchFaculty.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            android.R.anim.fade_in,
                            android.R.anim.fade_out,
                            android.R.anim.fade_in,
                            android.R.anim.fade_out
                    )
                    .replace(android.R.id.content, new SearchFacultyFragment())
                    .addToBackStack(null)
                    .commit();
        });


        cardMyAppointments.setOnClickListener(v -> {

        });


        cardBookAppointment.setOnClickListener(v -> {

        });


        cardNotifications.setOnClickListener(v -> {

        });

        return view;
    }

    private void applyPressEffect(CardView card) {
        card.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    v.animate().scaleX(0.96f).scaleY(0.96f).setDuration(100).start();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                    break;
            }
            return false;
        });
    }
}