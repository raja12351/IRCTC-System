package Service;

import DTOs.RequestDtos.TrainDto;
import Models.Passenger;
import Models.Train;
import Repository.TrainRepository;
import Transformers.TrainTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;
    public String addTrain(TrainDto trainDto) {

        Train train = TrainTransformer.convertDtoToEntity(trainDto);

        trainRepository.save(train);

        return "Train is added in the database successfully";
    }

    public Integer total(String source, String destination, LocalDate date) {

        List<Train> trainList = trainRepository.findAll();

        List<Passenger> passengerList = new ArrayList<>();

        for(Train train : trainList){
            if(train.getSource().equals(source) && train.getDestination().equals(destination)){
                List<Passenger> passengerList1 = train.getPassengerList();
                passengerList.addAll(passengerList1);
            }
        }

        int personCount = 0;

        for(Passenger passenger : passengerList){
            if(passenger.getBookingDate()==date){
                personCount++;
            }
        }

        return personCount;
    }
}
