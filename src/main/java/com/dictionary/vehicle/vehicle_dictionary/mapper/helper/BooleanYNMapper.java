package com.dictionary.vehicle.vehicle_dictionary.mapper.helper;

import org.springframework.stereotype.Component;

@Component
public class BooleanYNMapper {
    public String asString(Boolean bool) {
        return null == bool ?
                null : (bool ?
                "Есть прицеп" : "Нет прицепа"
        );
    }

    public Boolean asBoolean(String bool) {
        return null == bool ?
                null : (bool.equals("Есть прицеп") ?
                Boolean.TRUE : Boolean.FALSE
        );
    }
}
