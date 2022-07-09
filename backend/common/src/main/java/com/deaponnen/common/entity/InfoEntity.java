package com.deaponnen.common.entity;

import com.deaponnen.common.dto.InfoDto;
import com.deaponnen.common.dto.ParticipantDto;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "info")
public class InfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long info_id;
    private Long game_datetime;
    private float game_length;
    private String game_variation;
    private String game_version;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    private List<ParticipantEntity> participants;
    private int queue_id;
    private String tft_game_type;
    private String tft_set_core_name;
    private int tft_set_number;

    public InfoEntity(InfoDto dto) {
        this.game_datetime = dto.getGame_datetime();
        this.game_length = dto.getGame_length();
        this.game_variation = dto.getGame_variation();
        this.game_version = dto.getGame_version();
        this.participants = dto.getParticipants().stream().map(p -> new ParticipantEntity(p)).collect(Collectors.toList());
        this.queue_id = dto.getQueue_id();
        this.tft_game_type = dto.getTft_game_type();
        this.tft_set_core_name = dto.getTft_set_core_name();
        this.tft_set_number = dto.getTft_set_number();
    }

    public Long getInfo_id() {
        return info_id;
    }

    public void setInfo_id(Long info_id) {
        this.info_id = info_id;
    }

    public Long getGame_datetime() {
        return game_datetime;
    }

    public void setGame_datetime(Long game_datetime) {
        this.game_datetime = game_datetime;
    }

    public float getGame_length() {
        return game_length;
    }

    public void setGame_length(float game_length) {
        this.game_length = game_length;
    }

    public String getGame_variation() {
        return game_variation;
    }

    public void setGame_variation(String game_variation) {
        this.game_variation = game_variation;
    }

    public String getGame_version() {
        return game_version;
    }

    public void setGame_version(String game_version) {
        this.game_version = game_version;
    }

    public List<ParticipantEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantEntity> participants) {
        this.participants = participants;
    }

    public int getQueue_id() {
        return queue_id;
    }

    public void setQueue_id(int queue_id) {
        this.queue_id = queue_id;
    }

    public String getTft_game_type() {
        return tft_game_type;
    }

    public void setTft_game_type(String tft_game_type) {
        this.tft_game_type = tft_game_type;
    }

    public String getTft_set_core_name() {
        return tft_set_core_name;
    }

    public void setTft_set_core_name(String tft_set_core_name) {
        this.tft_set_core_name = tft_set_core_name;
    }

    public int getTft_set_number() {
        return tft_set_number;
    }

    public void setTft_set_number(int tft_set_number) {
        this.tft_set_number = tft_set_number;
    }
}
