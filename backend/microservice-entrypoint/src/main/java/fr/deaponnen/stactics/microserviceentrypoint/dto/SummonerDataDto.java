package com.deaponnen.common.dtoToUI;

import java.util.List;

public class SummonerDataDto {
    private String name;
    private int profileIconId;
    private long summonerLevel;
    private String tier;
    private String rank;
    private List<MatchDataDto> matchs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<MatchDataDto> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<MatchDataDto> matchs) {
        this.matchs = matchs;
    }
}
