package com.deaponnen.common.entity;

import com.deaponnen.common.dto.UnitDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "unit")
public class UnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unit_id;
    @ElementCollection
    private List<Integer> items;
    @ElementCollection
    private List<String> itemNames;
    private String character_id;
    private String chosen;
    private String name;
    private int rarity;
    private int tier;
    @ManyToOne
    private ParticipantEntity participant;

    public UnitEntity(UnitDto dto) {
        this.items = dto.getItems();
        this.itemNames = dto.getItemNames();
        this.character_id = dto.getCharacter_id();
        this.chosen = dto.getChosen();
        this.name = dto.getName();
        this.rarity = dto.getRarity();
        this.tier = dto.getTier();
    }

    public Long getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Long unit_id) {
        this.unit_id = unit_id;
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

    public ParticipantEntity getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantEntity participant) {
        this.participant = participant;
    }
}
