package com.codewithdush.HealthGuard.service.Intrefac;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;

import java.time.LocalDateTime;

public interface IVaccineService {

    Response createVaccine(Long userId, String vaccineName, int doseReceived, String status, LocalDateTime nextDueDate,
                           String recipientName,String recipientPhone,String recipientDistrict,
                           String recipientSector,String recipientVillage,String recipientCell,
                           LocalDateTime createdAt);
    Response getAllPeopleVaccine();
    Response getAllVaccinedPeopleByVillage(String village,String District, String sector,String cell);
    Response getAllVaccinedPeopleByCell(String cell,String District, String sector);
    Response getAllVaccinedPeopleBySector(String sector,String District);
    Response getAllVaccinedPeopleByDistrict(String District);
    Response getVaccinatedById(Long vaccineId);
}
