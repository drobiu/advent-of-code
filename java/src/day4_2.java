import java.util.ArrayList;

public class day4_2 {
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
                if (digits[k] > digits[k - 1])
                    increasing = false;
            }

            ArrayList<Integer> dig = new ArrayList<>();
            for (int h = 0; h < digits.length; h++) {
                dig.add(digits[h]);
            }

            for (int k = dig.size() - 1; k > 1; k--) {
                if (dig.get(k) == dig.get(k-1) && dig.get(k-2) == dig.get(k-1)) {
                    dig.remove(k);
                    dig.remove(k-1);
                    dig.remove(k-2);
                    break;
                }
            }

            for (int k = dig.size() - 1; k > 1; k--) {
                if (dig.get(k) == dig.get(k-1) && dig.get(k-2) == dig.get(k-1)) {
                    dig.remove(k);
                    dig.remove(k-1);
                    dig.remove(k-2);
                    break;
                }
            }

            for (int k = dig.size() - 1; k > 2; k--) {
                if (dig.get(k) == dig.get(k-1) && dig.get(k-2) == dig.get(k-1) && dig.get(k-3) == dig.get(k-2)) {
                    dig.remove(k);
                    dig.remove(k-1);
                    dig.remove(k-2);
                    dig.remove(k-3);
                    break;
                }
            }

            for (int k = dig.size() - 1; k > 0; k--) {
                if (dig.get(k) == dig.get(k-1))
                    doubled = true;
            }

            for (int k = digits.length - 1; k > 3; k--) {
                if (digits[k] == digits[k - 1] && digits[k - 2] == digits[k - 1] && digits[k - 3] == digits[k - 1] && digits[k - 4] == digits[k - 1])
                    doubled = false;
            }

            if (digits[4] == digits[5] && digits[4] == digits[3] && digits[2] == digits[1] && digits[0] == digits[5] && digits[3] == digits[2])
                doubled = false;

            if (doubled && increasing)
                count++;
        }
        System.out.println(count);
    }
}
