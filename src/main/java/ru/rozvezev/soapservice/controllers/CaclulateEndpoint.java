package ru.rozvezev.soapservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.rozvezev.ns.CalculateRequest;
import ru.rozvezev.ns.CalculateResponse;
import ru.rozvezev.ns.Solution;
import ru.rozvezev.soapservice.services.SolutionService;
import ru.rozvezev.soapservice.util.NegativeDiscriminantException;


@Endpoint
public class CaclulateEndpoint {

    private static final String NAMESPACE_URI = "http://rozvezev.ru/ns";
    private final SolutionService solutionService;

    @Autowired
    public CaclulateEndpoint(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calculateRequest")
    @ResponsePayload
    public CalculateResponse getCountry(@RequestPayload CalculateRequest request) throws NegativeDiscriminantException {
        Solution solution = solutionService.solveQuadraticEquation(request.getA(), request.getB(), request.getC());
        CalculateResponse response = new CalculateResponse();
        response.setSolution(solution);
        return response;
    }


}
