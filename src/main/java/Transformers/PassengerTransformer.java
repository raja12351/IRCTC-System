package Transformers;

import DTOs.RequestDtos.PassengerDto;
import Models.Passenger;

public class PassengerTransformer {

    public static Passenger convertDtoToEntity(PassengerDto passengerDto){
        Passenger passenger = Passenger.builder().age(passengerDto.getAge())
                .gender(passengerDto.getGender())
                .bookingDate(passengerDto.getRequestedDate())
                .name(passengerDto.getName()).build();

        return passenger;
    }
}
