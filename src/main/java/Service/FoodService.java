package Service;

import DTOs.RequestDtos.FoodDto;
import Exceptions.TicketNotFound;
import Exceptions.TrainNotFound;
import Models.Food;
import Models.Passenger;
import Models.Train;
import Repository.FoodRepository;
import Repository.PassengerRepository;
import Repository.TrainRepository;
import Transformers.FoodTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FoodService {

    @Autowired
    TrainRepository trainRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FoodRepository foodRepository;

    public Integer totalPrice(LocalDate date, int trainNo) throws TrainNotFound{
        Optional<Train> trainOptional = trainRepository.findById(trainNo);
        if(trainOptional.isEmpty()){
            throw new TrainNotFound("No Train with given Train Number");
        }

        Train train = trainOptional.get();
        List<Passenger> passengerList = train.getPassengerList();
        List<Food> foodList = new ArrayList<>();

        int totalprice = 0;

        for(Passenger passenger : passengerList){
            if(passenger.getBookingDate()==date){
                foodList.addAll(passenger.getFoodList());
            }
        }

        for(Food food : foodList){
            totalprice += food.getPrice();
        }
        return totalprice;
    }

    public String addFood(FoodDto foodDto) throws TicketNotFound, TrainNotFound{
        int trainNo = foodDto.getTrainNo();
        Optional<Train> trainOptional = trainRepository.findById(trainNo);

        int ticketId = foodDto.getTicketId();
        Optional<Passenger> passengerOptional = passengerRepository.findById(ticketId);

        if(trainOptional.isEmpty()){
            throw new TrainNotFound("No Train with given Train Number");
        }
        if(passengerOptional.isEmpty()){
            throw new TicketNotFound("No Ticket with given Id");
        }

        Food food = FoodTransformer.convertDtoToEntity(foodDto);
        foodRepository.save(food);


        Train train = trainOptional.get();
        Passenger passenger = passengerOptional.get();

        train.getFoodList().add(food);
        passenger.getFoodList().add(food);

        return "Food is added to the ticket";
    }
}
