package ru.rozvezev.soapservice.util;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class NegativeDiscriminantException extends RuntimeException{

    public NegativeDiscriminantException(String formula, double D) {
        super("formula: " + formula + "; D = " + D + "; Negative discriminant.");
    }
}
