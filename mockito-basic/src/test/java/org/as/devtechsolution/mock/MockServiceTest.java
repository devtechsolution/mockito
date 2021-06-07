package org.as.devtechsolution.mock;

/*
 * Copyright (c) 2021. @Aditya Srivastva
 * All Rights Reserved
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockServiceTest {
    @InjectMocks
    MockService mockService;
    @Mock
    ExternalService externalService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);

        //externalService = Mockito.mock(ExternalService.class); //// Equivalent to @Mock ExternalService externalServic;

        //mockService = new MockService(externalService);// Equivalent to @InjectMocks MockService mockService;
    }

    @Test
    void  validate_test1(){
        //when(externalService.getValidationData("Rama")).thenReturn("Some value");
        when(externalService.getValidationData(anyString())).thenReturn("Some value");

        assertTrue(mockService.validate("Rama"));
        //verify(externalService, times(1)).getValidationData("Rama123");
        verify(externalService, times(1)).getValidationData(anyString());

    }

    @Test
    void test2(){
        when(externalService.getValidationData("true")).thenReturn("true");
        when(externalService.getValidationData(null)).thenReturn(null);
        assertTrue(mockService.validate("true"));

        assertThrows(RuntimeException.class, () -> mockService.validate(null));

        verify(externalService).getValidationData("true");
    }

    //when -then
    @Test
    void test3(){
        when(externalService.getValidationData(null)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> mockService.validate(null));
    }

    //doretun and dothrow
    @Test
    void test4() {
        doReturn("abc").when(externalService.getValidationData("abc"));
        doThrow(RuntimeException.class).when(externalService.getValidationData(null));
    }
    // spy object
    /*
        @Mock
    ExternalService externalService;

     @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);

        //externalService = Mockito.spy(ExternalService.class); //// Equivalent to @Mock ExternalService externalServic;

        //mockService = new MockService(externalService);// Equivalent to @InjectMocks MockService mockService;
    }

    * */


}