package pl.megagames.megagameTools.clock;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Document
class Clock {
    @Id
    private String id;
    private long lastTurnStart;
    private long turnTime;
    private List<Game> games;

    Clock() {
//        this.id = generateUniqueID();
        this.games = new LinkedList<>();
    }

//    static boolean saveClock(Clock clock) {
//        Clock oldClock = getClock(clock.getId());
//        if(oldClock != null) {
//            oldClock.setTurnTime(clock.getTurnTime());
//            oldClock.setGames(clock.getGames());
//            return true;
//        }
//        return false;
//    }

//    private String generateUniqueID() {
//        UUID randomUUID = UUID.randomUUID();
//        String id = randomUUID.toString().replaceAll("_", "");
//        boolean idAlreadyUsed = getClocks().stream().anyMatch(clock -> clock.getId().equals(id));
//        if(idAlreadyUsed) {
//            return generateUniqueID();
//        } else {
//            return id;
//        }
//    }

//    static Clock getClock(String id) {
//        for(Clock clock : getClocks()) {
//            if(clock.getId().equals(id)) {
//                return clock;
//            }
//        }
//        return null;
//    }
}
