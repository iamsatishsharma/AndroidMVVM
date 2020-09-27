package com.example.androidmvvm.views.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmvvm.models.CardItemViewModel;
import com.example.androidmvvm.models.CardModel;

import java.util.List;
/**
 * Created by Satish on 09/06/2020.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.GenericViewHolder> {

    private int layoutId;
    private List<CardModel> cards;
    private CardItemViewModel viewModel;

    public RecycleAdapter(@LayoutRes int layoutId, CardItemViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private CardModel getObjForPosition(int position) {
        return cards.get(position);
    }


    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemCount() {
        return cards == null ? 0 : cards.size();
    }

    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        CardModel obj = getObjForPosition(position);
        viewModel.setModel(obj);
        holder.bind(viewModel);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setCards(List<CardModel> cards) {
        this.cards = cards;
    }


    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(CardItemViewModel viewModel) {
            binding.setVariable(com.example.androidmvvm.BR.viewModel, viewModel);
            binding.executePendingBindings();
        }

    }
}
