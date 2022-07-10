package com.deaponnen.common.dtoToUI;

import java.util.List;

public class MatchDataDto {
    private int position;
    private int playersEliminated;
    private int lastRound;
    private String riotId;
    private long game_datetime;

    private List<ParticipantDataDto> participants;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPlayersEliminated() {
        return playersEliminated;
    }

    public void setPlayersEliminated(int playersEliminated) {
        this.playersEliminated = playersEliminated;
    }

    public int getLastRound() {
        return lastRound;
    }

    public void setLastRound(int lastRound) {
        this.lastRound = lastRound;
    }

    public List<ParticipantDataDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDataDto> participants) {
        this.participants = participants;
    }

    public String getRiotId() {
        return riotId;
    }

    public void setRiotId(String riotId) {
        this.riotId = riotId;
    }

    public long getGame_datetime() {
        return game_datetime;
    }

    public void setGame_datetime(long game_datetime) {
        this.game_datetime = game_datetime;
    }
}
