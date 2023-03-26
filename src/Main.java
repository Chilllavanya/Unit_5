import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 6, 5, 7, 10, 9};
        String[] strArray = {"bob","soon","word","sentence"};
        
        System.out.println(FindMissingNum.findMissingNum(arr, 10));
        System.out.println(BalancedBrackets.hasBalancedParentheses("(((((((())))))))"));
        System.out.println(BalancedBrackets.hasBalancedBrackets("{((((()))))}"));
        System.out.println(recursionSearch("word", strArray));

    }

    public static int recursionSearch(String word, String[] strArray)
    {
        return recursionSearch(word, strArray, 0);
    }

    public static int recursionSearch(String word, String[] strArray, int currentIndex)
    {
        if (currentIndex == strArray.length)
            return -1;
        else if (strArray[currentIndex] == word)
            return currentIndex;
        else
            return recursionSearch(word, strArray, currentIndex+1);
    }
}

class FindMissingNum {
    public static int findMissingNum(int[] arr, int maxNum) 
    {
        /**
         * sort
         * missing num forloop(upto maxnum)
         */

        Arrays.sort(arr);
        if (arr.length==maxNum)
        {
            return 0;
        }

        for (int i=0; i<maxNum; i++)
        {
            if (i == arr.length || arr[i]-1 != i)
            {
                return i+1;
            }
        }
        return 0;
    }
}

class BalancedBrackets {
    public static boolean hasBalancedParentheses(String str)
    {
        /**
         * count "("
         * count ")"
         */
        int openCount = 0;
        int closeCount = 0;
        for (int i=0; i<str.length(); i++)
        {
            if (str.charAt(i)== '(')
            {
                openCount++;
            }
            else if (str.charAt(i)== ')')
            {
                closeCount++;
            }
        }
        if (openCount == closeCount)
            return true;
        else
            return false;
    }

    public static boolean hasBalancedBrackets(String str)
    {
        Stack st=new Stack();
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();

        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');
        bracketPairs.put('>', '<');

        for (int i=0; i<str.length(); i++)
        {
            if (bracketPairs.containsValue(str.charAt(i)))
                st.push(str.charAt(i));
            else if (bracketPairs.containsKey(str.charAt(i)))
            {
                if (st.lastElement()==bracketPairs.get(str.charAt(i)))
                    st.pop();
                else
                    return false;
            }
                
        }
        return st.isEmpty();
    }
}

class Stack {
    private char[] stack;
    private int end=0;
    
    public Stack(int size) {
        generate(size);
    }

    public Stack() {
        generate(10);
    }

    private void generate(int size) {
        char[] temp = new char[size];

        if (stack == null) {
            stack = temp;
            return;
        }

        for (int i=0; i < size; i++) {
            if (i < stack.length)
                temp[i] = stack[i];
            else
                temp[i] = 0;
        }
        stack = temp;
    }

    public void push(char c) {
        if (end == stack.length-1)
        {
            generate(stack.length*2);
        }

        end++;
        stack[end] = c;
    }

    public void pop() {
        stack[end] = 0;
        end--;
    }

    public char lastElement() {
        return stack[end];
    }
    
    public boolean isEmpty() {
        return end == 0;
    }

}