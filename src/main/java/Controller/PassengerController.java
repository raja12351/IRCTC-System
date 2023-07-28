package Controller;

import DTOs.RequestDtos.PassengerDto;
import Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping("/add-passenger")
    public ResponseEntity<String> addPassenger(@RequestBody PassengerDto passengerDto){
        try {
            String message = passengerService.addPassenger(passengerDto);

            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-total-females")
    public ResponseEntity<Integer> findFemales(@RequestParam int age1, @RequestParam int age2, @RequestParam String destination){
        Integer countFemales = passengerService.countFemales(age1,age2,destination);

        return new ResponseEntity<>(countFemales, HttpStatus.OK);
    }

}
