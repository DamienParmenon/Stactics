package com.deaponnen.common.dto;

import com.deaponnen.common.entity.CompanionEntity;

public class CompanionDto {
    private String skin_ID;
    private String content_ID;
    private String species;

    public CompanionDto(){
    }

    public CompanionDto(CompanionEntity entity) {
        this.skin_ID = entity.getSkin_ID();
        this.content_ID = entity.getContent_ID();
        this.species = entity.getContent_ID();
    }

    public String getSkin_ID() {
        return skin_ID;
    }

    public void setSkin_ID(String skin_ID) {
        this.skin_ID = skin_ID;
    }

    public String getContent_ID() {
        return content_ID;
    }

    public void setContent_ID(String content_ID) {
        this.content_ID = content_ID;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
