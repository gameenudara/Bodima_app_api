package lk.bodima.api.controller.response;

import lk.bodima.api.model.*;
import lombok.Data;

@Data
public class AdvertisementResponse {

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
