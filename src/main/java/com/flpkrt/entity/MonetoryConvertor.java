package com.flpkrt.entity;

import javax.persistence.AttributeConverter;

public class MonetoryConvertor implements AttributeConverter<MonetoryAmount,String>{
    @Override
    public String convertToDatabaseColumn(MonetoryAmount attribute) {
        return attribute.toString();
    }

    @Override
    public MonetoryAmount convertToEntityAttribute(String dbData) {
        return MonetoryAmount.fromString(dbData);
    }
}
