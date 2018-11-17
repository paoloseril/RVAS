package me.mobapde.edu.ph.rvas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SysAdapter extends RecyclerView.Adapter<SysHolder> {

    private MainActivity activity;
    public SysAdapter(MainActivity activity) {
        this.activity = activity;
    }
    @NonNull
    @Override
    public SysHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_item, parent, false);
        return new SysHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SysHolder holder, int position) {
        holder.setText("");
        holder.setTime("");
        holder.setActivity(activity);
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
