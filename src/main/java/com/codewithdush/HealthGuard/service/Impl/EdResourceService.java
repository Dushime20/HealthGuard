package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.EducationalResourceDto;
import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.Dto.SymptomsDto;
import com.codewithdush.HealthGuard.entity.EducationalResource;
import com.codewithdush.HealthGuard.entity.Symptoms;
import com.codewithdush.HealthGuard.exception.OurException;
import com.codewithdush.HealthGuard.repo.EducationalResourceRepository;
import com.codewithdush.HealthGuard.service.Intrefac.IEdResourceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EdResourceService implements IEdResourceService {

    @Autowired
    private EducationalResourceRepository educationalResourceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Response createEdResource( String title, String Url, String contentType, String description, LocalDateTime createdAt) {
        Response response = new Response();
        try {

            EducationalResource educationalResource = new EducationalResource();
            educationalResource.setUrl(Url);
            educationalResource.setTitle(title);
            educationalResource.setCreatedAt(LocalDateTime.now());
            educationalResource.setContentType(contentType);
            educationalResource.setDescription(description);

            EducationalResource saveEdResource = educationalResourceRepository.save(educationalResource);

            EducationalResourceDto educationalResourceDto = modelMapper.map(saveEdResource, EducationalResourceDto.class);

            response.setStatusCode(200);
            response.setMessage("success");
            response.setEducationalResourceDto(educationalResourceDto);


        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error add Educational Resource : " + e.getMessage());
        }


        return response;
    }

    @Override
    public Response getAllEdResource() {
        Response response = new Response();
        try{
            List<EducationalResource>edResourceList = educationalResourceRepository.findAll();
            List<EducationalResourceDto>educationalResourceDtoList = edResourceList.stream()
                    .map(resource-> modelMapper.map(resource,EducationalResourceDto.class))
                    .collect(Collectors.toList());


            response.setStatusCode(200);
            response.setMessage("success");
            response.setEducationalResourceDtoList(educationalResourceDtoList);


        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error get all Educational Resource : " + e.getMessage());
        }


        return response;
    }

    @Override
    public Response getEdResourceById(Long resourceId) {
        Response response = new Response();
   try {
       EducationalResource educationalResource = educationalResourceRepository.findById(resourceId).orElseThrow(()-> new OurException("Educational Resource not found"));
       EducationalResourceDto educationalResourceDto = modelMapper.map(educationalResource,EducationalResourceDto.class);

       response.setStatusCode(200);
       response.setMessage("success");
       response.setEducationalResourceDto(educationalResourceDto);

   } catch (OurException e) {
       response.setStatusCode(404);
       response.setMessage(e.getMessage());
   } catch (Exception e) {
       response.setStatusCode(500);
       response.setMessage("Error get all Educational Resource : " + e.getMessage());
   }


        return response;
    }
}
