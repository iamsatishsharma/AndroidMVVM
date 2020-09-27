package com.example.androidmvvm.viewmodels;

import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmvvm.R;
import com.example.androidmvvm.models.CardItemViewModel;
import com.example.androidmvvm.models.CardModel;
import com.example.androidmvvm.models.UserListModel;
import com.example.androidmvvm.networks.Retrofit.ApiCallClient;
import com.example.androidmvvm.views.activities.UserListActivity;
import com.example.androidmvvm.views.adapter.RecycleAdapter;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Satish on 09/06/2020.
 */
public class UserListViewModel extends BaseViewModel<UserListModel> {
    private  String TAG = "2";
    private RecycleAdapter recycleAdapter;

    @Override
    UserListModel getModel() {
        return model;
    }
    @Override
    public boolean validate() {
        return false;
    }

    public UserListViewModel(UserListActivity activity) {
        super(activity);
        UserListModel model = new UserListModel();
        setModel(model);

        getUserListData();
        recycleAdapter = new RecycleAdapter(R.layout.card_item, new CardItemViewModel(getActivity()));
    }

    public RecycleAdapter getRecycleAdapter() {
        return recycleAdapter;
    }

    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecycleAdapter adapter) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    public void setCardsInAdapter(List<CardModel> cards) {
        this.recycleAdapter.setCards(cards);
        this.recycleAdapter.notifyDataSetChanged();
    }

    @Bindable
    public String getSenderNameTitle() {
        return "Android + MVVM + Network";
    }

    public void getUserListData() {

        (ApiCallClient.getClient().getOrgsCall()).enqueue(new Callback<List<CardModel>>() {
            @Override
            public void onResponse(Call<List<CardModel>> call, Response<List<CardModel>> response) {

                if (response != null) {
                    Log.d("responseGET", response.toString());
                    List<CardModel> list = response.body();
                    getModel().setCardModellist(list);
                    setCardsInAdapter(getModel().getCardModellist());
                }

            }

            @Override
            public void onFailure(Call<List<CardModel> > call, Throwable t) {
                // if error occurs in network transaction then we can get the error in this method.
                Log.d("responseGET_error",  t.toString());
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


}