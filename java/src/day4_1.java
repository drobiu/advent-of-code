public class day4_1 {
    public static void main(String[] args) {
        int count = 0;

        for (int i = 273025; i <= 767253; i++) {
            int num = i;
            int[] digits = new int[6];
            int j = 0;
            while (num > 0) {
                digits[j] = num % 10;
                num /= 10;
                j++;
            }
            boolean doubled = false;
            boolean increasing = true;
            for (int k = digits.length - 1; k > 0; k--) {
                if (digits[k] == digits[k - 1])
                    doubled = true;
                if (digits[k] > digits[k - 1])
                    increasing = false;
            }
            if (doubled && increasing)
                count++;
        }
        System.out.println(count);
    }
}
