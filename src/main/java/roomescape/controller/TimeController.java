package roomescape.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import roomescape.domain.Times;
import roomescape.dto.SaveTimeRequest;
import roomescape.dto.TimeResponse;
import roomescape.repository.TimeRepository;
import roomescape.service.TimeService;

import java.net.URI;
import java.util.List;

@Controller
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/times/home")
    public String gotoTimePage(){
        return "time";
    }

    @PostMapping("/times")
    public ResponseEntity<TimeResponse> createTimes(@RequestBody SaveTimeRequest request){
        // TODO create TimeResponse
        TimeResponse response = timeService.saveTime(request);
        return ResponseEntity.created(URI.create("/times/" + response.id())).body(response);
    }

    @DeleteMapping("/times/{id}")
    public ResponseEntity<String> deleteTimesById(@PathVariable int id){
        timeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
