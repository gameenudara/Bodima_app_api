package lk.bodima.api.service;

import lk.bodima.api.controller.request.AdvertisementRequest;
import lk.bodima.api.controller.response.AdvertisementResponse;
import lk.bodima.api.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AdvertisementService {

    AdvertisementResponse createAdvertisement(Long userId, AdvertisementRequest advertisementRequest) throws UserNotFoundException;
}
