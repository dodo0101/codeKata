package com.springtest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Quest {
    static final String source = "C:\\Users\\Fedor_Glushchenko\\git\\codeKata\\src\\main\\resources\\quest.json";

    public static void main(String[] args) {
        Quest q = new Quest();

        List<Question> list = null;

        try (InputStream in = new FileInputStream(source)) {
            list = q.getListOfQuestions(in);
        } catch (IOException e) {
            System.err.println("SORRY");
        }

        System.out.println(list.get(0).getVariant());
    }

    private List<Question> getListOfQuestions(InputStream is) {

        JSONTokener token = new JSONTokener(is);
        JSONObject root = new JSONObject(token);

        List<Question> result = new ArrayList<>();
        Object o = root.get("questions");
        JSONArray j = (JSONArray) o;

        for (Object obj : j) {
            JSONObject jo = (JSONObject) obj;

            String name = jo.getString("name");

            Map<String, String> map = new HashMap<>();
            map.put("A",  jo.getString("A")==null?);
            map.put("B",  jo.get("B"));
            map.put("C",  jo.get("C"));
            map.put("D",  jo.get("D"));
            map.put("E",  jo.get("E"));
            map.put("F",  jo.get("F"));



            Set<String> set = new HashSet<>();
            JSONArray arr = jo.getJSONArray("answer");
            for (Object o1 : arr.toList()) {
                set.add((String) o1);
            }

            result.add(new Question(name, map,set));
        }
        return result;
    }


}
