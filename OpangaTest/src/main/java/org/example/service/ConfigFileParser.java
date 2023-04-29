package org.example.service;


import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.example.model.Person;
import org.example.model.RuntimeDataStructure;
import org.example.model.Section;

import java.util.*;
import java.util.stream.Collectors;

public class ConfigFileParser{



    public HashMap<String, Integer> getSections(String in) {

        int i=0;
        int b;
        long brackets = in.codePoints().filter(value -> value == '{').count();
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();

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
                getKeys(s);
            }
        }
        System.out.println(map);
        return map;


        Person person = new Person("Javi", 22);

        Map<String, String> map2 = new HashMap<>();

        List<Person> persons = new ArrayList<>();
        persons.add(person);

        map.put(persons.stream().collect(Collectors.groupingBy(Person::getName)));
    }

    public Map<String, String> getKeys(String s) {



    }
}






        //List<String> file = Arrays.asList(in.split("[\\n]"));
//        in = in.replaceAll("\\n\\s|\\r|\\n|\\s\\s", "");
//        RuntimeDataStructure dataStructure = new RuntimeDataStructure();
//        Stack<String> strings = new Stack<>();
//
//        count = in.codePoints().filter(value -> value == '{').count();
//
//        for(int i=0; i<count; i++){
//            a = in.indexOf("{");
//            b = in.lastIndexOf("}");
//
//            if(i==0) {
//                strings.push(in.substring(0,a));
//            }
//            in = in.substring(a+1, b);
//            strings.push(in);
//            //System.out.println(in);
//        }
//
//        for(String s:strings) {
//            if(s.trim().isEmpty()){
//                dataStructure.setStructure(s);
//            }else{
//                dataStructure.setSection();
//            }
//        }

        //System.out.println(in);

////        dataStructure.setStructure(in.substring(0,a));
////        dataStructure.setSection(new Section());
//
//        System.out.println(dataStructure);


//        in = in.replaceAll("\\n\\s|\\r|\\n|\\s\\s", "");
//        System.out.println(in);
//        Stack<String> dataStructure = new Stack<>();
//
//        dataStructure.push(StringUtils.substringBefore(in, "{"));
//
//        for(String s:dataStructure) {
//            System.out.println(s);
//        }

        //List<String> file = Arrays.asList(in.split("[\\n]"));
        //List<String> sections = new ArrayList<>();
        //RuntimeDataStructure dataStructure = new RuntimeDataStructure();

//        for (String s:file) {
//            System.out.println(s);
//            //            if(s.contains("\\{")){
////                dataStructure.setStructure(StringUtils.substringBefore(s, "\\{"));
////            }
////            if(s.contains())
//        }


//        file = file.replaceAll("\\n\\s|\\r|\\n|\\s\\s", "");
//        //System.out.println(file);
//        List<String> sections = Arrays.asList(file.split("[\\{]"));
//        RuntimeStructure runtimeStructure = new RuntimeStructure();
//
//        for (String s:sections) {
//            System.out.println(s);
//            if(countWords(s)==1){
//                runtimeStructure.setSection(s);
//                break;
//            }
//            if(countWords(s)>1){
//
//            }
//        }
//
//        System.out.println(runtimeStructure);
//        return true;


/*
        RuntimeDataStructure rs = new RuntimeDataStructure();
        rs.setStructure(StringUtils.);
        rs.setStructure(StringUtils.substringBetween(file, "{", "}"));
 */