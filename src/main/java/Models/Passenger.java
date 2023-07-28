package Models;

import Enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "passengers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TicketId;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn
    private Train train;

    @OneToMany(mappedBy = "passengers", cascade = CascadeType.ALL)
    private List<Food> foodList;
}
