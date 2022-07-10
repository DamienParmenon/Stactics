package com.deaponnen.common.entity;

import com.deaponnen.common.dto.CompanionDto;

import javax.persistence.*;

@Entity
@Table(name = "companion")
public class CompanionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companion_id;
    private String skin_ID;
    private String content_ID;
    private String species;

    public CompanionEntity(){
    }

    public CompanionEntity(CompanionDto dto) {
        this.skin_ID = dto.getSkin_ID();
        this.content_ID = dto.getContent_ID();
        this.species = dto.getSpecies();
    }

    public Long getCompanion_id() {
        return companion_id;
    }

    public void setCompanion_id(Long companion_id) {
        this.companion_id = companion_id;
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
