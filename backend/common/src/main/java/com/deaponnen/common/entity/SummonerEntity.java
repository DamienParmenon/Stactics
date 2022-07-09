package com.deaponnen.common.entity;

import com.deaponnen.common.dto.SummonerDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "summoner")
public class SummonerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long summoner_id;
    private String accountId;
    private int profileIconId;
    private Long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private Long summonerLevel;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "summoner_id")
    private List<MatchEntity> matchs;

    public SummonerEntity(SummonerDto dto) {
        this.accountId = dto.getAccountId();
        this.profileIconId = dto.getProfileIconId();
        this.revisionDate = dto.getRevisionDate();
        this.name = dto.getName();
        this.id = dto.getId();
        this.puuid = dto.getPuuid();
        this.summonerLevel = dto.getSummonerLevel();
        this.matchs = new ArrayList<>();
    }

    public Long getSummoner_id() {
        return summoner_id;
    }

    public void setSummoner_id(Long summoner_id) {
        this.summoner_id = summoner_id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public Long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Long revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public List<MatchEntity> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<MatchEntity> matchs) {
        this.matchs = matchs;
    }
}
