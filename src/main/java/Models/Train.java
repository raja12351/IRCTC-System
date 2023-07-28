package Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "trains")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainNo;

    private String source;

    private String destination;

    @OneToMany(mappedBy = "trains", cascade = CascadeType.ALL)
    private List<Passenger> passengerList;

    @OneToMany(mappedBy = "trains", cascade = CascadeType.ALL)
    private List<Food> foodList;
}
