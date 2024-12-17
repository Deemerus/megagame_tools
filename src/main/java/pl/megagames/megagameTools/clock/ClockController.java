package pl.megagames.megagameTools.clock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
class ClockController {

    @PostMapping("/clock/create")
    ResponseEntity<Clock> createClock() {
        Clock clock = new Clock();
        return new ResponseEntity<>(clock, HttpStatus.OK);
    }

    @GetMapping("/clock/{id}")
    ResponseEntity<ClockDTO> getClock(@PathVariable String id) {
        Clock clock = Clock.getClock(id);
        if(clock != null) {
            return new ResponseEntity<>(new ClockDTO(clock), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("clock/save")
    ResponseEntity<Clock> saveClock(@RequestBody Clock clock) {
        boolean saveSuccessful = Clock.saveClock(clock);
        if(saveSuccessful) {
            return new ResponseEntity<>(clock ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("clock/start")
    ResponseEntity<ClockDTO> startClock(@RequestParam String id) {
        Clock clock = Clock.getClock(id);
        if(clock != null) {
            long turnTime = clock.getTurnTime();
            if(turnTime>0) {
                clock.setLastTurnStart(new Date().getTime()/1000);
                return new ResponseEntity<>(new ClockDTO(clock), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.PRECONDITION_REQUIRED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
