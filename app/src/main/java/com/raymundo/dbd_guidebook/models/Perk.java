package com.raymundo.dbd_guidebook.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class Perk implements Parcelable {

    public enum PerkType {
        SURVIVOR,
        KILLER
    }

    private final UUID id;
    private PerkType perkType;
    private String name;
    private String type;
    private String teach;
    private String ability;
    private String impact;
    private String description;
    private String peculiarities;
    private String notes;
    private String levelOne;
    private String levelTwo;
    private String levelThree;
    private int imageResId;
    public static final Creator<Perk> CREATOR = new Creator<Perk>() {
        @Override
        public Perk createFromParcel(Parcel in) {
            return new Perk(in);
        }

        @Override
        public Perk[] newArray(int size) {
            return new Perk[size];
        }
    };

    public Perk(PerkType perkType,
                String name,
                String type,
                String teach,
                String ability,
                String impact,
                String description,
                String peculiarities,
                String notes,
                String levelOne,
                String levelTwo,
                String levelThree,
                int imageResId) {
        this.id = UUID.randomUUID();
        this.perkType = perkType;
        this.name = name;
        this.type = type;
        this.teach = teach;
        this.ability = ability;
        this.impact = impact;
        this.description = description;
        this.peculiarities = peculiarities;
        this.notes = notes;
        this.levelOne = levelOne;
        this.levelTwo = levelTwo;
        this.levelThree = levelThree;
        this.imageResId = imageResId;
    }

    protected Perk(Parcel in) {
        id = (UUID) in.readSerializable();
        name = in.readString();
        type = in.readString();
        teach = in.readString();
        ability = in.readString();
        impact = in.readString();
        description = in.readString();
        peculiarities = in.readString();
        notes = in.readString();
        levelOne = in.readString();
        levelTwo = in.readString();
        levelThree = in.readString();
        imageResId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(teach);
        dest.writeString(ability);
        dest.writeString(impact);
        dest.writeString(description);
        dest.writeString(peculiarities);
        dest.writeString(notes);
        dest.writeString(levelOne);
        dest.writeString(levelTwo);
        dest.writeString(levelThree);
        dest.writeInt(imageResId);
    }

    public PerkType getPerkType() {
        return perkType;
    }

    public void setPerkType(PerkType perkType) {
        this.perkType = perkType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeach() {
        return teach;
    }

    public void setTeach(String teach) {
        this.teach = teach;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeculiarities() {
        return peculiarities;
    }

    public void setPeculiarities(String peculiarities) {
        this.peculiarities = peculiarities;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(String levelOne) {
        this.levelOne = levelOne;
    }

    public String getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(String levelTwo) {
        this.levelTwo = levelTwo;
    }

    public String getLevelThree() {
        return levelThree;
    }

    public void setLevelThree(String levelThree) {
        this.levelThree = levelThree;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public UUID getId() {
        return id;
    }
}
