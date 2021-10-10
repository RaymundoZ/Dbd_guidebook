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
import com.raymundo.dbd_guidebook.models.Perk;

import java.util.ArrayList;
import java.util.List;

public class PerksFragment extends Fragment {

    private RecyclerView survivorRecycler;
    private RecyclerView killerRecycler;

    public static PerksFragment newInstance() {

        Bundle args = new Bundle();

        PerksFragment fragment = new PerksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.perks_layout, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        survivorRecycler = view.findViewById(R.id.survivorPerks);
        killerRecycler = view.findViewById(R.id.killerPerks);
        List<Perk> perks = new ArrayList<>();
        Perk perk = new Perk(
                Perk.PerkType.SURVIVOR,
                "Связь",
                "Уникальный\n" +
                        "Дуайт Фэйрфилд",
                "30 уровень",
                "Чтение Ауры",
                "Раскрытие ауры",
                null,
                null,
                null,
                null,
                null,
                null,
                R.drawable.iconperks_bond);
        Perk perk1 = new Perk(
                Perk.PerkType.SURVIVOR,
                "Связь",
                "Уникальный\n" +
                        "Дуайт Фэйрфилд",
                "30 уровень",
                "Чтение Ауры",
                "Раскрытие ауры",
                null,
                null,
                null,
                null,
                null,
                null,
                R.drawable.iconperks_bond);
        Perk perk2 = new Perk(
                Perk.PerkType.SURVIVOR,
                "Связь",
                "Уникальный\n" +
                        "Дуайт Фэйрфилд",
                "30 уровень",
                "Чтение Ауры",
                "Раскрытие ауры",
                null,
                null,
                null,
                null,
                null,
                null,
                R.drawable.iconperks_bond);
        perks.add(perk);
        perks.add(perk1);
        perks.add(perk2);
        PerkAdapter adapter = new PerkAdapter(perks);
        survivorRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        survivorRecycler.setAdapter(adapter);
    }

    private static class PerkHolder extends RecyclerView.ViewHolder {

        private MaterialTextView perkName;
        private ShapeableImageView perkIcon;
        private MaterialTextView perkType;
        private MaterialTextView perkTeaching;
        private MaterialTextView perkAbility;
        private MaterialTextView perkImpact;

        public PerkHolder(@NonNull View itemView) {
            super(itemView);
            perkName = itemView.findViewById(R.id.perkName);
            perkIcon = itemView.findViewById(R.id.perkIcon);
            perkType = itemView.findViewById(R.id.perkType);
            perkTeaching = itemView.findViewById(R.id.perkTeaching);
            perkAbility = itemView.findViewById(R.id.perkAbility);
            perkImpact = itemView.findViewById(R.id.perkImpact);
        }

        public void bind(Perk perk) {
            perkName.setText(perk.getName());
            perkIcon.setImageResource(perk.getImageResId());
            perkType.setText(perk.getType());
            perkTeaching.setText(perk.getTeach());
            perkAbility.setText(perk.getAbility());
            perkImpact.setText(perk.getImpact());
        }

    }

    private static class PerkAdapter extends RecyclerView.Adapter<PerkHolder> {

        private List<Perk> perks;

        public PerkAdapter(List<Perk> perks) {
            this.perks = perks;
        }

        @NonNull
        @Override
        public PerkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.perk_item_card, parent, false);
            return new PerkHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PerkHolder holder, int position) {
            Perk perk = perks.get(position);
            holder.bind(perk);
        }

        @Override
        public int getItemCount() {
            return perks.size();
        }
    }

}
