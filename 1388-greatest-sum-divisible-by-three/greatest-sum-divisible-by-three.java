class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int total = 0;
        for (int num : nums) {
            total += num;
            if (num % 3 == 1)
                l1.add(num);
            else if (num % 3 == 2)
                l2.add(num);
        }
        Collections.sort(l1);
        Collections.sort(l2);
        int rem = total % 3;
        int remove = Integer.MAX_VALUE;
        if (rem == 0)
            return total;
        else if (rem == 1) {
            int num1 = l1.size() > 0 ? l1.get(0) : Integer.MAX_VALUE;
            int num2 = l2.size() > 1 ? l2.get(0) + l2.get(1) : Integer.MAX_VALUE;
            remove = Math.min(num1, num2);
        } else {
            int num1 = l2.size() > 0 ? l2.get(0) : Integer.MAX_VALUE;
            int num2 = l1.size() > 1 ? l1.get(0) + l1.get(1) : Integer.MAX_VALUE;
            remove = Math.min(num1, num2);
        }
        return total - remove;
    }
}