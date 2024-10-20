package com.codewithdush.HealthGuard.service.Intrefac;

import com.codewithdush.HealthGuard.Dto.Response;

import java.time.LocalDateTime;

public interface IVaccinationCites {

    Response addVaccinationCites(Long vaccinationCiteId, String name, String location, int availability, String contact_info, LocalDateTime updated_at);

    Response getAllVaccinationCite();

    Response getVaccinationCiteByTime(LocalDateTime updated_at);

    Response getVaccinationCiteByCiteName(String name);

    Response deleteVaccinationCite(Long vaccinationCiteId);
}
