public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1 ; i <= n ; i++) {
            boolean isThreeMultiple = i % 3 == 0;
            boolean isFiveMultiple = i % 5 == 0;
            String output = null;
            if (isThreeMultiple & isFiveMultiple) output = "FizzBuzz";
            else if (isThreeMultiple) output = "Fizz";
            else if (isFiveMultiple) output = "Buzz";
            else output = String.valueOf(i);
            result.add(output);
        }
        return result;
    }
}
