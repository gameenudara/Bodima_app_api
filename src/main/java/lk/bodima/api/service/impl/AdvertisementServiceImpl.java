package lk.bodima.api.service.impl;

import lk.bodima.api.controller.request.AdvertisementRequest;
import lk.bodima.api.controller.response.AdvertisementResponse;
import lk.bodima.api.exception.UserNotFoundException;
import lk.bodima.api.model.Advertisement;
import lk.bodima.api.model.User;
import lk.bodima.api.repository.AdvertisementRepository;
import lk.bodima.api.repository.UserRepository;
import lk.bodima.api.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public AdvertisementResponse createAdvertisement(Long userId, AdvertisementRequest advertisementRequest) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("User not found in ID: " + userId)
        );
        Advertisement advertisement = modelMapper.map(advertisementRequest, Advertisement.class);
        advertisement.setUser(user);
        AdvertisementResponse advertisementResponse = modelMapper.map(advertisementRepository.save(advertisement), AdvertisementResponse.class);
        return advertisementResponse;
    }

    @Override
    public List<AdvertisementResponse> getAllAdvertisements() {
            return advertisementRepository.findAll()
                    .stream()
                    .map(ad -> modelMapper.map(ad, AdvertisementResponse.class))
                    .collect(Collectors.toList());
    }

}
