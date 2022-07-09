package com.deaponnen.common.dto;

import com.deaponnen.common.entity.MetadataEntity;

import java.util.List;

public class MetadataDto {
    private String data_version;
    private String match_id;
    private List<String> participants;

    public MetadataDto(MetadataEntity entity) {
        this.data_version = entity.getData_version();
        this.match_id = entity.getMatch_id();
        this.participants = entity.getParticipants();
    }

    public String getData_version() {
        return data_version;
    }

    public void setData_version(String data_version) {
        this.data_version = data_version;
    }

    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }
}
