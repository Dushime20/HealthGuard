package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.CampaignsDto;
import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.Dto.VaccinationsDto;
import com.codewithdush.HealthGuard.entity.Campaigns;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.entity.Vaccinations;
import com.codewithdush.HealthGuard.exception.OurException;
import com.codewithdush.HealthGuard.repo.UserRepository;
import com.codewithdush.HealthGuard.repo.VaccinationRepository;
import com.codewithdush.HealthGuard.service.Intrefac.IVaccineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaccineService implements IVaccineService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Response createVaccine( Long userId, String vaccineName, int doseReceived, String status,LocalDateTime nextDueDate,
                                   String recipientName,String recipientPhone,String recipientDistrict,
                                   String recipientSector,String recipientVillage,String recipientCell,
                                   LocalDateTime createdAt) {
        Response response = new Response();
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new OurException("User not found"));
            Vaccinations vaccinations = new Vaccinations();

            vaccinations.setVaccineName(vaccineName);
            vaccinations.setDosesReceived(doseReceived);
            vaccinations.setStatus(status);
            vaccinations.setNextDueDate(nextDueDate);
            vaccinations.setRecipientName(recipientName);
            vaccinations.setRecipientPhone(recipientPhone);
            vaccinations.setRecipientDistrict(recipientDistrict);
            vaccinations.setRecipientSector(recipientSector);
            vaccinations.setRecipientCell(recipientCell);
            vaccinations.setRecipientVillage(recipientVillage);
            vaccinations.setUser(user);
            vaccinations.setCreatedAt(LocalDateTime.now());



            Vaccinations savedVaccination= vaccinationRepository.save(vaccinations);

            // Map to DTO
            VaccinationsDto vaccinationsDto = modelMapper.map(savedVaccination,VaccinationsDto.class);


            response.setStatusCode(200);
            response.setMessage("Success");
            response.setVaccinations(vaccinationsDto);

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
    public Response getAllPeopleVaccine() {
        Response response = new Response();
        try {
            // Retrieve the list of reports sorted by ID in descending order
            List<Vaccinations> vaccinationsList= vaccinationRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

            // Map the list of Reports to a list of ReportsDto
            List<VaccinationsDto> vaccinationsDtoList = vaccinationsList.stream()
                    .map(vaccinations -> modelMapper.map(vaccinations, VaccinationsDto.class))
                    .collect(Collectors.toList());

            response.setStatusCode(200);
            response.setMessage("success");
            response.setVaccinationsDtoList(vaccinationsDtoList);
        }  catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all vaccinated people: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getAllVaccinedPeopleByVillage(String village,String District, String sector,String cell) {
        Response response = new Response();
        try{
            List<Vaccinations> vaccinationsList = vaccinationRepository.findByRecipientVillageAndDistrictAndSectorAndCell(village,District,sector,cell);
            List<VaccinationsDto> vaccinationsDtoList =vaccinationsList.stream()
                    .map(vaccinations -> modelMapper.map(vaccinations, VaccinationsDto.class))
                    .collect(Collectors.toList());


            response.setStatusCode(200);
            response.setMessage("success");
            response.setVaccinationsDtoList(vaccinationsDtoList);
        }  catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all vaccinated people in village: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getAllVaccinedPeopleByCell(String cell,String District, String sector) {
        Response response = new Response();
        try{
            List<Vaccinations> vaccinationsList = vaccinationRepository.findByRecipientSectorAndDistrictAndCell(cell,District,sector);
            List<VaccinationsDto> vaccinationsDtoList =vaccinationsList.stream()
                    .map(vaccinations -> modelMapper.map(vaccinations, VaccinationsDto.class))
                    .collect(Collectors.toList());


            response.setStatusCode(200);
            response.setMessage("success");
            response.setVaccinationsDtoList(vaccinationsDtoList);
        }  catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all vaccinated people in village: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getAllVaccinedPeopleBySector(String sector,String District) {

        Response response = new Response();
        try{
            List<Vaccinations> vaccinationsList = vaccinationRepository.findByRecipientSectorAndDistrict(sector,District);
            List<VaccinationsDto> vaccinationsDtoList =vaccinationsList.stream()
                    .map(vaccinations -> modelMapper.map(vaccinations, VaccinationsDto.class))
                    .collect(Collectors.toList());


            response.setStatusCode(200);
            response.setMessage("success");
            response.setVaccinationsDtoList(vaccinationsDtoList);
        }  catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all vaccinated people in village: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getAllVaccinedPeopleByDistrict(String District) {
        Response response = new Response();
        try{
            List<Vaccinations> vaccinationsList = vaccinationRepository.findByRecipientDistrict(District);
            List<VaccinationsDto> vaccinationsDtoList =vaccinationsList.stream()
                    .map(vaccinations -> modelMapper.map(vaccinations, VaccinationsDto.class))
                    .collect(Collectors.toList());


            response.setStatusCode(200);
            response.setMessage("success");
            response.setVaccinationsDtoList(vaccinationsDtoList);
        }  catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all vaccinated people in village: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getVaccinatedById(Long vaccineId) {
        Response response = new Response();
        try{
            Vaccinations vaccinations = vaccinationRepository.findById(vaccineId).orElseThrow(()-> new OurException("VaccinationId not exist"));
            VaccinationsDto vaccinationsDto = modelMapper.map(vaccinations,VaccinationsDto.class);

            response.setStatusCode(200);
            response.setMessage("success");
            response.setVaccinations(vaccinationsDto);

        }  catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all vaccinated people in village: " + e.getMessage());
        }

        return response;
    }
}
