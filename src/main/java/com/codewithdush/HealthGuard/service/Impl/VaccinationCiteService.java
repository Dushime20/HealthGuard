package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.CampaignsDto;
import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.Dto.VaccinationSitesDto;
import com.codewithdush.HealthGuard.entity.Campaigns;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.entity.VaccinationSites;
import com.codewithdush.HealthGuard.exception.OurException;
import com.codewithdush.HealthGuard.repo.UserRepository;
import com.codewithdush.HealthGuard.repo.VaccinationCiteRepository;
import com.codewithdush.HealthGuard.service.Intrefac.IVaccinationCitesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaccinationCiteService implements IVaccinationCitesService {


    @Autowired
    private VaccinationCiteRepository vaccinationCiteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Response addVaccinationCites(Long userId, String name,String citeDistrict, String citeSector,String citeCell, int availability, String contact_info, LocalDateTime updated_at) {
        Response response = new Response();
        try {

            User user = userRepository.findById(userId).orElseThrow(()-> new OurException("user not found"));
            VaccinationSites vaccinationSites = new VaccinationSites();
            vaccinationSites.setCiteCell(citeCell);
            vaccinationSites.setCiteDistrict(citeDistrict);
            vaccinationSites.setCiteSector(citeSector);
            vaccinationSites.setName(name);
            vaccinationSites.setContactInfo(contact_info);
            vaccinationSites.setUpdatedAt(updated_at);
            vaccinationSites.setAvailability(availability);
            vaccinationSites.setUser(user);

            VaccinationSites saveVaccinationCite = vaccinationCiteRepository.save(vaccinationSites);
            VaccinationSitesDto vaccinationSitesDto=modelMapper.map(saveVaccinationCite,VaccinationSitesDto.class);






            response.setStatusCode(200);
            response.setMessage("Success");
            response.setVaccinationSite(vaccinationSitesDto);


        }
        catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        }
        catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error creating vaccine: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getAllVaccinationCite() {
        Response response = new Response();
        try {
            // Retrieve the list of reports sorted by ID in descending order
            List<VaccinationSites>vaccinationSitesList =vaccinationCiteRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

            // Map the list of Reports to a list of ReportsDto
            List<VaccinationSitesDto>vaccinationSitesDtoList = vaccinationSitesList.stream()
                    .map(vaccinationSites -> modelMapper.map(vaccinationSites, VaccinationSitesDto.class))
                    .collect(Collectors.toList());

            response.setStatusCode(200);
            response.setMessage("success");
            response.setVaccinationSitesDtoList(vaccinationSitesDtoList);
        }  catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all Vaccination cite: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getVaccinationCiteByTime(LocalDateTime updated_at) {
        return null;
    }

    @Override
    public Response getVaccinationCiteByCiteName(String district, String sector,String cell) {
        Response response = new Response();
        try {
            // Retrieve the list of reports sorted by ID in descending order
            List<VaccinationSites>vaccinationSitesList =vaccinationCiteRepository.findAllByCiteDistrictAndCiteSectorAndCiteCell(district,sector,cell);

            // Map the list of Reports to a list of ReportsDto
            List<VaccinationSitesDto>vaccinationSitesDtoList = vaccinationSitesList.stream()
                    .map(vaccinationSites -> modelMapper.map(vaccinationSites, VaccinationSitesDto.class))
                    .collect(Collectors.toList());

            response.setStatusCode(200);
            response.setMessage("success");
            response.setVaccinationSitesDtoList(vaccinationSitesDtoList);
        }  catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting Vaccination cite by name: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response deleteVaccinationCite(Long vaccinationCiteId) {
        return null;
    }
}
