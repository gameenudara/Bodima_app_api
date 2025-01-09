package lk.bodima.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "advertisements")
public class Advertisement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double price;

    private String description;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String address;

    private String location;

    private String bedRooms;

    @Enumerated(EnumType.STRING)
    private BathRooms bathRooms;

    @Enumerated(EnumType.STRING)
    private BillPayedBy billPayedBy;

    @Enumerated(EnumType.STRING)
    private VehicleParking vehicleParking;

    @Enumerated(EnumType.STRING)
    private PaymentDuration paymentDuration;

    private String imagesUrl;

    @ManyToOne
    private User user;
}
