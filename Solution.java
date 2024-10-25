
import java.util.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class Solution {

    private static List<Point> parseJsonInput(String filePath) {
        List<Point> points = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            JSONObject json = new JSONObject(content);            

            for (String key : json.keySet()) {
                if (!key.equals("keys")) {
                    int x = Integer.parseInt(key);
                    JSONObject root = json.getJSONObject(key);
                    int base = Integer.parseInt(root.getString("base"));
                    String value = root.getString("value");
                    BigInteger y = new BigInteger(value, base);
                    points.add(new Point(BigInteger.valueOf(x), y));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return points;
    }

    private static BigInteger findConstantTerm(List<Point> points, int k) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < k; i++) {
            BigInteger term = points.get(i).y;
            BigInteger denom = BigInteger.ONE, numer = BigInteger.ONE;
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    numer = numer.multiply(points.get(j).x.negate());
                    denom = denom.multiply(points.get(i).x.subtract(points.get(j).x));
                }
            }
            term = term.multiply(numer).divide(denom);
            result = result.add(term);
        }
        return result;
    }

    public static void main(String[] args) {

        String path1 = "testcases/t1.json";
        String path2 = "testcases/t2.json";

        List<Point> points1 = parseJsonInput(path1);
        List<Point> points2 = parseJsonInput(path2);

        int k1 = points1.size();
        int k2 = points2.size();

        BigInteger c1 = findConstantTerm(points1, k1);
        BigInteger c2 = findConstantTerm(points2, k2);

        System.out.println("Secret for test case 1: " + c1);
        System.out.println("Secret for test case 2: " + c2);
    }
}

class Point {
    BigInteger x, y;

    Point(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }
}
