package contest.taskD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 ⋅ n, упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).
 *
 * В задаче используются только круглые скобки.
 *
 * Желательно получить решение, которое работает за время, пропорциональное общему количеству правильных скобочных последовательностей в ответе, и при этом использует объём памяти, пропорциональный n.
 *
 * Формат ввода
 * Единственная строка входного файла содержит целое число n, 0 ≤ n ≤ 11
 *
 * Формат вывода
 * Выходной файл содержит сгенерированные правильные скобочные последовательности, упорядоченные лексикографически.
 *
 * Пример 1
 * Ввод
 * 2
 * Вывод
 * (())
 * ()()
 * Пример 2
 * Ввод
 * 3
 * Вывод
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 */
public class TaskD {
	private static final String inputFile="input.txt";
	private static final String outputFile="output.txt";
	
	public static void main(String []args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		int n = Integer.parseInt(reader.readLine());
		char[] str = new char[n*2];
        generateStr(str, 0, 0, n, 0, writer);
		writer.close();
    }
     
 private static void generateStr(char[] str, int leftCount, int rightCount, int n, int i, BufferedWriter writer) throws Exception {
	 if(leftCount<n) {
		str[i] = '(';
		generateStr(str, leftCount + 1, rightCount, n, i + 1, writer);
	 }
	 if(rightCount<leftCount) {
		 str[i] = ')';
		 generateStr(str, leftCount, rightCount + 1, n, i + 1, writer);
	 }
	 if(leftCount == rightCount && leftCount == n) {
		 writer.write(str, 0, str.length);
		 writer.write("\n");
	 }
 }
}