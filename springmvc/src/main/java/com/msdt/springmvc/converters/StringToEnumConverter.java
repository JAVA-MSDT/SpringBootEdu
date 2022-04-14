package com.msdt.springmvc.converters;

import com.msdt.springmvc.entity.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String source) {

        switch (source.toLowerCase()) {
            case "male":
                return Gender.MALE;
            case "female":
                return Gender.FEMALE;
            case "other":
                return Gender.OTHER;
            default:
                return null;
        }
    }
}
