package models;

import com.google.gson.annotations.SerializedName;

public record ExchangeRateDto(
        String baseCode,
        String targetCode,
        double conversionRate,
        double conversionResult) {
}
