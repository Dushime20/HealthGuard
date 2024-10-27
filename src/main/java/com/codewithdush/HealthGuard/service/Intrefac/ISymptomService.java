package com.codewithdush.HealthGuard.service.Intrefac;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ISymptomService {

    Response createUserSymptoms( Long userId, List<String> symptoms,String description, LocalDateTime submitedAt);
    Response getAllSymptoms();
    Response getSymptomsById(Long symptomsId);

}
