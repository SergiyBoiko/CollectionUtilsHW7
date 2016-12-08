package com.geekhub.collections;

import java.util.*;
import java.util.function.*;



public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        //TODO Implement me
        List<E> resultList = new ArrayList<>();
        for(E list: elements) {
            if (!filter.equals(list)){
                resultList.add(list);
            }
        }
        return resultList;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        for(E list : elements) {
            if (predicate.equals(list)) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        for(E list : elements) {
            if (!predicate.equals(list)) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        for(E list : elements) {
            if (predicate.equals(list)) {
                return false;
            }
        }
        return true;
    }

    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        //TODO Implement me
        List<R> resultList = new ArrayList<>();
        for(T list : elements){
            resultList.add(mappingFunction.apply(list));
        }
        return resultList;
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        //TODO Implement me
        if (elements.isEmpty()) {
            return Optional.empty();
        }
        E maxElement = elements.get(0);
        for (int i = 1; i != elements.size(); i++) {
            if (comparator.compare(maxElement, elements.get(i)) > 0) {
                maxElement = maxElement;
            }else maxElement = elements.get(i);
        }
        return Optional.of(maxElement);
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        //TODO Implement me
        if (!elements.isEmpty()) {
            return Optional.empty();
        }
        E minElement = elements.get(0);
        for (int i = 1; i != elements.size(); i++) {
            if (comparator.compare(minElement, elements.get(i)) < 0) {
                minElement = minElement;
            }else minElement = elements.get(i);
        }
        return Optional.of(minElement);
    }

    public static <E> List<E> distinct(List<E> elements) {
        //TODO Implement me
        List<E> resultList = new ArrayList<>();
        for (E list : elements){
            if(!resultList.contains(list)){
                resultList.add(list);
            }
        }
        return resultList;
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        //TODO Implement me
        for(E list : elements){
            consumer.accept(list);
        }
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        //TODO Implement me
        if (!elements.isEmpty()) {
            E full = elements.get(0);
            for (int i = 0; i != elements.size(); i++) {
                full = accumulator.apply(full, elements.get(i));
            }
            return Optional.of(full);
        }
        return Optional.empty();
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        //TODO Implement me
        E full = seed;
        for (int i = 0; i != elements.size(); i++){
            full = accumulator.apply(full, elements.get(i));
        }
        return full;
    }

    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        Map<Boolean, List<E>> resultList = new HashMap<>();
        List<E> listElementsTrue = new ArrayList<E>();
        List<E> listElementsFalse = new ArrayList<E>();
        for(E list : elements){
            if(predicate.equals(list)){
                listElementsTrue.add(list);
            }else listElementsFalse.add(list);
        }
        resultList.put(true, listElementsTrue);
        resultList.put(false, listElementsFalse);

        return resultList;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        //TODO Implement me
        Map<K, List<T>> resultList = new HashMap<>();
        for (T list : elements) {
            K key = classifier.apply(list);
            if (resultList.containsKey(key)) {
                resultList.get(key).add(list);
            } else {
                List<T> newList = new ArrayList<>();
                newList.add(list);
                resultList.put(key,newList);
            }
        }
        return resultList;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {
        //TODO Implement me
        Map<K, U> resultList = new HashMap<>();
        K key;
        U values;
        for(T list : elements){
            key = keyFunction.apply(list);
            values = valueFunction.apply(list);
            if(resultList.containsKey(key)){
                resultList.put(key, mergeFunction.apply(resultList.get(key),values));
            } else resultList.put(key, values);
        }
        return resultList;
    }
}

