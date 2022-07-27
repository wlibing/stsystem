package com.example.studteath.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static <T, U> List<U> convert(List<T> in, Class<U> type) {
        List<U> out = new ArrayList<U>();
        try {
            for (T t : in) {
                U u = type.newInstance();
                BeanUtils.copyProperties(u, t);
                out.add(u);
            }
        } catch (InstantiationException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }

        return out;
    }
}
