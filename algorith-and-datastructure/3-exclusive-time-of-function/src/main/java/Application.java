import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application{
    public static void main (String[] args){
        Solution solution = new Solution();
        String input = "[\"0:start:0\",\"1:start:5\",\"2:start:6\",\"3:start:9\",\"4:start:11\",\"5:start:12\",\"6:start:14\",\"7:start:15\",\"1:start:24\",\"1:end:29\",\"7:end:34\",\"6:end:37\",\"5:end:39\",\"4:end:40\",\"3:end:45\",\"0:start:49\",\"0:end:54\",\"5:start:55\",\"5:end:59\",\"4:start:63\",\"4:end:66\",\"2:start:69\",\"2:end:70\",\"2:start:74\",\"6:start:78\",\"0:start:79\",\"0:end:80\",\"6:end:85\",\"1:start:89\",\"1:end:93\",\"2:end:96\",\"2:end:100\",\"1:end:102\",\"2:start:105\",\"2:end:109\",\"0:end:114\"]";

        input = input.substring(1,input.length() - 1);

        // 按逗号分割字符串
        String[] elements = input.split("\",\"");

        // 创建 List 保存分割后的元素
        List<String> list = new ArrayList<>();

        // 将每个元素加入到 List 中
        for (String element : elements){
            list.add(element.replace("\"","")); // 去除每个元素的双引号
        }
        System.out.println(Arrays.toString(solution.exclusiveTime(8,list)));
    }
}