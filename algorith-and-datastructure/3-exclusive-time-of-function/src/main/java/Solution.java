import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        int length = logs.size();
        Stack<Integer> runningStack = new Stack<>();
        int lastTaskDuration = 0;
        boolean needSub = true;
        boolean isSameLevel = false;
        for (int index = 0; index < length; index++) {
            String[] json = logs.get(index).split(":");

            if (json[1].equals("start")) {
                runningStack.push(Integer.valueOf(json[2]));
                needSub = false;
                isSameLevel = true;
            } else {
                int currTaskDuration = Integer.valueOf(json[2]) - runningStack.pop() + 1;
                needSub = true;
                isSameLevel = false;
                res[Integer.valueOf(json[0])] = res[Integer.valueOf(json[0])] + currTaskDuration - (needSub ? lastTaskDuration : 0);

                if (!runningStack.empty()) {
                    lastTaskDuration = isSameLevel? lastTaskDuration + currTaskDuration: currTaskDuration;
                } else {
                    res[Integer.valueOf(json[0])] = res[Integer.valueOf(json[0])] - lastTaskDuration;
                }
            }
        }

        return res;
    }
}