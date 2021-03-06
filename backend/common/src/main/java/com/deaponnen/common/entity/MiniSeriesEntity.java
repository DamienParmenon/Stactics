package com.deaponnen.common.entity;

import com.deaponnen.common.dto.MiniSeriesDto;

import javax.persistence.*;

@Entity
@Table(name = "miniseries")
public class MiniSeriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long miniSeries_id;
    private int losses;
    private String progress;
    private int target;
    private int wins;

    public MiniSeriesEntity(){
    }

    public MiniSeriesEntity(MiniSeriesDto dto) {
        this.losses = dto.getLosses();
        this.progress = dto.getProgress();
        this.target = dto.getTarget();
        this.wins = dto.getWins();
    }

    public Long getMiniSeries_id() {
        return miniSeries_id;
    }

    public void setMiniSeries_id(Long miniSeries_id) {
        this.miniSeries_id = miniSeries_id;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
