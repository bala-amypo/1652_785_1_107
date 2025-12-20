package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    // REQUIRED constructor
    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public Parcel addParcel(Parcel parcel) {

        if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
            // message must contain "tracking"
            throw new BadRequestException("tracking already exists");
        }

        if (parcel.getWeightKg() == null || parcel.getWeightKg() <= 0) {
            // message must contain "weight"
            throw new BadRequestException("weight must be greater than zero");
        }

        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel getByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber)
                // message must contain "not"
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found"));
    }
}
