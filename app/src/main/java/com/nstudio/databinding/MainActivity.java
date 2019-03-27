package com.nstudio.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.nstudio.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        context = MainActivity.this;

        user = new UserModel();
        user.setName("Imran Khan");
        user.setEmail("iamkhan007@outlook.com");
        user.setProfileImage("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
        binding.setUser(user);


        MyClickListener clickListener = new com.nstudio.databinding.MyClickListener() {
            @Override
            public void onFabClicked(View view) {
                Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(context,"Long Click",Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public void onClickWithParam(View view, UserModel user) {
                Toast.makeText(context, "Button clicked! Name: " + user.getName(), Toast.LENGTH_SHORT).show();
            }


        };

        binding.setHandlers(clickListener);


        MyTextWatcher watcher = new MyTextWatcher();
        binding.setWatcher(watcher);


    }


    // for 2 way binding ie. from object to view and view to object

    public class MyTextWatcher{

        public TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }


}
