import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] fees = new int[N][M];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                fees[row][col] = scanner.nextInt();
            }
        }

        int X = scanner.nextInt();
        Node[] nodes = new Node[X];
        int res = 0;
        for (int index = 0; index < X; index++) {
            Node curr = new Node(scanner.nextInt() - 1, scanner.nextInt() - 1);
            res = res + Math.abs(fees[curr.x][curr.y] - (index > 0 ? fees[curr.x][nodes[index - 1].y] : 0));
            nodes[index] = curr;
        }

        System.out.println(res);
    }

    public static class Node {
        public int x;
        public int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}