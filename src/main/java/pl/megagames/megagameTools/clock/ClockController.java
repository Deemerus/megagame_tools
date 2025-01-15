package pl.megagames.megagameTools.clock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Optional;

@RestController
class ClockController {

    @Autowired
    ClockRepository clockRepository;

    @PostMapping("/clock/create")
    ResponseEntity<Clock> createClock() {
        Clock clock = new Clock();
        clockRepository.save(clock);
        return new ResponseEntity<>(clock, HttpStatus.OK);
    }

    @GetMapping("/clock/{id}")
    ResponseEntity<ClockDTO> getClock(@PathVariable String id) {
        Optional<Clock> clock = clockRepository.findById(id);
        if(clock.isPresent()) {
            return new ResponseEntity<>(new ClockDTO(clock.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("clock/save")
    ResponseEntity<Clock> saveClock(@RequestBody Clock clock) {
        Optional<Clock> optClock = clockRepository.findById(clock.getId());
        if(optClock.isPresent()) {
            clockRepository.save(clock);
            return new ResponseEntity<>(clock ,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("clock/start")
    ResponseEntity<ClockDTO> startClock(@RequestParam String id) {
        Optional<Clock> optClock = clockRepository.findById(id);
        if(optClock.isPresent()) {
            Clock clock = optClock.get();
            long turnTime = clock.getTurnTime();
            if(turnTime>0) {
                clock.setLastTurnStart(new Date().getTime()/1000);
                clockRepository.save(clock);
                return new ResponseEntity<>(new ClockDTO(clock), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.PRECONDITION_REQUIRED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
