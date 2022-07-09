package com.deaponnen.common.dto;

import com.deaponnen.common.entity.MatchEntity;

public class MatchDto {
    private MetadataDto metadata;
    private InfoDto info;

    public MatchDto(MatchEntity entity) {
        this.metadata = new MetadataDto(entity.getMetadata());
        this.info = new InfoDto(entity.getInfo());
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
    }
}
