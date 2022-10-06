package com.example.medical.receptionist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medical.Networks.SharedPref;
import com.example.medical.R;
import com.example.medical.databinding.FragmentReceptionistBinding;

public class ReceptionistFragment extends Fragment {

FragmentReceptionistBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_receptionist,container,false);
        // inflater.inflate(R.layout.fragment_receptionist, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String userName= SharedPref.readString("UserName","");
        binding.tvUserName.setText(userName);
        binding.ivCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(requireView());
                navController.navigate(R.id.action_receptionistFragment_to_receptionistCallsFragment);
            }
        });


    }
}