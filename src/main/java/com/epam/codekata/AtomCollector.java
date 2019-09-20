package com.epam.codekata;

import com.sun.org.apache.regexp.internal.recompile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class AtomCollector implements Collector<Atom, Object, List<Atom>> {
    @Override
    public Supplier supplier() {
        return new Supplier() {
            @Override
            public Object get() {
                return null;
            }
        };
    }

    @Override
    public BiConsumer accumulator() {
        return new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {

            }
        };
    }

    @Override
    public BinaryOperator combiner() {
        return new BinaryOperator() {
            @Override
            public Object apply(Object o, Object o2) {
                return null;
            }
        };
    }

    @Override
    public Function finisher() {
        return new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }
}
