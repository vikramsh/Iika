package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    ImageView image;
    TextInputEditText firstname, lastname, email, phone, password, confirmpassword, address;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        image = (ImageView) findViewById(R.id.image);
        firstname = (TextInputEditText) findViewById(R.id.firstname);
        lastname = (TextInputEditText) findViewById(R.id.lastname);
        email = (TextInputEditText) findViewById(R.id.email);
        phone = (TextInputEditText) findViewById(R.id.phone);
        password = (TextInputEditText) findViewById(R.id.password);
        confirmpassword = (TextInputEditText) findViewById(R.id.confirmpassword);
        address = (TextInputEditText) findViewById(R.id.address);
        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = firstname.getText().toString();
                String lname = lastname.getText().toString();
                String emailid = email.getText().toString();
                String phn = phone.getText().toString();
                String pwd = password.getText().toString();
                String confrmpwd = confirmpassword.getText().toString();
                String addrs = address.getText().toString();

                if (fname.isEmpty()) {
                    firstname.setError("Enter First Name");
                    firstname.requestFocus();
                    return;
                } else if (lname.isEmpty()) {
                    lastname.setError("Enter Last Name");
                    lastname.requestFocus();
                    return;
                } else if (!DataValidationFilter.InputTextValidationFilter.isValidEmail(emailid)) {
                    email.setError("Enter valid email");
                    email.requestFocus();
                    return;
                } else if (!DataValidationFilter.InputTextValidationFilter.isValidMobile(phn)) {
                    phone.setError("Enter valid phone number");
                    phone.requestFocus();
                    return;
                } else if (!DataValidationFilter.InputTextValidationFilter.validatePassword(pwd)) {
                    password.setError("Enter valid password number");
                    password.requestFocus();
                    return;
                } else if (!DataValidationFilter.InputTextValidationFilter.validatePassword(confrmpwd)) {
                    confirmpassword.setError("Enter valid confirm password");
                    confirmpassword.requestFocus();
                    return;
                } /*else if (!DataValidationFilter.InputTextValidationFilter.isValidEmail(addrs)) {
                    address.setError("Enter valid address");
                    address.requestFocus();
                    return;
                }*/
            }
        });
    }
}
