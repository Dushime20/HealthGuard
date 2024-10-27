package com.codewithdush.HealthGuard.service.Intrefac;

import com.codewithdush.HealthGuard.Dto.Response;

import java.time.LocalDateTime;

public interface IEdResourceService {

    Response createEdResource( String title, String Url, String contentType,String description, LocalDateTime createdAt);
    Response getAllEdResource();
    Response getEdResourceById(Long resourceId);
}
