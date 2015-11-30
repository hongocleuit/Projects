package main;

import java.util.LinkedList;
import java.util.Queue;

public class FindIsland {

    public static int findNumberIsland(int matrix[][]) {
        int count = 0;
        Queue<CompositeKey> map = new LinkedList<CompositeKey>();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == 1) map.add(new CompositeKey(i, j));
            }
        while (!map.isEmpty()) {
            CompositeKey key = map.poll();
            Queue<CompositeKey> queue = new LinkedList<CompositeKey>();
            queue.add(key);
            while (!queue.isEmpty()) {
                CompositeKey currentKey = queue.poll();
                checkAroundThisPoint(currentKey, queue, map);
            }
            count++;
        }
        return count;
    }

    public static void checkAroundThisPoint(CompositeKey key, Queue queue, Queue map)
    {
        if (map.contains(key)) {
            map.remove(key);
        }
        int x = key.getX();
        int y = key.getY();
        addToQueue(x - 1, y, queue, map); // TRAI
        addToQueue(x + 1, y, queue, map); // PHAI
        addToQueue(x, y - 1, queue, map); // TREN
        addToQueue(x, y + 1, queue, map); // DUOI
        addToQueue(x + 1, y - 1, queue, map); // TREN TRAI
        addToQueue(x - 1, y - 1, queue, map); // TREN PHAI
        addToQueue(x + 1, y + 1, queue, map); // DUOI TRAI
        addToQueue(x + 1, y + 1, queue, map); // DUOI PHAI

    }

    public static void addToQueue(int x, int y, Queue queue, Queue map) {
        CompositeKey key = new CompositeKey(x, y);
        if (map.contains(key)) queue.add(key);
    }

    public static class CompositeKey {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public CompositeKey(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CompositeKey that = (CompositeKey) o;

            if (x != that.x) return false;
            return y == that.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args) {

        int[][] matrix =   {{1, 1, 0, 0, 0,1},
                            {0, 1, 0, 0, 1,1},
                            {1, 0, 0, 1, 1,1},
                            {0, 0, 0, 0, 0,1},
                            {1, 0, 1, 0, 1,1}};
        System.out.println(findNumberIsland(matrix));


    }

}

