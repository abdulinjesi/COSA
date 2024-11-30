package com.onezero.cosa.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.onezero.cosa.databinding.ActivityLoginBinding;
import com.onezero.cosa.ui.service.ServiceActivity;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding; // View Binding instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize View Binding
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set click listener for the Login button
        binding.login.setOnClickListener(v -> navigateToServiceActivity());
    }

    private void navigateToServiceActivity() {
        Intent intent = new Intent(this, ServiceActivity.class);
        startActivity(intent);
        finish(); // Optional: Close the LoginActivity so the user can't go back
    }
}
