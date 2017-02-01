package fr.and1droid.starpedia;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder> {

    //https://twitter.com/eevee/status/820579150939328512
    //    a novice programmer would hardcode it
    //    an experienced programmer would make a general engine feature
    //    a veteran programmer would hardcode it
    private final List<Pair<Integer, Integer>> mValues = new ArrayList<>();

    public CategoryRecyclerViewAdapter() {
        mValues.add(new Pair<>(R.string.planets, R.drawable.ic_planet));
        mValues.add(new Pair<>(R.string.people, R.drawable.ic_population));
        mValues.add(new Pair<>(R.string.films, R.drawable.ic_movie));
        mValues.add(new Pair<>(R.string.spaceships, R.drawable.ic_spaceship));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Pair<Integer, Integer> pair = mValues.get(position);
        holder.category = pair.first;
        holder.textView.setText(pair.first);
        holder.imageView.setImageResource(pair.second);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = ListActivity.newIntent(context, holder.category);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;
        public final ImageView imageView;
        public
        @StringRes
        int category;

        public ViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textView.getText() + "'";
        }
    }
}