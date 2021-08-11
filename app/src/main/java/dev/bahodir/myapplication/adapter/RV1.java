package dev.bahodir.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.bahodir.myapplication.databinding.Rv1LayoutBinding;
import dev.bahodir.myapplication.user.Rv1User;

public class RV1 extends RecyclerView.Adapter<RV1.VH> {
    private List<Rv1User> list;

    public RV1(List<Rv1User> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(Rv1LayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Rv1User user = list.get(position);
        holder.binding.name.setText(user.getName());
        holder.binding.fab.setImageResource(user.getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        private Rv1LayoutBinding binding;
        public VH(@NonNull Rv1LayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
