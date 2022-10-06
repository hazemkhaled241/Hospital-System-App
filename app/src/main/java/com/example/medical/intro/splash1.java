package com.example.medical.intro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medical.Networks.SharedPref;
import com.example.medical.R;


public class splash1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash1, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPref.init(requireContext());
        Runnable r=new Runnable() {
            @Override
            public void run() {
               NavController navController=Navigation.findNavController(view);
               navController.navigate(R.id.action_splash1_to_splash2);
            }
        };
Thread thread=new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            view.post(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
                 });
thread.start();
    }
}