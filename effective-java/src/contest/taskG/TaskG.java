import java.io.FileReader;
import java.util.*;

public class TaskG {
    static final String input = "input.txt";
    static final String output = "output.txt";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new FileReader(input));
        int n = scanner.nextInt();
        Town[] towns = new Town[n];
        for (int i = 0; i < n; i++) {
            towns[i] = new Town(scanner.nextInt(), scanner.nextInt());
        }
        int capacity = scanner.nextInt();
        int from = scanner.nextInt() - 1;
        int to = scanner.nextInt() - 1;

        Queue<Town> queue = new LinkedList<>();
        queue.add(towns[from]);
        int minHops = findMinHops(towns, queue, to, capacity, 0);
        System.out.println(minHops);
    }

    private static int findMinHops(Town[] towns, Queue<Town> queue, int to, int capacity, int hops) {
        Queue<Town> target = new LinkedList<>();
        Town from = queue.poll();
        while (from != null) {
            from.visited = true;
            for (int i = 0; i < towns.length; i++) {
                Town next = towns[i];
                if (!next.visited) {
                    int distance = from.distance(next);
                    if (distance <= capacity) {
                        if (i == to) {
                            return hops + 1;
                        } else {
                            next.visited = true;
                            target.add(next);
                        }
                    }
                }
            }
            from = queue.poll();
        }
        if (target.isEmpty()) {
            return -1;
        }
        return findMinHops(towns, target, to, capacity, hops + 1);
    }

    private static class Town {
        int x;
        int y;
        boolean visited = false;

        public Town(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Town b) {
            return Math.abs(x - b.x) + Math.abs(y - b.y);
        }
    }
}
