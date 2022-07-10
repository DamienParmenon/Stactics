package com.deaponnen.common.entity;

import com.deaponnen.common.dto.TraitDto;

import javax.persistence.*;

@Entity
@Table(name = "trait")
public class TraitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trait_id;
    private String name;
    private int num_units;
    private int style;
    private int tier_current;
    private int tier_total;
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private ParticipantEntity participant;

    public TraitEntity(){
    }

    public TraitEntity(TraitDto dto) {
        this.name = dto.getName();
        this.num_units = dto.getNum_units();
        this.style = dto.getStyle();
        this.tier_current = dto.getTier_current();
        this.tier_total = dto.getTier_total();
    }

    public Long getTrait_id() {
        return trait_id;
    }

    public void setTrait_id(Long trait_id) {
        this.trait_id = trait_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum_units() {
        return num_units;
    }

    public void setNum_units(int num_units) {
        this.num_units = num_units;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getTier_current() {
        return tier_current;
    }

    public void setTier_current(int tier_current) {
        this.tier_current = tier_current;
    }

    public int getTier_total() {
        return tier_total;
    }

    public void setTier_total(int tier_total) {
        this.tier_total = tier_total;
    }

    public ParticipantEntity getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantEntity participant) {
        this.participant = participant;
    }
}
