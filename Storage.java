package com.telran.org.homework_23;

import java.util.HashMap;
import java.util.Map;

public class Storage <T>{

    private Map <T, Integer> elements;


    public Storage() {
        elements = new HashMap<>();
    }

    public void addElement(T element){
        elements.put(element, elements.getOrDefault(element, 0) +1);
    }

    public Map<T, Integer> getElements(){
        return elements;
    }
}
