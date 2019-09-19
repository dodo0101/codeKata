package com.epam.codekata;

import org.json.*;

import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    static final String source = "C:\\Users\\Zstudent\\git\\codeKata\\src\\main\\resources\\PeriodicTableJSON.json";

    public static void main(String[] args) {

        try(InputStream is = new FileInputStream(source)){
            getListOfAtoms(is);
        } catch (IOException e) {
            System.err.println("OOOOOOPS");
        }
    }

    public static List<Atom> getListOfAtoms(InputStream is) {

        JSONTokener tokener = new JSONTokener(is);
        JSONObject root = new JSONObject(tokener);

        List<Atom> result = new ArrayList<>();
        Object o = root.get("elements");
        JSONArray j = (JSONArray) o ;
        JSONObject jo = (JSONObject) j.get(0);

        System.out.println(jo.getDouble("atomic_mass"));
        System.out.println(root.get("elements"));
        return null;
    }
}
