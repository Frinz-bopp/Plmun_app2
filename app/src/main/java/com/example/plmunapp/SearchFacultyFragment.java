package com.example.plmunapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFacultyFragment extends Fragment {

    private ImageView btnBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_faculty, container, false);

        btnBack = view.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        View.OnClickListener openProfile = v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            android.R.anim.fade_in,
                            android.R.anim.fade_out,
                            android.R.anim.fade_in,
                            android.R.anim.fade_out
                    )
                    .replace(android.R.id.content, new FacultyProfileFragment())
                    .addToBackStack(null)
                    .commit();
        };


        View faculty1 = view.findViewById(R.id.faculty1);
        View faculty2 = view.findViewById(R.id.faculty2);
        View faculty3 = view.findViewById(R.id.faculty3);
        View faculty4 = view.findViewById(R.id.faculty4);
        View faculty5 = view.findViewById(R.id.faculty5);

        if (faculty1 != null) faculty1.setOnClickListener(openProfile);
        if (faculty2 != null) faculty2.setOnClickListener(openProfile);
        if (faculty3 != null) faculty3.setOnClickListener(openProfile);
        if (faculty4 != null) faculty4.setOnClickListener(openProfile);
        if (faculty5 != null) faculty5.setOnClickListener(openProfile);

        return view;
    }
}