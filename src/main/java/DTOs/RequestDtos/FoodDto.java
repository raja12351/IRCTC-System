package DTOs.RequestDtos;

import Models.Food;
import lombok.Data;

@Data
public class FoodDto {

    private int trainNo;

    private int TicketId;

    private Food food;

    private int price;
}
