package com.nstudio.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class UserModel extends BaseObservable {

    private String name;
    private String email;
    private String profileImage;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // to notify when data changes
        notifyPropertyChanged(BR.name);
        this.name = name;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }


    public String getProfileImage() {
        return profileImage;
    }

    void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    //profileImage variable is bound to android:profileImage attribute. The image will be loaded using Glide or Picasso image library.
    @BindingAdapter({"android:profileImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);

        // If you consider Picasso, follow the below
        // Picasso.with(view.getContext()).load(imageUrl).placeholder(R.drawable.placeholder).into(view);
    }
}


