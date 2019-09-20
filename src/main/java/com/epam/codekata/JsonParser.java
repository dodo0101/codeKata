package com.epam.codekata;

import org.json.*;

import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonParser {
    static final String source = "C:\\Users\\Zstudent\\git\\codeKata\\src\\main\\resources\\PeriodicTableJSON.json";

    public static void main(String[] args) {
        JsonParser js = new JsonParser();
        List<Atom> list = null;
        List<Integer> random = js.getRandom();

        try (InputStream is = new FileInputStream(source)) {
            list =js.getListOfAtoms(is);
        } catch (IOException e) {
            System.err.println("OOOOOOPS");
        }

        for (Atom a : list) {
            String s = String.valueOf(a.getAtomic_mass());
            String[] array = (s).split("\\.");
            long number = Long.parseLong(array[1]);
            boolean norm = (number % 3 == 0 && number != 0);
            if (random.contains((int)a.getNumber()) && norm) {
                System.out.println(a.toString());
            }
        }

    }

    public List<Atom> getListOfAtoms(InputStream is) {

        JSONTokener token = new JSONTokener(is);
        JSONObject root = new JSONObject(token);

        List<Atom> result = new ArrayList<>();
        Object o = root.get("elements");
        JSONArray j = (JSONArray) o;

        for (Object obj : j){
            JSONObject jo = (JSONObject) obj;
            result.add(new Atom(jo.getString("name"), jo.getDouble("atomic_mass"), (byte)jo.getInt("number")));
        }

        return result;
    }

    public List<Integer> getRandom() {
        return Stream.generate(() -> (int) (Math.random() * 118))
                .limit(10)
                .collect(Collectors.toList());

    }
}
