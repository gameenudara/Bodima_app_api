package lk.bodima.api.controller;

import lk.bodima.api.controller.request.AdvertisementRequest;
import lk.bodima.api.controller.response.AdvertisementResponse;
import lk.bodima.api.exception.UserNotFoundException;
import lk.bodima.api.model.Advertisement;
import lk.bodima.api.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @PostMapping(value = "/users/{user-id}/advertisements",headers = "X-Api-Version=v1")
    public ResponseEntity<AdvertisementResponse> createAdvertisement(@PathVariable("user-id") Long userId, @RequestBody AdvertisementRequest advertisementRequest) throws UserNotFoundException {
    return new ResponseEntity<>(advertisementService.createAdvertisement(userId, advertisementRequest), HttpStatus.OK);
    }
}
