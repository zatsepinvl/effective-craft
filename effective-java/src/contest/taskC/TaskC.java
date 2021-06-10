package contest.taskC;

import java.io.*;

/**
 * Формат ввода
 * Первая строка входного файла содержит единственное число n, n ≤ 1000000.
 *
 * На следующих n строк расположены числа — элементы массива, по одному на строку. Числа отсортированы по неубыванию.
 *
 * Формат вывода
 * Выходной файл должен содержать следующие в порядке возрастания уникальные элементы входного массива.
 *
 * Пример 1
 * Ввод
 * 5
 * 2
 * 4
 * 8
 * 8
 * 8
 * Вывод
 * 2
 * 4
 * 8
 * Пример 2
 * Ввод
 * 5
 * 2
 * 2
 * 2
 * 8
 * 8
 * Вывод
 * 2
 * 8
 */
public class TaskC {
    static final byte MAX_INT_LENGTH = 12; //2147483648 + 1 for sign + 1 for \n
    static final String input = "input.txt";
    static final String output = "output.txt";

    static final char[] prev = new char[MAX_INT_LENGTH];
    static final char[] current = new char[MAX_INT_LENGTH];

    static BufferedReader reader;
    static BufferedWriter writer;

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(input));
        writer = new BufferedWriter(new FileWriter(output));

        int n = Integer.parseInt(reader.readLine());
        if (n == 0) {
            return;
        }
        read(reader, prev);
        write(writer, prev);
        for (int i = 1; i < n; i++) {
            read(reader, current);
            if (!equals(prev, current)) {
                copy(current, prev);
                write(writer, prev);
            }
        }
        reader.close();
        writer.close();
    }

    private static char[] read(BufferedReader reader, char[] number) throws IOException {
        int i = 0;
        for (int c = reader.read(); i < MAX_INT_LENGTH; c = reader.read(), i++) {
            number[i] = (char) c;
            if (c == '\n') break;
        }
        return number;
    }

    private static void write(BufferedWriter writer, char[] number) throws IOException {
        for (int i = 0; i < MAX_INT_LENGTH; i++) {
            writer.write(number[i]);
            if (number[i] == '\n') {
                break;
            }
        }
    }

    private static boolean equals(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private static char[] copy(char[] from, char[] to) {
        System.arraycopy(from, 0, to, 0, MAX_INT_LENGTH);
        return to;
    }
}