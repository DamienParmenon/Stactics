package com.deaponnen.common.dto;

import com.deaponnen.common.entity.MiniSeriesEntity;

public class MiniSeriesDto {
    private int losses;
    private String progress;
    private int target;
    private int wins;

    public int getLosses() {
        return losses;
    }

    public MiniSeriesDto(MiniSeriesEntity entity) {
        this.losses = entity.getLosses();
        this.progress = entity.getProgress();
        this.target = entity.getTarget();
        this.wins = entity.getWins();
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
