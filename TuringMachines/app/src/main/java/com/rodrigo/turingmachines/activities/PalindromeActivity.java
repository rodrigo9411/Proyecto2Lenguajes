package com.rodrigo.turingmachines.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rodrigo.turingmachines.R;
import com.rodrigo.turingmachines.databinding.ActivityTuringMachineBinding;

public class PalindromeActivity extends AppCompatActivity{

    private ActivityTuringMachineBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_turing_machine);
    }

}
