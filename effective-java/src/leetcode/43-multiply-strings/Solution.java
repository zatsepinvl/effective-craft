
class Solution {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] number = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int bigger = i + j;
                int lesser = i + j + 1;
                int sum = mul + number[lesser];
                number[lesser] = sum % 10;
                number[bigger] += sum / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        int start = number[0] == 0 ? 1 : 0;
        for (int i = start; i < number.length; i++) {
            builder.append(number[i]);
        }
        return builder.toString();
    }
}