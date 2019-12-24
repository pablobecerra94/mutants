package com.mutants.serializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mutants.constants.Constants;

public class DoubleSerializer extends JsonSerializer<Double> {

	@Override
	public void serialize(Double value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeNumber(new BigDecimal(value).setScale(Constants.AMOUNT_OF_DECIMALS, RoundingMode.HALF_UP));
	}
}
