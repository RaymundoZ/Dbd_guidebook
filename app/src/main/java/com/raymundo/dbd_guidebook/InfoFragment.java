package com.raymundo.dbd_guidebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.raymundo.dbd_guidebook.models.Item;

import java.util.List;

public abstract class InfoFragment extends Fragment {

    private RecyclerView recyclerView;

    public abstract View loadView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    public abstract List<Item> loadItems();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = loadView(inflater, container, savedInstanceState);
        init(view);
        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.infoRecycler);
        InfoAdapter adapter = new InfoAdapter(loadItems());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private static class InfoViewHolder extends RecyclerView.ViewHolder {

        private ShapeableImageView icon;
        private MaterialTextView title;

        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            init(itemView);
        }

        private void init(View view) {
            icon = view.findViewById(R.id.icon);
            title = view.findViewById(R.id.title);
        }

        public void bind(Item item) {
            icon.setImageResource(item.getIconResId());
            title.setText(item.getTitle());
        }

    }

    private static class InfoAdapter extends RecyclerView.Adapter<InfoViewHolder> {

        private List<Item> items;

        public InfoAdapter(List<Item> items) {
            this.items = items;
        }

        @NonNull
        @Override
        public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.info_item, parent, false);
            return new InfoViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
            Item item = items.get(position);
            holder.bind(item);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

    }

}
