package com.deaponnen.common.dto;

import com.deaponnen.common.entity.LeagueEntryEntity;

public class LeagueEntryDto {
    private String leagueId;
    private String summonerId;
    private String summonerName;
    private String queueType;
    private String ratedTier;
    private int ratedRating;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;
    private MiniSeriesDto miniSeries;

    public LeagueEntryDto(){
    }

    public LeagueEntryDto(LeagueEntryEntity entity) {
        this.leagueId = entity.getLeagueId();
        this.summonerId = entity.getSummonerId();
        this.summonerName = entity.getSummonerName();
        this.queueType = entity.getQueueType();
        this.ratedTier = entity.getRatedTier();
        this.ratedRating = entity.getRatedRating();
        this.tier = entity.getTier();
        this.rank = entity.getRank();
        this.leaguePoints = entity.getLeaguePoints();
        this.wins = entity.getWins();
        this.losses = entity.getLosses();
        this.hotStreak = entity.isHotStreak();
        this.veteran = entity.isVeteran();
        this.freshBlood = entity.isFreshBlood();
        this.inactive = entity.isInactive();
        this.miniSeries = new MiniSeriesDto(entity.getMiniSeries());
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getRatedTier() {
        return ratedTier;
    }

    public void setRatedTier(String ratedTier) {
        this.ratedTier = ratedTier;
    }

    public int getRatedRating() {
        return ratedRating;
    }

    public void setRatedRating(int ratedRating) {
        this.ratedRating = ratedRating;
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

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public boolean isHotStreak() {
        return hotStreak;
    }

    public void setHotStreak(boolean hotStreak) {
        this.hotStreak = hotStreak;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public void setVeteran(boolean veteran) {
        this.veteran = veteran;
    }

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public void setFreshBlood(boolean freshBlood) {
        this.freshBlood = freshBlood;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public MiniSeriesDto getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(MiniSeriesDto miniSeries) {
        this.miniSeries = miniSeries;
    }
}
