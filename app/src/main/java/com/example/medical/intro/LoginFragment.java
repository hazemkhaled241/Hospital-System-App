package com.example.medical.intro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.medical.Networks.LoginRequest;
import com.example.medical.Networks.LoginResponse;
import com.example.medical.Networks.RetrofitClint;
import com.example.medical.R;
import com.example.medical.databinding.FragmentLoginBinding;

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
                        Toast.makeText(requireContext(), "Welcome"+loginRequest.getEmail(), Toast.LENGTH_SHORT).show();

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