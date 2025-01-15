package lk.bodima.api.controller.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.bodima.api.model.*;
import lombok.Data;

@Data
public class AdvertisementRequest {

    private String title;
    private Double price;
    private String description;
    private PropertyType propertyType;
    private Category category;
    private String address;
    private String location;
    private String bedRooms;
    private BathRooms bathRooms;
    private BillPayedBy billPayedBy;
    private VehicleParking vehicleParking;
    private PaymentDuration paymentDuration;
    private String imagesUrl;
}
