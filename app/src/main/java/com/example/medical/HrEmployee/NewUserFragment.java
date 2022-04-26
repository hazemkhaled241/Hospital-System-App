package com.example.medical.HrEmployee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.medical.Networks.RegisterRequest;
import com.example.medical.Networks.RegisterResponse;
import com.example.medical.Networks.RetrofitClint;
import com.example.medical.Networks.ServerError;
import com.example.medical.R;
import com.example.medical.databinding.FragmentNewUserBinding;
import com.google.gson.Gson;


import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewUserFragment extends Fragment {

FragmentNewUserBinding binding;
String dateOfBirth,phoneNumber,firstName,lastName,gender,specialist,status,email,address,password,type;
    RegisterRequest registerRequest=null;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_new_user,container,false);
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_new_user, container, false);
         return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    binding.btnCreateUser.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            firstName=(String)binding.etFirstName.getEditText().getText().toString();
            lastName=(String)binding.etLastName.getEditText().getText().toString();
            gender=(String) binding.etGender.getEditText().getText().toString();
            specialist=(String)binding.etSpecialist.getEditText().getText().toString();
            dateOfBirth=(String)binding.etDateOfBirth.getEditText().getText().toString();
            status=(String)binding.etStatus.getEditText().getText().toString();
            phoneNumber=(String)binding.etPhoneNumber.getEditText().getText().toString();
            email=(String)binding.etEmail.getEditText().getText().toString();
            address=(String)binding.etAddress.getEditText().getText().toString();
            password=(String)binding.etPassword.getEditText().getText().toString();
            if(email!=null&&firstName!=null
                    &&lastName!=null&&password!=null
                    && gender!=null&& dateOfBirth!=null
                    && status!=null&&address!=null
                    && phoneNumber!=null&& specialist!=null
                     ) {
                 registerRequest = new RegisterRequest(email,firstName,lastName,password, gender, dateOfBirth, status, address, phoneNumber, specialist, specialist);
               signup(registerRequest);

                }
            else{
   Toast.makeText(getActivity().getApplicationContext(), "Please enter all needed information", Toast.LENGTH_SHORT).show();
}

        }
    });



    }
    void signup(RegisterRequest registerRequest){

        RegisterRequest registerReq=new RegisterRequest(registerRequest.getEmail(),registerRequest.getFirstName(),registerRequest.getLastName(),registerRequest.getPassword(),registerRequest.getGender(),registerRequest.getBirthday(),registerRequest.getStatus(),registerRequest.getAddress(),registerRequest.getMobile(),registerRequest.getSpecialist(),registerRequest.getType());
        RetrofitClint.getClint().register(registerReq).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if(response.isSuccessful()){
//                assert response.body() != null;
                if(response.body().isSuccess()){
                    Toast.makeText(getActivity().getApplicationContext(),registerReq.getFirstName() , Toast.LENGTH_SHORT).show();

                }
                else{
                     String errorMessage=response.body().getErrorMessage();
                    Toast.makeText(getActivity().getApplicationContext(),errorMessage , Toast.LENGTH_SHORT).show();

                }

            }
            else{

//                    try {
//                        String serverErrorResponse = response.errorBody().string();
//                        Gson gson=new Gson();
//
//                        ServerError serverError=gson.fromJson(serverErrorResponse,ServerError.class);
//                        String error=serverError.getMessage();
//                        Toast.makeText(getActivity().getApplicationContext(),error , Toast.LENGTH_SHORT).show();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                     Toast.makeText(getActivity().getApplicationContext(),response.message() , Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.d("NewUserFragment",t.getLocalizedMessage());
            }
        });


    }
}