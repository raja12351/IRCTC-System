package Transformers;

import DTOs.RequestDtos.TrainDto;
import Models.Train;

public class TrainTransformer {

    public static Train convertDtoToEntity(TrainDto trainDto){
        Train train = Train.builder().source(trainDto.getSource()).destination(trainDto.getDestination()).build();

        return train;
    }
}
