package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class bookappntment extends Fragment {

    private ImageView btnBack;
    private LinearLayout[] dates;
    private TextView[] times;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookappntment, container, false);

        btnBack = view.findViewById(R.id.btnBack);

        // Fixed back button to return to Student Dashboard
        btnBack.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        LinearLayout date1 = view.findViewById(R.id.date1);
        LinearLayout date2 = view.findViewById(R.id.date2);
        LinearLayout date3 = view.findViewById(R.id.date3);
        LinearLayout date4 = view.findViewById(R.id.date4);
        LinearLayout date5 = view.findViewById(R.id.date5);

        dates = new LinearLayout[]{date1, date2, date3, date4, date5};

        for (LinearLayout dateCard : dates) {
            if (dateCard != null) {
                dateCard.setOnClickListener(v -> selectDate((LinearLayout) v));
            }
        }

        TextView time1 = view.findViewById(R.id.time1);
        TextView time2 = view.findViewById(R.id.time2);
        TextView time3 = view.findViewById(R.id.time3);
        TextView time4 = view.findViewById(R.id.time4);
        TextView time5 = view.findViewById(R.id.time5);
        TextView time6 = view.findViewById(R.id.time6);
        TextView time7 = view.findViewById(R.id.time7);
        TextView time8 = view.findViewById(R.id.time8);

        times = new TextView[]{time1, time2, time3, time4, time5, time6, time7, time8};

        for (TextView timeSlot : times) {
            if (timeSlot != null) {
                timeSlot.setOnClickListener(v -> selectTime((TextView) v));
            }
        }

        return view;
    }

    private void selectDate(LinearLayout selectedDateCard) {
        for (LinearLayout dateCard : dates) {
            if (dateCard != null) {
                dateCard.setBackgroundResource(R.drawable.bg_card_unselected);
                for (int i = 0; i < dateCard.getChildCount(); i++) {
                    View child = dateCard.getChildAt(i);
                    if (child instanceof TextView) {
                        ((TextView) child).setTextColor(0xFF333333);
                    }
                }
            }
        }
        selectedDateCard.setBackgroundResource(R.drawable.bg_card_selected);
        for (int i = 0; i < selectedDateCard.getChildCount(); i++) {
            View child = selectedDateCard.getChildAt(i);
            if (child instanceof TextView) {
                ((TextView) child).setTextColor(0xFFFFFFFF);
            }
        }
    }

    private void selectTime(TextView selectedTimeSlot) {
        for (TextView timeSlot : times) {
            if (timeSlot != null) {
                timeSlot.setBackgroundResource(R.drawable.bg_card_unselected);
                timeSlot.setTextColor(0xFF333333);
            }
        }
        selectedTimeSlot.setBackgroundResource(R.drawable.bg_card_selected);
        selectedTimeSlot.setTextColor(0xFFFFFFFF);
    }
}