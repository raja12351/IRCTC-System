package Controller;

import DTOs.RequestDtos.FoodDto;
import Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public class FoodController {

    @Autowired
    FoodService foodService;

    @PostMapping("/add-food")
    public ResponseEntity<String> addFood(@RequestBody FoodDto foodDto){
        try{
            String message = foodService.addFood(foodDto);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/foor-price")
    public ResponseEntity<Integer> totalPrice(@RequestParam LocalDate date, @RequestParam int trainNo){
        try {
            Integer totalPrice = foodService.totalPrice(date, trainNo);
            return new ResponseEntity<>(totalPrice, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
        }
    }
}
