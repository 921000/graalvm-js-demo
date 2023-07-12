package cn.dgj.entity;

public class CalculationParam {
    private double a1;
    private double a2;
    private String formula;

    public CalculationParam(double a1, double a2, String formula) {
        this.a1 = a1;
        this.a2 = a2;
        this.formula = formula;
    }

    public CalculationParam() {
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}

