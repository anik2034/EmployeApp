package com.example.getemployee;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Visibility;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class LoginPage extends AppCompatActivity {
    TextView signUp;
    TextView forgotPassword;
    EditText email;
    EditText password;
    CardView card;
    ImageView e1;
    ImageView e2;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        signUp = findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Not Implemented Yet", Toast.LENGTH_SHORT).show();
            }
        });
        forgotPassword = findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Not Implemented Yet", Toast.LENGTH_SHORT).show();

            }
        });
        email = findViewById(R.id.address);
        password = findViewById(R.id.password);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        checkEmailUpdates(email, e1);
        checkPassUpdates(password, e2);

        View rootView = findViewById(R.id.root);



//        card= findViewById(R.id.cardView);
//
//        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                ConstraintLayout.LayoutParams newLayoutParams = (ConstraintLayout.LayoutParams)
//                        card.getLayoutParams();
//
//
//
//
//                int heightDiff = rootView.getRootView().getHeight() - rootView.getHeight();
//
//                if (heightDiff > 100) {
////                    newLayoutParams.topMargin = -200;
////                    card.setLayoutParams(newLayoutParams);
//                    Toast.makeText(getApplicationContext(),"Open",Toast.LENGTH_SHORT).show();
//                    } else {
////                    newLayoutParams.topMargin = 400;
////                    card.setLayoutParams(newLayoutParams);
//                    Toast.makeText(getApplicationContext(),"Closed",Toast.LENGTH_SHORT).show();
//
//                    }
//
//
//                }
//
//
//        });
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer tag1 = (Integer) e1.getTag();
                Integer tag2 = (Integer) e2.getTag();


                if((e1.getVisibility()==View.VISIBLE && e2.getVisibility()==View.VISIBLE &&
                        tag1 == R.drawable.check && tag2 == R.drawable.check)){

                    Intent intent1 = new Intent(getApplicationContext(), ListPage.class);
                    startActivity(intent1);
                }
                if(!(e1.getVisibility()==View.VISIBLE && tag1 == R.drawable.check)){
                    setError(e1);
                }
                if(!(e2.getVisibility()==View.VISIBLE && tag2 == R.drawable.check )){
                    setError(e2);
                }






            }
        });


    }

    public void emailValidator(EditText etMail, ImageView mark) {

        String emailToText = etMail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (emailToText.length() > 0  && (emailToText.matches(emailPattern))) {

           setCheck(mark);

        }
        else {
            setError(mark);
        }

    }

    public void passwordValidator(EditText password, ImageView mark) {
        String pass = password.getText().toString();
        if (pass.length() >= 8 && pass.length() <= 15) {

            setCheck(mark);
        } else {

            setError(mark);
        }

    }

    private void checkEmailUpdates(EditText e, ImageView mark) {
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailValidator(e, mark);
            }

            @Override
            public void afterTextChanged(Editable s) {
                emailValidator(e, mark);
            }
        });

    }

    private void checkPassUpdates(EditText e, ImageView mark) {
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordValidator(e, mark);
            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordValidator(e, mark);
            }
        });
    }
    private void setError(ImageView e){
        e.setImageResource(R.drawable.error);
        e.setTag(R.drawable.error);
        e.setVisibility(View.VISIBLE);
    }
    private void setCheck(ImageView e){
        e.setImageResource(R.drawable.check);
        e.setTag(R.drawable.check);
        e.setVisibility(View.VISIBLE);
    }



}

