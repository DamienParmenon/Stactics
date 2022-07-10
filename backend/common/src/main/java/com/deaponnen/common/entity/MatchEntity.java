package com.deaponnen.common.entity;

import com.deaponnen.common.dto.MatchDto;
import com.deaponnen.common.dto.SummonerDto;

import javax.persistence.*;

@Entity
@Table(name = "match_table")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long match_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metadata_id")
    private MetadataEntity metadata;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    private InfoEntity info;

    @ManyToOne
    @JoinColumn(name = "summoner_id")
    private SummonerEntity summoner;

    public MatchEntity(){
    }

    public MatchEntity(MatchDto dto) {
        this.metadata = new MetadataEntity(dto.getMetadata());
        this.info = new InfoEntity(dto.getInfo());
    }

    public Long getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Long match_id) {
        this.match_id = match_id;
    }

    public MetadataEntity getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataEntity metadata) {
        this.metadata = metadata;
    }

    public InfoEntity getInfo() {
        return info;
    }

    public void setInfo(InfoEntity info) {
        this.info = info;
    }

    public SummonerEntity getSummoner() {
        return summoner;
    }

    public void setSummoner(SummonerEntity summoner) {
        this.summoner = summoner;
    }
}
