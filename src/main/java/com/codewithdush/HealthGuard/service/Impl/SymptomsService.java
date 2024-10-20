package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.repo.SymptomsRepository;
import com.codewithdush.HealthGuard.service.Intrefac.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class SymptomsService implements ISymptomService {

    @Autowired
    private SymptomsRepository symptomsRepository;



    @Override
    public Response createUserSymptoms(Long symptomId, User userId, String symptoms, LocalDateTime submitedAt) {
        return null;
    }

    @Override
    public Response getAllSymptoms() {
        return null;
    }

    @Override
    public Response getSymptomsById(Long symptomsId) {
        return null;
    }
}
