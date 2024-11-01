package com.codewithdush.HealthGuard.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {


    private int statusCode;
    private String message;
    private String token;
    private String role;
    private Long userId;
    private String expirationTime;
    private UserDto user;
    private List<UserDto> userDtoList;
    private CampaignsDto campaigns;
    private VaccinationsDto vaccinations;
    private ReportsDto reports;
    private SymptomsDto symptoms;
    private VaccinationSitesDto vaccinationSite;
    private List<CampaignsDto> campaignsDtoList;
    private List<VaccinationsDto> vaccinationsDtoList;
    private List<VaccinationSitesDto> vaccinationSitesDtoList;
    private List<ReportsDto>reportDtoList;
    private List<SymptomsDto>symptomsDtoList;
    private EducationalResourceDto educationalResourceDto;
    private List<EducationalResourceDto>educationalResourceDtoList;

    private AdviceDto advice;


}
