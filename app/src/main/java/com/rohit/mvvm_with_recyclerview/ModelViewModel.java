package com.rohit.mvvm_with_recyclerview;
import android.arch.lifecycle.MutableLiveData;

import com.rohit.mvvm_with_recyclerview.Models.Model;
import com.rohit.mvvm_with_recyclerview.Models.User;

import java.util.ArrayList;
import android.arch.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelViewModel extends ViewModel {

    MutableLiveData<ArrayList<User>> userLiveData;
    ArrayList<User> userArrayList;
    ApiInterface apiInterface;

    public ModelViewModel() {
        userLiveData = new MutableLiveData<>();

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<User>> getUserMutableLiveData() {
        return userLiveData;
    }

    public void init(){
        final User user = new User();
//        user.setTitle("Darknight");
//        user.setDescription("Best rating movie");

        userArrayList = new ArrayList<>();
//        userArrayList.add(user);
//        userArrayList.add(user);
//        userArrayList.add(user);
//        userArrayList.add(user);
//        userArrayList.add(user);
//        userArrayList.add(user);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<Model> call= apiInterface.getImage();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                userArrayList= (ArrayList<User>) response.body().getPhotos().getPhoto();
                userArrayList.add(user);
                userLiveData.setValue(userArrayList);

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }
}