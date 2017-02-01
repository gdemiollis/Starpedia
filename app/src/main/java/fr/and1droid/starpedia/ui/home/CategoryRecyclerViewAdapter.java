package fr.and1droid.starpedia.ui.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.swapi.model.Category;

import java.util.ArrayList;
import java.util.List;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.ui.list.ListActivity;
import fr.and1droid.starpedia.util.CategoryUtil;

import static com.swapi.model.Category.Film;
import static com.swapi.model.Category.People;
import static com.swapi.model.Category.Planet;
import static com.swapi.model.Category.Starship;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder> {

    //https://twitter.com/eevee/status/820579150939328512
    //    a novice programmer would hardcode it
    //    an experienced programmer would make a general engine feature
    //    a veteran programmer would hardcode it
    private final List<Category> mValues = new ArrayList<>();

    public CategoryRecyclerViewAdapter() {
        mValues.add(Planet);
        mValues.add(People);
        mValues.add(Film);
        mValues.add(Starship);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.category = mValues.get(position);
        holder.textView.setText(CategoryUtil.getTextByCaterory(holder.category));
        holder.imageView.setImageResource(CategoryUtil.getImageByCategory(holder.category));

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
        final TextView textView;
        final ImageView imageView;
        Category category;

        ViewHolder(View view) {
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