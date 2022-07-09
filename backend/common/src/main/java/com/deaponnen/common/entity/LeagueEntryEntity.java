package com.deaponnen.common.entity;

import com.deaponnen.common.dto.LeagueEntryDto;

import javax.persistence.*;

@Entity
@Table(name = "league_entry")
public class LeagueEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leagueEntry_id;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "league_entry_id")
    private MiniSeriesEntity miniSeries;


    public LeagueEntryEntity(LeagueEntryDto dto) {
        this.leagueId = dto.getLeagueId();
        this.summonerId = dto.getSummonerId();
        this.summonerName = dto.getSummonerName();
        this.queueType = dto.getQueueType();
        this.ratedTier = dto.getRatedTier();
        this.ratedRating = dto.getRatedRating();
        this.tier = dto.getTier();
        this.rank = dto.getRank();
        this.leaguePoints = dto.getLeaguePoints();
        this.wins = dto.getWins();
        this.losses = dto.getLosses();
        this.hotStreak = dto.isHotStreak();
        this.veteran = dto.isVeteran();
        this.freshBlood = dto.isFreshBlood();
        this.inactive = dto.isInactive();
        this.miniSeries = new MiniSeriesEntity(dto.getMiniSeries());
    }

    public Long getLeagueEntry_id() {
        return leagueEntry_id;
    }

    public void setLeagueEntry_id(Long leagueEntry_id) {
        this.leagueEntry_id = leagueEntry_id;
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

    public MiniSeriesEntity getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(MiniSeriesEntity miniSeries) {
        this.miniSeries = miniSeries;
    }
}
