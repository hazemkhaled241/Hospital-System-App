package com.example.medical.intro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.medical.Networks.LoginRequest;
import com.example.medical.Networks.LoginResponse;
import com.example.medical.Networks.RetrofitClint;
import com.example.medical.Networks.SharedPref;
import com.example.medical.R;
import com.example.medical.databinding.FragmentLoginBinding;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {

FragmentLoginBinding binding;
String email,password,deviceToken;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
    return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=binding.etEmail.getEditText().getText().toString();
                password=binding.etPassword.getEditText().getText().toString();
                if(email!=null&&password!=null){
                    LoginRequest loginRequest=new LoginRequest(email,password,"ssss");
                    login(loginRequest);

                }
                else{
                    Toast.makeText(requireContext(), "Please Enter All Needed Information", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void login(LoginRequest loginRequest) {

        RetrofitClint.getClint().login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    if(response.body().isSuccess()){
                      String userName=response.body().getConfirmationData().getFirstName()+" "+response.body().getConfirmationData().getLastName();

                        SharedPref.writeString("UserName",userName);
                        NavController navController = Navigation.findNavController(requireView());
                        if(response.body().getConfirmationData().getSpecialist().toLowerCase(Locale.ROOT).equals("doctor"))
                            navController.navigate(R.id.action_loginFragment_to_specialistDoctorCaseFragment);
                        else if (response.body().getConfirmationData().getSpecialist().toLowerCase(Locale.ROOT).equals("receptionist"))
                            navController.navigate(R.id.action_loginFragment_to_receptionistFragment);
                        else if (response.body().getConfirmationData().getSpecialist().toLowerCase(Locale.ROOT).equals("nurse"))
                            navController.navigate(R.id.action_loginFragment_to_nurseFragment);
                        else if (response.body().getConfirmationData().getSpecialist().toLowerCase(Locale.ROOT).equals("manager"))
                            navController.navigate(R.id.action_loginFragment_to_specialistManagerFragment);
                        else if (response.body().getConfirmationData().getSpecialist().toLowerCase(Locale.ROOT).equals("hr"))
                            navController.navigate(R.id.action_loginFragment_to_specialistFragment);
                        else if (response.body().getConfirmationData().getSpecialist().toLowerCase(Locale.ROOT).equals("analysis"))
                            navController.navigate(R.id.action_loginFragment_to_specialistAEFragment);
                    }
                    else{
                        String errorStatus=response.body().getErrorMessage();
                        Toast.makeText(requireContext(), errorStatus, Toast.LENGTH_SHORT).show();
                    }

                }
                else{

                    String error=response.message();
                    Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
               String failureError=t.getLocalizedMessage();
                Toast.makeText(requireContext(),failureError , Toast.LENGTH_SHORT).show();
            }
        });
    }
}