package pl.megagames.megagameTools.clock;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
class Clock {
    private String id;
    private long lastTurnStart;
    private long turnTime;
    private List<Game> games;

    private static List<Clock> _clocks;
    private static long _removeTimeThreshold;

    Clock() {
        this.id = generateUniqueID();
        this.games = new LinkedList<>();
        getClocks().add(this);
    }

    private static List<Clock> getClocks() {
        if(_clocks == null) {
            _clocks = new LinkedList<>();
        }
        return _clocks;
    }

    static boolean saveClock(Clock clock) {
        Clock oldClock = getClock(clock.getId());
        if(oldClock != null) {
            oldClock.setTurnTime(clock.getTurnTime());
            oldClock.setGames(clock.getGames());
            return true;
        }
        return false;
    }

    private String generateUniqueID() {
        UUID randomUUID = UUID.randomUUID();
        String id = randomUUID.toString().replaceAll("_", "");
        boolean idAlreadyUsed = getClocks().stream().anyMatch(clock -> clock.getId().equals(id));
        if(idAlreadyUsed) {
            return generateUniqueID();
        } else {
            return id;
        }
    }

    static Clock getClock(String id) {
        for(Clock clock : getClocks()) {
            if(clock.getId().equals(id)) {
                return clock;
            }
        }
        return null;
    }
}
