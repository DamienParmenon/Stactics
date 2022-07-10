package com.deaponnen.common.entity;

import com.deaponnen.common.dto.MetadataDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "metadata")
public class MetadataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metadata_id;
    private String data_version;
    private String match_id;
    @ElementCollection
    private List<String> participants;

    public MetadataEntity(){
    }

    public MetadataEntity(MetadataDto dto) {
        this.data_version = dto.getData_version();
        this.match_id = dto.getMatch_id();
        this.participants = dto.getParticipants();
    }

    public Long getMetadata_id() {
        return metadata_id;
    }

    public void setMetadata_id(Long metadata_id) {
        this.metadata_id = metadata_id;
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
