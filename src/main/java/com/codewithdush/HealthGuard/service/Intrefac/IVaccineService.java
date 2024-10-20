package com.codewithdush.HealthGuard.service.Intrefac;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;

public interface IVaccineService {

    Response createVaccine(Long vaccineId, User userId, String vaccineName, int doseReceived,String status);
    Response getAllPeopleVaccine();
    Response getAllVaccinedPeopleByVillage(String village);
    Response getAllVaccinedPeopleByCell(String cell);
    Response getAllVaccinedPeopleBySector(String sector);
}
