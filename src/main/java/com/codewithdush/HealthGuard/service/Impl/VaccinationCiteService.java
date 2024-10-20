package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.repo.VaccinationCiteRepository;
import com.codewithdush.HealthGuard.service.Intrefac.IVaccinationCites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VaccinationCiteService implements IVaccinationCites {


    @Autowired
    private VaccinationCiteRepository vaccinationCiteRepository;

    @Override
    public Response addVaccinationCites(Long vaccinationCiteId, String name, String location, int availability, String contact_info, LocalDateTime updated_at) {
        return null;
    }

    @Override
    public Response getAllVaccinationCite() {
        return null;
    }

    @Override
    public Response getVaccinationCiteByTime(LocalDateTime updated_at) {
        return null;
    }

    @Override
    public Response getVaccinationCiteByCiteName(String name) {
        return null;
    }

    @Override
    public Response deleteVaccinationCite(Long vaccinationCiteId) {
        return null;
    }
}
