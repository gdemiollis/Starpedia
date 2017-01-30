package fr.and1droid.starpedia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.swapi.models.SWEntity;

import java.util.List;

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final List<? extends SWEntity> mValues;
    private boolean mTwoPane;

    public SimpleItemRecyclerViewAdapter(List<? extends SWEntity> items, boolean mTwoPane) {
        this.mValues = items;
        this.mTwoPane = mTwoPane;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.entity = mValues.get(position);
        holder.contentView.setText(holder.entity.getName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTwoPane) {
                    Bundle arguments = PlanetFragment.getBundle(holder.entity);
                    PlanetFragment fragment = new PlanetFragment();
                    fragment.setArguments(arguments);
                    ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.swentity_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = DetailActivity.newIntent(context, holder.entity);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView contentView;
        private final View view;
        public SWEntity entity;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            contentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + contentView.getText() + "'";
        }
    }
}