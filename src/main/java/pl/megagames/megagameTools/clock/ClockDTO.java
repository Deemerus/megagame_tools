package pl.megagames.megagameTools.clock;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class ClockDTO extends Clock{
    private long timeRemaining;

    ClockDTO(Clock clock) {
        this.setId(clock.getId());
        this.setGames(clock.getGames());
        this.setTurnTime(clock.getTurnTime());
        this.setLastTurnStart(clock.getLastTurnStart());
        this.timeRemaining = this.getTurnTime()*60 - (new Date().getTime()/1000 - this.getLastTurnStart());
    }

}
