package Controller;

import DTOs.RequestDtos.TrainDto;
import Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    TrainService trainService;

    @PostMapping("/add-train")
    public ResponseEntity<String> addTrain(@RequestBody TrainDto trainDto){
        String message = trainService.addTrain(trainDto);

        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @GetMapping("/total-person-between-dates")
    public ResponseEntity<Integer> totalPerson(@RequestParam String source, @RequestParam String destination, @RequestParam LocalDate date){
        Integer totals = trainService.total(source,destination,date);

        return new ResponseEntity<>(totals,HttpStatus.OK);
    }
}
