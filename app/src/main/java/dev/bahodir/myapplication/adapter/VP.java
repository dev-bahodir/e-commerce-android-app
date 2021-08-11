package dev.bahodir.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.bahodir.myapplication.databinding.VpLayoutBinding;

public class VP extends RecyclerView.Adapter<VP.VH> {
    private List<Integer> list;

    public VP(List<Integer> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(VpLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Integer a = list.get(position);
        holder.binding.image.setImageResource(a);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        private VpLayoutBinding binding;
        public VH(@NonNull VpLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
