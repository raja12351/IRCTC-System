package Transformers;

import DTOs.RequestDtos.FoodDto;
import Models.Food;

public class FoodTransformer {

    public static Food convertDtoToEntity(FoodDto foodDto){
        Food food = Food.builder().price(foodDto.getPrice()).build();

        return food;
    }
}
