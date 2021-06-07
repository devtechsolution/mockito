package org.as.devtechsolution.mock;

/*
 * Copyright (c) 2021. @Aditya Srivastva
 * All Rights Reserved
 */

public class MockService {

    ExternalService externalService;

    public MockService (ExternalService externalService) {
        this.externalService = externalService;
    }

    public boolean validate(String id){
        if(id ==null){
            throw new RuntimeException("id is null");
        }
        if(externalService.getValidationData(id) != null){
            return true;
        }

        return false;
    }
}