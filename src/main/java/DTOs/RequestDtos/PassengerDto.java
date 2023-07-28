package DTOs.RequestDtos;

import Enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PassengerDto {

    private int trainNo;

    private LocalDate requestedDate;

    private String name;

    private Gender gender;

    private int age;

}
