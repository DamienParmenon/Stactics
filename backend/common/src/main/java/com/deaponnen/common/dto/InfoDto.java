package com.deaponnen.common.dto;

import com.deaponnen.common.entity.InfoEntity;

import java.util.List;
import java.util.stream.Collectors;

public class InfoDto {
    private long game_datetime;
    private float game_length;
    private String game_variation;
    private String game_version;
    private List<ParticipantDto> participants;
    private int queue_id;
    private String tft_game_type;
    private String tft_set_core_name;
    private int tft_set_number;

    public InfoDto(InfoEntity entity) {
        this.game_datetime = entity.getGame_datetime();
        this.game_length = entity.getGame_length();
        this.game_variation = entity.getGame_variation();
        this.game_version = entity.getGame_version();
        this.participants = entity.getParticipants().stream().map(p -> new ParticipantDto(p)).collect(Collectors.toList());
        this.queue_id = entity.getQueue_id();
        this.tft_game_type = entity.getTft_game_type();
        this.tft_set_core_name = entity.getTft_set_core_name();
        this.tft_set_number = entity.getTft_set_number();
    }

    public long getGame_datetime() {
        return game_datetime;
    }

    public void setGame_datetime(long game_datetime) {
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

    public List<ParticipantDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDto> participants) {
        this.participants = participants;
    }

    public int getQueue_id() {
        return queue_id;
    }

    public void setQueue_id(int queue_id) {
        this.queue_id = queue_id;
    }

    public int getTft_set_number() {
        return tft_set_number;
    }

    public void setTft_set_number(int tft_set_number) {
        this.tft_set_number = tft_set_number;
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
}
