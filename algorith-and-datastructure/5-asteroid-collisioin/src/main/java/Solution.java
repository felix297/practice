import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> remainedAst = new Stack<>();
        int length = asteroids.length;

        remainedAst.push(asteroids[0]);

        // 遍历每一个行星
        for (int index = 1; index < length; index++) {
            int curr = asteroids[index];
            // 与栈顶的行星方向相同，则入栈
            if (hasSamePositivity(remainedAst.peek(), curr)) {
                remainedAst.push(curr);
            } else { // 方向相反则先比大小再确定是否入栈
                boolean isEqual = false;
                while (!remainedAst.empty() && !hasSamePositivity(remainedAst.peek(), curr) && Math.abs(curr) >= Math.abs(remainedAst.peek())) {
                    if (Math.abs(curr) == Math.abs(remainedAst.peek())) {
                        isEqual = true;
                    }

                    remainedAst.pop();
                }

                if (remainedAst.empty() && !isEqual) {
                    remainedAst.push(curr);
                }
            }
        }

        ArrayList<Integer> resArr = new ArrayList<>();
        while (!remainedAst.empty()) {
            resArr.add(remainedAst.pop());
        }

        int resArrLength = resArr.size();
        int[] res = new int[resArrLength];

        for (int index = 0; index < resArrLength; index++) {
            res[index] = resArr.get(resArrLength - index - 1);
        }

        return res;
    }

    public boolean hasSamePositivity (int number1, int number2) {
        return number1 * number2 >= 0;
    }
}