package com.flpkrt.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ZipCodeConvertor implements AttributeConverter<ZipCode,String>{
    @Override
    public String convertToDatabaseColumn(ZipCode attribute) {
        return attribute.getZipcode();
    }

    @Override
    public ZipCode convertToEntityAttribute(String dbData) {
        if(dbData.length()==5){
            return new ZipCode(dbData);
        }else if(dbData.length()==4){
            return new ZipCode(dbData);
        }
        return null;
    }
}
