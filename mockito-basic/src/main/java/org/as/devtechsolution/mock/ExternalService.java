package org.as.devtechsolution.mock;

/*
 * Copyright (c) 2021. @Aditya Srivastva
 * All Rights Reserved
 */

public class ExternalService {

    public String getValidationData(String id){
        return "actual data for validation";
    }

    void someMethod() throws RuntimeException{
        System.out.println("doing nothing..");
    }
}