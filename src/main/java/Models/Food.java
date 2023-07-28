package Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;

    private int price;

    @ManyToOne
    @JoinColumn
    private Train train;

    @ManyToOne
    @JoinColumn
    private Passenger passenger;
}
