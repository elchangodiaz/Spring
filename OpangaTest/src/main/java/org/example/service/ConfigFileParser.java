package org.example.service;


import org.apache.commons.lang3.StringUtils;
import org.example.model.RuntimeDataStructure;
import org.example.model.Section;

import java.util.*;

public class ConfigFileParser{
	
	public void validateFile(String file) throws Exception {
		long bracketsOpen = file.codePoints().filter(value -> value == '{').count();
		long bracketsClose = file.codePoints().filter(value -> value == '}').count();
		
		if(bracketsClose!=bracketsOpen) {
			throw new Exception("Error, File format is incorrect");
		}
		
		//ADD Validations
		
	}

    public HashMap<String, Integer> getSections(String in) {

        int i=0;
        int b;
        long brackets = in.codePoints().filter(value -> value == '{').count();
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        List<Map<String, String>> keyMapList = new ArrayList<>();
        List<String> flagList = new ArrayList<>();

        List<String> file = Arrays.asList(in.split("[\\n]"));

        for(String s:file){
            //System.out.println(s);
            if(s.contains("{")){
                map.put(s.replace("{",""),count);
                count++;
            }
            if(s.contains("}")){
                count--;
            }
            if(!s.contains("{") && !s.contains("}")){
            	Map<String, String> mapValid = new HashMap<String, String>();
            	mapValid = getKeys(s);
            	if(!getFlags(s).isBlank()) {
            		flagList.add(s);
            	}
            	if(!mapValid.isEmpty())
            		keyMapList.add(mapValid);    
            }
        }
        System.out.println(map);
        System.out.println(keyMapList);
        System.out.println(flagList);
        return map;
    }

    public Map<String, String> getKeys(String s) {
        int x = 0;
        List<String> keyValList = new ArrayList<>();
        HashMap<String, String> keyVal = new HashMap<>();
        List<String> keys = Arrays.asList(s.trim().split("\\s+"));
        String key;
        String values;
        if(keys.size()>1) {
	        for(int i =0; i<keys.size();i++){
	        	if(StringUtils.isAlphanumeric(keys.get(i))){
	        		keyValList.add(keys.get(i));
	        	}
	        }
	    		key = keyValList.get(0);
	    		keyValList.remove(0);
	    		values = StringUtils.join(keyValList, " ");
	    		if(!key.isBlank() && !values.isBlank()) {
	    			keyVal.put(key, values);
	        }
        }
        return keyVal;
    }

    public String getFlags(String in) {
    	List<String> input = Arrays.asList(in.trim().split("\\s+"));
    	String flag = " ";
    	if(input.size()==1) {
	        for(int i =0; i<input.size();i++){
	        	if(StringUtils.isAlphanumeric(input.get(i))){
	        		flag = in;
	        	}
	        }
    	}
    	return flag;
	}
}
