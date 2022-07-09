package com.deaponnen.common.dto;

import com.deaponnen.common.entity.ParticipantEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantDto {
    private List<String> augments;
    private CompanionDto companion;
    private int gold_left;
    private int last_round;
    private int level;
    private int placement;
    private String partner_group_id;
    private int players_eliminated;
    private String puuid;
    private float time_eliminated;
    private int total_damage_to_players;
    private List<TraitDto> traits;
    private List<UnitDto> units;

    public ParticipantDto(ParticipantEntity entity) {
        this.augments = entity.getAugments();
        this.companion = new CompanionDto(entity.getCompanion());
        this.gold_left = entity.getGold_left();
        this.last_round = entity.getLast_round();
        this.level = entity.getLevel();
        this.placement = entity.getPlacement();
        this.partner_group_id = entity.getPartner_group_id();
        this.players_eliminated = entity.getPlayers_eliminated();
        this.puuid = entity.getPuuid();
        this.time_eliminated = entity.getTime_eliminated();
        this.total_damage_to_players = entity.getTotal_damage_to_players();
        this.traits = entity.getTraits().stream().map(t -> new TraitDto(t)).collect(Collectors.toList());
        this.units = entity.getUnits().stream().map(u -> new UnitDto(u)).collect(Collectors.toList());
    }

    public CompanionDto getCompanion() {
        return companion;
    }

    public List<String> getAugments() {
        return augments;
    }

    public void setAugments(List<String> augments) {
        this.augments = augments;
    }

    public void setCompanion(CompanionDto companion) {
        this.companion = companion;
    }

    public int getGold_left() {
        return gold_left;
    }

    public void setGold_left(int gold_left) {
        this.gold_left = gold_left;
    }

    public int getLast_round() {
        return last_round;
    }

    public void setLast_round(int last_round) {
        this.last_round = last_round;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public int getPlayers_eliminated() {
        return players_eliminated;
    }

    public void setPlayers_eliminated(int players_eliminated) {
        this.players_eliminated = players_eliminated;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public float getTime_eliminated() {
        return time_eliminated;
    }

    public void setTime_eliminated(float time_eliminated) {
        this.time_eliminated = time_eliminated;
    }

    public int getTotal_damage_to_players() {
        return total_damage_to_players;
    }

    public void setTotal_damage_to_players(int total_damage_to_players) {
        this.total_damage_to_players = total_damage_to_players;
    }

    public List<TraitDto> getTraits() {
        return traits;
    }

    public void setTraits(List<TraitDto> traits) {
        this.traits = traits;
    }

    public List<UnitDto> getUnits() {
        return units;
    }

    public void setUnits(List<UnitDto> units) {
        this.units = units;
    }

    public String getPartner_group_id() {
        return partner_group_id;
    }

    public void setPartner_group_id(String partner_group_id) {
        this.partner_group_id = partner_group_id;
    }
}
