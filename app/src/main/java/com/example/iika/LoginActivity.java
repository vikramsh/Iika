package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ImageView image;
    TextInputEditText textinput, textinputpassword;
    Button Login, loginviagoogle, loginviafacebook;
    TextView newuser, signup, forgotpassword;

    private User user;
    private SessionHandler session;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        image = (ImageView) findViewById(R.id.image);
        textinput = (TextInputEditText) findViewById(R.id.textinput);
        textinputpassword = (TextInputEditText) findViewById(R.id.textinputpassword);
        Login = (Button) findViewById(R.id.Login);
        loginviagoogle = (Button) findViewById(R.id.loginviagoogle);
        loginviafacebook = (Button) findViewById(R.id.loginviafacebook);
        newuser = (TextView) findViewById(R.id.newuser);
        signup = (TextView) findViewById(R.id.signup);
        forgotpassword = (TextView) findViewById(R.id.forgotpassword);

        session = new SessionHandler(getApplicationContext());
        user = session.getUserDetails();
        context = this;

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textinput.getText().toString();
                String pass = textinputpassword.getText().toString();
                LoginRequest loginRequest = new LoginRequest( username, pass);

                if (!DataValidationFilter.InputTextValidationFilter.isValidEmail(username)) {
                    textinput.setError("Enter valid email");
                    textinput.requestFocus();
                    return;
                }else if (!DataValidationFilter.InputTextValidationFilter.validatePassword(pass)) {
                    String errMsg = DataValidationFilter.InputTextValidationFilter.getPasswordValidationError(pass);
                    textinputpassword.setError(errMsg);
                    textinputpassword.requestFocus();
                    return;
                }

                sendRequest(loginRequest);
            }
        });

        signup.setOnClickListener(v->openRegistrationActivity());
    }

    private void openRegistrationActivity() {
        Intent i = new Intent(LoginActivity.this,RegistrationActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
        startActivity(i);
    }

    private void sendRequest(LoginRequest loginRequest) {


        MyServiceCall myServiceCall = RetrofitClient.getServiceCall();
        Call<LoginResponse> call =  myServiceCall.getLogin(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getResult().equals("success")){

                        session.loginUser(
                                response.body().getUserID(),
                                response.body().getFirstname() + " "+ response.body().getLastname(),
                                response.body().getMobile(),
                                response.body().getEmail(),
                                "");

                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
                        startActivity(intent);

                    }else if(response.body().getMessage().equalsIgnoreCase("error")){
                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    }