package com.deaponnen.common.dto;

import com.deaponnen.common.entity.UnitEntity;

import java.util.List;

public class UnitDto {
    private List<Integer> items;
    private List<String> itemNames;
    private String character_id;
    private String chosen;
    private String name;
    private int rarity;
    private int tier;

    public UnitDto(){
    }

    public UnitDto(UnitEntity entity) {
        this.items = entity.getItems();
        this.itemNames = entity.getItemNames();
        this.character_id = entity.getCharacter_id();
        this.chosen = entity.getChosen();
        this.name = entity.getName();
        this.rarity = entity.getRarity();
        this.tier = entity.getTier();
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public String getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(String character_id) {
        this.character_id = character_id;
    }

    public String getChosen() {
        return chosen;
    }

    public void setChosen(String chosen) {
        this.chosen = chosen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}
