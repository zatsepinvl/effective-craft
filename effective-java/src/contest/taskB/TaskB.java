package contest.taskB;

import java.util.Scanner;

/**
 * Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
 *
 * Желательно получить решение, работающее за линейное время и при этом проходящее по входному массиву только один раз.
 *
 * Формат ввода
 * Первая строка входного файла содержит одно число n, n ≤ 10000. Каждая из следующих n строк содержит ровно одно число — очередной элемент массива.
 *
 * Формат вывода
 * Выходной файл должен содержать единственное число — длину самой длинной последовательности единиц во входном массиве.
 *
 * Пример
 * Ввод
 * 5
 * 1
 * 0
 * 1
 * 0
 * 1
 * Вывод
 * 1
 */
public class TaskB {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 0;
        int current = 0;
        int currentMax = 0;
        for (int i = 0; i < n; i++) {
            current = scanner.nextInt();
            if (current == 1) {
                currentMax++;
            } else {
                currentMax = 0;
            }
            if (currentMax > max) {
                max = currentMax;
            }
        }
        System.out.println(max);
    }
}
