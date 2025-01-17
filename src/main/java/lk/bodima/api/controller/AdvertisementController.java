package lk.bodima.api.controller;

import lk.bodima.api.controller.request.AdvertisementRequest;
import lk.bodima.api.controller.response.AdvertisementResponse;
import lk.bodima.api.exception.AdvertisementNotFoundException;
import lk.bodima.api.exception.UserNotFoundException;
import lk.bodima.api.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @PostMapping(value = "/users/{user-id}/advertisements",headers = "X-Api-Version=v1")
    public ResponseEntity<AdvertisementResponse> createAdvertisement(@PathVariable("user-id") Long userId, @RequestBody AdvertisementRequest advertisementRequest) throws UserNotFoundException {
    return new ResponseEntity<>(advertisementService.createAdvertisement(userId, advertisementRequest), HttpStatus.OK);
    }

    @GetMapping(value = "/advertisements", headers = "X-Api-Version=v1")
    public ResponseEntity<List<AdvertisementResponse>> getAllAdvertisements() {
        return new ResponseEntity<>(advertisementService.getAllAdvertisements(),HttpStatus.OK);
    }

    @GetMapping(value = "/users/{user-id}/advertisements/{advertisement-id}", headers = "X-Api-Version=v1")
    public ResponseEntity<AdvertisementResponse> getById(@PathVariable("user-id") Long userId, @PathVariable("advertisement-id") Long advertisementId) throws UserNotFoundException, AdvertisementNotFoundException {
        return new ResponseEntity<>(advertisementService.getAdvertisementById(userId,advertisementId), HttpStatus.OK);
    }

    @PutMapping(value = "/users/{user-id}/advertisements/{advertisement-id}", headers = "X-Api-Version=v1")
    public ResponseEntity<AdvertisementResponse> updateById(@RequestBody AdvertisementRequest advertisementRequest,@PathVariable("user-id") Long userId, @PathVariable("advertisement-id") Long advertisementId) throws UserNotFoundException, AdvertisementNotFoundException {
        return new ResponseEntity<>(advertisementService.updateById(advertisementRequest,userId,advertisementId), HttpStatus.OK);
    }
}
