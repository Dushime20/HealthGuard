package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.Dto.SymptomsDto;
import com.codewithdush.HealthGuard.Dto.VaccinationSitesDto;
import com.codewithdush.HealthGuard.entity.Symptoms;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.exception.OurException;
import com.codewithdush.HealthGuard.repo.SymptomsRepository;
import com.codewithdush.HealthGuard.repo.UserRepository;
import com.codewithdush.HealthGuard.service.Intrefac.ISymptomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SymptomsService implements ISymptomService {

    @Autowired
    private SymptomsRepository symptomsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public Response createUserSymptoms( Long userId, List<String> symptoms,String description, LocalDateTime submitedAt) {
       Response response = new Response();
       try{
           User user = userRepository.findById(userId).orElseThrow(()->new OurException("user not found"));
           Symptoms userSymptoms = new Symptoms();
           userSymptoms.setUser(user);
           userSymptoms.setSymptoms(symptoms);
           userSymptoms.setDescription(description);
           userSymptoms.setSubmittedAt(LocalDateTime.now());

           Symptoms savedSymptoms = symptomsRepository.save(userSymptoms);
           SymptomsDto symptomsDto = modelMapper.map(savedSymptoms,SymptomsDto.class);

           response.setStatusCode(200);
           response.setMessage("success");
           response.setSymptoms(symptomsDto);


       } catch (OurException e) {
           response.setStatusCode(404);
           response.setMessage(e.getMessage());
       } catch (Exception e) {
           response.setStatusCode(500);
           response.setMessage("Error add symptom: " + e.getMessage());
       }


        return response;
    }

    @Override
    public Response getAllSymptoms() {
        Response response = new Response();
        try{
            List<Symptoms> symptomsList = symptomsRepository.findAll();
            List<SymptomsDto> symptomsDtoList =symptomsList.stream()
                    .map(symptom-> modelMapper.map(symptom,SymptomsDto.class))
                    .collect(Collectors.toList());

            response.setStatusCode(200);
            response.setMessage("success");
            response.setSymptomsDtoList(symptomsDtoList);


        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error get all symptom: " + e.getMessage());
        }


        return response;
    }

    @Override
    public Response getSymptomsById(Long symptomsId) {

        Response response = new Response();
        try {
            Symptoms userSymptom = symptomsRepository.findById(symptomsId).orElseThrow(()-> new OurException("symptom not found"));
            SymptomsDto symptomsDto = modelMapper.map(userSymptom,SymptomsDto.class);

            response.setStatusCode(200);
            response.setMessage("success");
            response.setSymptoms(symptomsDto);


        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error get symptom by id: " + e.getMessage());
        }


        return response;
    }
}
