package models;

public class ConversionRate {
    private String base;
    private String target;
    private double conversionRate;
    private double conversionResult;

    // Constructor
    public ConversionRate(String base, String target, int conversionRate, int conversionResult) {
        this.base = base;
        this.target = target;
        this.conversionRate = conversionRate;
        this.conversionResult = conversionResult;
    }

    public ConversionRate(ExchangeRateDto exchangeRateDto) {
        this.base = exchangeRateDto.baseCode();
        this.target = exchangeRateDto.targetCode();
        this.conversionRate = exchangeRateDto.conversionRate();
        this.conversionResult = exchangeRateDto.conversionResult();
    }

    // Getters
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTarget() {
        return target;
    }

    // Setters
    public void setTarget(String target) {
        this.target = target;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }
}
