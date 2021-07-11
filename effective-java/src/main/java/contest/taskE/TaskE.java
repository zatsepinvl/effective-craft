package contest.taskE;

import java.util.*;
import java.io.*;

/**
 * Даны две строки, состоящие из строчных латинских букв. Требуется определить, являются ли эти строки анаграммами, т. е. отличаются ли они только порядком следования символов.
 *
 * Формат ввода
 * Входной файл содержит две строки строчных латинских символов, каждая не длиннее 100 000 символов. Строки разделяются символом перевода строки.
 *
 * Формат вывода
 * Выходной файл должен содержать единицу, если строки являются анаграммами, и ноль в противном случае.
 *
 * Пример 1
 * Ввод
 * qiu
 * iuq
 * Вывод
 * 1
 *
 * Пример 2
 * Ввод
 * zprl
 * zprc
 * Вывод
 * 0
 */
public class TaskE {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> mapA = readIntoMap(reader);
        Map<Character, Integer> mapB = readIntoMap(reader);

        if (mapA.equals(mapB)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        reader.close();
    }

    private static Map<Character, Integer> readIntoMap(BufferedReader reader) throws Exception {
        Map<Character, Integer> map = new HashMap();
        while (true) {
            char c = (char) reader.read();
            if (c == '\n') {
                return map;
            }
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
    }
}