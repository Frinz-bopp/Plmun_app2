package com.example.plmunapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView btnTabStudent;
    private TextView btnTabFaculty;
    private TextView tvLoginTitle;
    private EditText etId;
    private Button btnLogin;
    private Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_welcome);


        btnTabStudent = findViewById(R.id.btnTabStudent);
        btnTabFaculty = findViewById(R.id.btnTabFaculty);
        tvLoginTitle = findViewById(R.id.tvLoginTitle);
        etId = findViewById(R.id.etId);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);


        setTabActive(true);


        btnTabStudent.setOnClickListener(v -> {
            if (!btnTabStudent.isSelected()) {
                animateTabSwitch(true);
            }
        });

        btnTabFaculty.setOnClickListener(v -> {
            if (!btnTabFaculty.isSelected()) {
                animateTabSwitch(false);
            }
        });


        btnLogin.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()

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


        btnCreateAccount.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()

                    .setCustomAnimations(
                            android.R.anim.fade_in,
                            android.R.anim.fade_out,
                            android.R.anim.fade_in,
                            android.R.anim.fade_out
                    )
                    .replace(android.R.id.content, new RegisterFragment())
                    .addToBackStack(null)
                    .commit();
        });
    }

    private void animateTabSwitch(boolean isStudent) {
        setTabActive(isStudent);

        tvLoginTitle.setTranslationY(20f);
        tvLoginTitle.setAlpha(0f);
        tvLoginTitle.animate().translationY(0f).alpha(1f).setDuration(250).start();

        etId.setTranslationY(20f);
        etId.setAlpha(0f);
        etId.animate().translationY(0f).alpha(1f).setDuration(250).start();
    }

    private void setTabActive(boolean isStudent) {
        btnTabStudent.setSelected(isStudent);
        btnTabFaculty.setSelected(!isStudent);

        if (isStudent) {
            tvLoginTitle.setText("Student Login");
            etId.setHint("Student ID");
        } else {
            tvLoginTitle.setText("Faculty Login");
            etId.setHint("Faculty ID");
        }
    }
}