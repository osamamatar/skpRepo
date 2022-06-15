package com.osama.skp.util;

import com.osama.skp.exceptions.AbstractGlopalException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class MapperUtil {

    private final static ModelMapper modelMapper = new ModelMapper();
    public static Object mapEntityDTO(Object object, Class targetClass) {
        try {
            if(object != null) {
                modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
                return modelMapper.map(object, targetClass);
            }
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to map object of type: " + object.getClass().getName() + " to its class: " + targetClass.getName());
        }
    }
}
