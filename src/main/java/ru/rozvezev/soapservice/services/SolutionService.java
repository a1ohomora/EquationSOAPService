package ru.rozvezev.soapservice.services;

import org.springframework.stereotype.Service;
import ru.rozvezev.ns.Solution;
import ru.rozvezev.soapservice.util.NegativeDiscriminantException;

@Service
public class SolutionService {

    public SolutionService() {
    }

    /**
     * Quadratic equation of the form a*x^2 + b*x + c = 0
     */
    public Solution solveQuadraticEquation(double a, double b, double c) throws NegativeDiscriminantException {
        String formula = a + "x^2 + " + b + "x + " + c + " = 0";
        double D = Math.round((b * b - 4 * a * c) * 10000) / 10000.0; //rounding to 4 decimal places

        if (D < 0)
            throw new NegativeDiscriminantException(formula, D);

        double x1 = (-b + Math.sqrt(D)) / (2.0 * a); x1 = Math.round(x1 * 10000) / 10000.0;
        double x2 = (-b - Math.sqrt(D)) / (2.0 * a); x2 = Math.round(x2 * 10000) / 10000.0;

        Solution solution = new Solution();
        solution.setFormula(formula);
        solution.setD(D);
        solution.setX1(x1);
        solution.setX2(x2);
        return solution;
    }
}
