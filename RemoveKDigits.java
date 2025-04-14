// Time Complexity: O(n) where n is the length of the input string
// Space Complexity: O(n) for the stack

import java.util.Stack;

class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(num == null || k == 0){
            return num;
        }

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            int curr = num.charAt(i)-'0';
            while(!st.isEmpty() && st.peek() > curr && k > 0){
                st.pop();
                k--;
            }
            st.push(curr);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();

        while(!st.isEmpty()){
            //int poppedNumber = st.pop();
            res.append(st.pop());
        }
        res.reverse();

        String resStr = res.toString();

        int idx = 0;

        while (idx < resStr.length() && resStr.charAt(idx) == '0') {
            idx++;
        }

        String fRes = resStr.substring(idx);

        if(fRes.length() == 0){
            return "0";
        }

        return fRes;
    }
}