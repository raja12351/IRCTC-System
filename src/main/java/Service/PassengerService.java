package Service;

import DTOs.RequestDtos.PassengerDto;
import Exceptions.TrainNotFound;
import Models.Passenger;
import Models.Train;
import Repository.PassengerRepository;
import Repository.TrainRepository;
import Transformers.PassengerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    TrainRepository trainRepository;
    public String addPassenger(PassengerDto passengerDto) throws TrainNotFound{

        int trainNo = passengerDto.getTrainNo();

        Optional<Train> trainOptional = trainRepository.findById(trainNo);

        if(trainOptional.isEmpty()){
            throw new TrainNotFound("No Train found with given Train number");
        }

        Train train = trainOptional.get();

        Passenger passenger = PassengerTransformer.convertDtoToEntity(passengerDto);

        train.getPassengerList().add(passenger);
        passenger.setTrain(train);

        trainRepository.save(train);
        passengerRepository.save(passenger);

        return "Booking of " + passenger.getName() + "is confirmed";
    }

    public Integer countFemales(int age1, int age2, String destination) {
         List<Passenger> passengerList = passengerRepository.findAll();

         Integer count = 0;

         for(Passenger passenger : passengerList){
             Train train = passenger.getTrain();
             if(passenger.getGender().toString().equals("FEMALE") && passenger.getAge()>=age1 && passenger.getAge()<=age2 && train.getDestination().equals(destination)){
                 count++;
             }
         }

         return count;
    }
}
