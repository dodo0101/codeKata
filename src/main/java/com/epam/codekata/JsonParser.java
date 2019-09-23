package com.epam.codekata;

import org.json.*;

import org.json.JSONTokener;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class JsonParser {
    static final String source = "C:\\Users\\Fedor\\git\\codeKata\\src\\main\\resources\\PeriodicTableJSON.json";

    public static void main(String[] args) {
        oldParse();
    }

    public static <T, R> Stream<R> pairMap(Stream<T> stream, BiFunction<T, T, R> mapper) {
        return StreamSupport.stream(new AtomsSpliterator<>(mapper, stream.spliterator()), stream.isParallel()).onClose(stream::close);
    }

    public static void oldParse() {
        JsonParser js = new JsonParser();
        List<Atom> list = null;
        List<Integer> random = js.getRandom();

        try (InputStream is = new FileInputStream(source)) {
            list = js.getListOfAtoms(is);
        } catch (IOException e) {
            System.err.println("OOOOOOPS");
        }

        for (Atom a : list) {
            String s = String.valueOf(a.getAtomic_mass());
            String[] array = (s).split("\\.");
            long number = Long.parseLong(array[1]);
            boolean norm = (number % 3 == 0 && number != 0);
            if (random.contains((int) a.getNumber()) && norm) {
                System.out.println(a.toString());
            }
        }
    }

    private List<Atom> getListOfAtoms(InputStream is) {

        JSONTokener token = new JSONTokener(is);
        JSONObject root = new JSONObject(token);

        List<Atom> result = new ArrayList<>();
        Object o = root.get("elements");
        JSONArray j = (JSONArray) o;

        for (Object obj : j) {
            JSONObject jo = (JSONObject) obj;
            result.add(new Atom(jo.getString("name"), jo.getDouble("atomic_mass"), (byte) jo.getInt("number")));
        }

        return result;
    }

    private List<Integer> getRandom() {
        return Stream.generate(() -> (int) (Math.random() * 118))
                .limit(10)
                .collect(Collectors.toList());

    }
}
