import java.util.List;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;


public class HFractal extends JPanel {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int SPEED = 3;

    public void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    public void drawH(Graphics g, int size, int x, int y) {
        drawLine(g, x - size / 2, y, x + size / 2, y); // Horizontal line
        drawLine(g, x - size / 2, y - size / 2, x - size / 2, y + size / 2); // Left vertical line
        drawLine(g, x + size / 2, y - size / 2, x + size / 2, y + size / 2); // Right vertical line
    }

    public void drawHRecursive(Graphics g, int size, int x, int y, int depth) {
        if (depth == 0) {
            return;
        }
        drawH(g, size, x, y);
        int smallHSize = size / 2;
        drawHRecursive(g, smallHSize, x - smallHSize, y - smallHSize, depth - 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawHRecursive(g, 150, WIDTH / 4, HEIGHT / 4, 5);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("H Fractal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new HFractal());
            frame.setSize(WIDTH, HEIGHT);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}

public class Main {



    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int sumOfSquares(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * n + sumOfSquares(n - 1);
        }
    }

    public static double sumOfPowers(int n, int b) {
        if (n == 0) {
            return 0;
        }
        else {
            return Math.pow(b, n) + sumOfPowers(n - 1, b);
        }
    }

    public static int sumOfElements(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }
        else {
            return arr[n - 1] + sumOfElements(arr, n - 1);
        }
    }

    public static int maxOfElements(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        else {
            int mid = n / 2;
            int max1 = maxOfElements(arr, mid);
            int max2 = maxOfElements(arr, n - mid);
            return Math.max(max1, max2);
        }
    }

    public static int sumOfIntegers(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumOfIntegers(n - 1);
        }
    }

    public static Scanner sc = new Scanner(System.in);
    public static void reverseOrder(int n) {
        if (n == 0) {
            return;
        }
        int a = sc.nextInt();
        reverseOrder(n - 1);
        System.out.print(a + " ");
    }

    public static void reverseOrderStrings(int n) {
        if (n == 0) {
            return;
        }
        String a = sc.next();
        reverseOrderStrings(n - 1);
        System.out.print(a + " ");
    }



    public static void fillMatrix(int[][] matrix, int layer, int num, int n) {
        if (layer > n / 2) {
            return;
        }
        for (int i = layer; i < n - layer; i++) {
            matrix[layer][i] = num++;
        }
        for (int i = layer + 1; i < n - layer; i++) {
            matrix[i][n - layer - 1] = num++;
        }
        for (int i = n - layer - 2; i >= layer; i--) {
            matrix[n - layer - 1][i] = num++;
        }
        for (int i = n - layer - 2; i > layer; i--) {
            matrix[i][layer] = num++;
        }
        fillMatrix(matrix, layer + 1, num, n);
    }


    public static void generateSequences(List<Integer> sequence, int n, int k) {
        if (sequence.size() == n) {
            System.out.println(sequence);
        }
        else {
            for (int i = 1; i <= k; i++) {
                sequence.add(i);
                generateSequences(sequence, n, k);
                sequence.removeLast();
            }
        }
    }


    public static void permute(char[] str, int l) {
        if (l == str.length - 1) {
            System.out.println(String.valueOf(str));
        }
        else {
            for (int i = l; i < str.length; i++) {

                char temp = str[l];
                str[l] = str[i];
                str[i] = temp;

                permute(str, l + 1);

                temp = str[l];
                str[l] = str[i];
                str[i] = temp;
            }
        }
    }

    public static String isPowerOfTwo(int n) {
        if (n <= 0) {
            return "Is not power of two";
        }
        return (n & (n - 1)) == 0 ? "Is power of two" : "Is not power of two";
    }



    // Exercise lec 2  1.1)  O(N);
    // Exercise lec 2  1.2)  O(N^2);
    // Exercise lec 2  1.3)  O(N*M);


    public static void findPairs(int[] arr, int sum) { // O(N^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println(arr[i] + ", " + arr[j]);
                }
            }
        }
    }


    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        else if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        }
        else {
            return binarySearch(arr, target, mid + 1, end);
        }
    }




    public int getElement(int[] arr, int index) {
        return arr[index];
    }//O(1)

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }//O(N)

    public void printPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }//O(N^2)

    // O(Log(N))
    public int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // O(N^3)
    public void printTriplets(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
                }
            }
        }
    }

    //O(2^n)
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //O(N!)
    //permute function that i wrote above





    public static void main(String[] args) {

    }

}
