package com.epam.codekata;

import org.json.*;

import org.json.JSONTokener;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class JsonParser {
    static final String source = "C:\\Users\\Zstudent\\git\\codeKata\\src\\main\\resources\\PeriodicTableJSON.json";

    public static void main(String[] args) {
        List<Atom> list = oldParse();
        System.out.println(list);
        System.out.println();
        pairMap(list.stream(), (a, b) -> a.getAtomic_mass() + b.getAtomic_mass()).forEach(System.out::println);
    }

    public static List<Atom> oldParse() {
        JsonParser js = new JsonParser();
        List<Atom> list = null;
        List<Integer> random = js.getRandom();
        List<Atom> result = new ArrayList<>();

        try (InputStream is = new FileInputStream(source)) {
            list = js.getListOfAtoms(is);
        } catch (IOException e) {
            System.err.println("OOOOOOPS");
        }
        for (Atom a : list) {
            String s = String.valueOf(a.getAtomic_mass());
            String[] array = (s).split("\\.");
            long number = Long.parseLong(array[1]);
            boolean norm = (number != 0);
            if (random.contains((int) a.getNumber()) && norm) {
                result.add(a);
            }
        }
        return result;
    }

    public void kek(){
        List<Atom> list = oldParse();
        System.out.println("Source" + list);

        Spliterator<Atom> spliterator = list.spliterator();
        Spliterator<Atom> firstHalf = spliterator.trySplit();
        System.out.println();

        for (; firstHalf.tryAdvance(System.out::println) != false; ) {
        }
        System.out.println();
        for (; spliterator.tryAdvance(System.out::println) != false; ) {
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

    public static <T, R> Stream<R> pairMap(Stream<T> stream, BiFunction<T, T, R> mapper) {
        return StreamSupport.stream(new AtomsSpliterator<T, R>(mapper, stream.spliterator()),
                stream
                        .isParallel())
                .onClose(stream::close);
    }

}
