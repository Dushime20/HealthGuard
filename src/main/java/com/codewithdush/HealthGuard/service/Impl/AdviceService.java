package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.AdviceDto;
import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.Advice;
import com.codewithdush.HealthGuard.entity.Symptoms;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.exception.OurException;
import com.codewithdush.HealthGuard.repo.AdviceRepository;
import com.codewithdush.HealthGuard.repo.SymptomsRepository;
import com.codewithdush.HealthGuard.repo.UserRepository;
import com.codewithdush.HealthGuard.service.Intrefac.IAdviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdviceService implements IAdviceService {

    @Autowired
    private AdviceRepository adviceRepository;

    @Autowired
    private SymptomsRepository symptomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Response createAdvice(Long symptomId, Long doctorId, String message) {
        Response response = new Response();
        try {
            // Check if user is authorized (role: Health Professional)
            Optional<User> doctor = userRepository.findById(doctorId);
            if (doctor.isEmpty() || !"Health Professional".equalsIgnoreCase(doctor.get().getRole())) {
                response.setStatusCode(403);
                response.setMessage("User is not authorized to respond.");
                return response;
            }

            // Validate symptom existence
            Optional<Symptoms> symptom = symptomRepository.findById(symptomId);
            if (symptom.isEmpty()) {
                response.setStatusCode(404);
                response.setMessage("Symptom not found.");
                return response;
            }

            // Create and save advice
            Advice advice = new Advice();
            advice.setDoctor(doctor.get());
            advice.setSymptom(symptom.get());
            advice.setResponseText(message);
            advice.setResponseDate(LocalDateTime.now());

            Advice savedAdvice = adviceRepository.save(advice);
            AdviceDto adviceDto = modelMapper.map(savedAdvice, AdviceDto.class);
            response.setStatusCode(200);
            response.setMessage("Success");
            response.setAdvice(adviceDto);

        } catch (OurException e) {
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error creating symptom response: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getPatientResponse(Long symptomId, Long patientId) {
        Response response = new Response();

        try {
            // Check if symptom exists and belongs to the patient
            Optional<Symptoms> symptom = symptomRepository.findById(symptomId);
            if (symptom.isEmpty() || !symptom.get().getUser().getUserId().equals(patientId)) {
                response.setStatusCode(403);
                response.setMessage("Access denied: Symptom not found or does not belong to the patient.");
                return response;
            }

            // Retrieve advice for the symptom
            Optional<Advice> advice = adviceRepository.findBySymptomId(symptomId);
            if (advice.isEmpty()) {
                response.setStatusCode(404);
                response.setMessage("No response available for this symptom.");
                return response;
            }

            // Map to DTO and return response
            AdviceDto adviceDto = modelMapper.map(advice.get(), AdviceDto.class);
            response.setStatusCode(200);
            response.setMessage("Success");
            response.setAdvice(adviceDto);

        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setMessage("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error retrieving symptom response: " + e.getMessage());
        }

        return response;
    }
}
