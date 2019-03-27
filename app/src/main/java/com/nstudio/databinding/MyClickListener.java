package com.nstudio.databinding;

import android.view.View;

//interface to handle clicks you can also use class instead of interface
public interface MyClickListener {

    //for single click
    void onFabClicked(View view);

    //for long press
    boolean onLongClick(View view);

    //click with parameters
    void onClickWithParam(View view, UserModel user);

}
