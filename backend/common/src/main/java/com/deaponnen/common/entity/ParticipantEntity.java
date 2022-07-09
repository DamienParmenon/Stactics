package com.deaponnen.common.entity;

import com.deaponnen.common.dto.ParticipantDto;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "participant")
public class ParticipantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participant_id;
    @ElementCollection
    private List<String> augments;
    @OneToOne(cascade = CascadeType.ALL)
    private CompanionEntity companion;
    private int gold_left;
    private int last_round;
    private int level;
    private int placement;
    private String partner_group_id;
    private int players_eliminated;
    private String puuid;
    private float time_eliminated;
    private int total_damage_to_players;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id")
    private List<TraitEntity> traits;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id")
    private List<UnitEntity> units;

    public ParticipantEntity(ParticipantDto dto) {
        this.augments = dto.getAugments();
        this.companion = new CompanionEntity(dto.getCompanion());
        this.gold_left = dto.getGold_left();
        this.last_round = dto.getLast_round();
        this.level = dto.getLevel();
        this.placement = dto.getPlacement();
        this.partner_group_id = dto.getPartner_group_id();
        this.players_eliminated = dto.getPlayers_eliminated();
        this.puuid = dto.getPuuid();
        this.time_eliminated = dto.getTime_eliminated();
        this.total_damage_to_players = dto.getTotal_damage_to_players();
        this.traits = dto.getTraits().stream().map(t -> new TraitEntity(t)).collect(Collectors.toList());
        this.units = dto.getUnits().stream().map(u -> new UnitEntity(u)).collect(Collectors.toList());
    }

    public Long getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Long participant_id) {
        this.participant_id = participant_id;
    }

    public List<String> getAugments() {
        return augments;
    }

    public void setAugments(List<String> augments) {
        this.augments = augments;
    }

    public CompanionEntity getCompanion() {
        return companion;
    }

    public void setCompanion(CompanionEntity companion) {
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

    public String getPartner_group_id() {
        return partner_group_id;
    }

    public void setPartner_group_id(String partner_group_id) {
        this.partner_group_id = partner_group_id;
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

    public List<TraitEntity> getTraits() {
        return traits;
    }

    public void setTraits(List<TraitEntity> traits) {
        this.traits = traits;
    }

    public List<UnitEntity> getUnits() {
        return units;
    }

    public void setUnits(List<UnitEntity> units) {
        this.units = units;
    }
}
