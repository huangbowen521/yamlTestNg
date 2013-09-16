package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public List<String> getSubType(String type) {
        List<String> subTypes = new ArrayList<String>();
        subTypes.add(type+"sub1");
        subTypes.add(type+"sub2");
        return subTypes;
    }
}
