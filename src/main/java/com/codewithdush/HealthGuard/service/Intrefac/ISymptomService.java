package com.codewithdush.HealthGuard.service.Intrefac;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;

import java.time.LocalDateTime;

public interface ISymptomService {

    Response createUserSymptoms(Long symptomId, User userId, String symptoms, LocalDateTime submitedAt);
    Response getAllSymptoms();
    Response getSymptomsById(Long symptomsId);

}
