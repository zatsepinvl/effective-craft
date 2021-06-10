package interview.yandex;

public class Task1 {

    public static void main(String[] args) {
        String input1 = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        String input2 = "A";
        String input3 = "AABC";
        String input4 = "AABCDD";
        System.out.println(rle(input1));
        System.out.println(rle(input2));
        System.out.println(rle(input3));
        System.out.println(rle(input4));
    }

    /**
     * Дана строка, состоящая из букв A-Z:
     * "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"
     * Нужно написать функцию RLE, которая на выходе даст строку вида:
     * "A4B3C2XYZD4E3F3A6B28"
     * И сгенерирует любую ошибку, если на вход пришла невалидная строка.
     * <p>
     * Пояснения:
     * 1. Если символ встречается 1 раз, он остается без изменений
     * 2. Если символ повторяется более 1 раза, к нему добавляется количество повторений
     */
    public static String rle(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str.length() == 0) {
            return "";
        }
        char mainChar = str.charAt(0);
        char currentChar = mainChar;
        if (currentChar < 'A' || currentChar > 'Z') {
            throw new IllegalArgumentException("error....");
        }
        int counter = 1;
        for (int i = 1; i < str.length(); i++) {
            currentChar = str.charAt(i);
            if (currentChar < 'A' || currentChar > 'Z') {
                throw new IllegalArgumentException("error....");
            }
            if (currentChar != mainChar) {
                stringBuilder.append(mainChar);
                if (counter > 1) {
                    stringBuilder.append(counter);
                }
                mainChar = currentChar;
                counter = 1;
            } else {
                counter++;
            }
        }
        stringBuilder.append(currentChar);
        if (counter > 1) {
            stringBuilder.append(counter);
        }
        return stringBuilder.toString();
    }
}
