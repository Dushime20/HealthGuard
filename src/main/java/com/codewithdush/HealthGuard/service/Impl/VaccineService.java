package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.repo.VaccinationRepository;
import com.codewithdush.HealthGuard.service.Intrefac.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineService implements IVaccineService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Override
    public Response createVaccine(Long vaccineId, User userId, String vaccineName, int doseReceived, String status) {
        return null;
    }

    @Override
    public Response getAllPeopleVaccine() {
        return null;
    }

    @Override
    public Response getAllVaccinedPeopleByVillage(String village) {
        return null;
    }

    @Override
    public Response getAllVaccinedPeopleByCell(String cell) {
        return null;
    }

    @Override
    public Response getAllVaccinedPeopleBySector(String sector) {
        return null;
    }
}
