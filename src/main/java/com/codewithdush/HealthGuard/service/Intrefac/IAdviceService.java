package com.codewithdush.HealthGuard.service.Intrefac;

import com.codewithdush.HealthGuard.Dto.Response;

import java.time.LocalDateTime;

public interface IAdviceService {

    Response createAdvice(Long symptomId, Long doctorId, String message);
   Response getPatientResponse(Long symptomId, Long patientId);

}
