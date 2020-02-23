package com.thoughtworks;

import java.util.Map;

public class RepositoryUtil {
    public static <E> void printList(Map<String, E> list) {
        for (String key: list.keySet()) {
            System.out.println(list.get(key));
        }
    }
}
