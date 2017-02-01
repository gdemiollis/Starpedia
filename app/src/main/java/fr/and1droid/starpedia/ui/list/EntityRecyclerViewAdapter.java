package fr.and1droid.starpedia.ui.list;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.swapi.model.SWEntity;

import java.util.List;

import javax.inject.Inject;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.injection.GraphProvider;
import fr.and1droid.starpedia.ui.detail.BaseFragment;
import fr.and1droid.starpedia.ui.detail.DetailActivity;
import fr.and1droid.starpedia.ui.detail.FragmentFactory;
import fr.and1droid.starpedia.util.CategoryUtil;

public class EntityRecyclerViewAdapter extends RecyclerView.Adapter<EntityRecyclerViewAdapter.ViewHolder> {

    private final List<SWEntity> mValues;
    private boolean mTwoPane;
    @Inject
    FragmentFactory fragmentFactory;

    public EntityRecyclerViewAdapter(List<SWEntity> items, boolean mTwoPane) {
        GraphProvider.injectIn(this);
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
        holder.icon.setImageResource(CategoryUtil.getImageByCategory(holder.entity.getCategory()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTwoPane) {
                    Fragment fragment = fragmentFactory.getFragment(holder.entity);
                    fragment.setArguments(BaseFragment.getBundle(holder.entity));
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
        final TextView contentView;
        final ImageView icon;
        SWEntity entity;

        ViewHolder(View view) {
            super(view);
            contentView = (TextView) view.findViewById(R.id.content);
            icon = (ImageView) view.findViewById(R.id.icon);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + contentView.getText() + "'";
        }
    }
}