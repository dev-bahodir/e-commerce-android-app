package dev.bahodir.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.bahodir.myapplication.databinding.Rv2LayoutBinding;
import dev.bahodir.myapplication.user.Rv2User;

public class RV2 extends RecyclerView.Adapter<RV2.VH> {

    private List<Rv2User> list;

    public RV2(List<Rv2User> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(Rv2LayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Rv2User rv2User = list.get(position);
        holder.binding.img.setImageResource(rv2User.getImg());
        holder.binding.tv1.setText(rv2User.getTv1());
        holder.binding.tv2.setText(rv2User.getTv2());
        holder.binding.tv3.setText(rv2User.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        private Rv2LayoutBinding binding;
        public VH(@NonNull Rv2LayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
