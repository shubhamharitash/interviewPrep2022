package algorithms.divideAndConquer;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@ToString
@AllArgsConstructor
class Point {
    int x;
    int y;
}

@ToString
@AllArgsConstructor
class Result {
    Point p1;
    Point p2;
    double dist;
}

public class ClosestPairProblem {
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    public static Result bruteForce(Point[] points) {
        if (points.length == 2)
            return new Result(points[0], points[1], distance(points[0], points[1]));
        double dist1 = distance(points[0], points[1]);
        double dist2 = distance(points[1], points[2]);
        return dist1 < dist2 ? new Result(points[0], points[1], dist1) : new Result(points[1], points[2], dist2);
    }

    public static Result solveStrip(List<Point> points, Result leftRightRes) {
        Result res = leftRightRes;
        for (int i = 0; i < points.size() - 1; i++) {
            double dist = distance(points.get(i), points.get(i + 1));
            if (dist < res.dist)
                res = new Result(points.get(i), points.get(i + 1), dist);
        }
        return res;
    }

    public static void solve(Point[] points) {
        Point[] px = Arrays.copyOf(points, points.length);
        Arrays.sort(px, Comparator.comparingInt((Point p) -> p.x));
        Point[] py = Arrays.copyOf(points, points.length);
        Arrays.sort(py, Comparator.comparingInt((Point p) -> p.y));
        System.out.println(closestPair(px, py, px.length));
    }

    public static Result closestPair(Point[] px, Point[] py, int n) {
        if (px.length <= 3)
            return bruteForce(px);
        int mid = n / 2;
        Point midPointX = px[n / 2];
        List<Point> pyl = new ArrayList<>();
        List<Point> pyr = new ArrayList<>();
        Arrays.stream(py).forEach(e -> {
            if (e.x <= midPointX.x)
                pyl.add(e);
            else
                pyr.add(e);
        });
        Result closetPairLeftRes = closestPair(Arrays.copyOfRange(px, 0, mid), pyl.toArray(new Point[n / 2]), n / 2);
        Result closetPairRightRes = closestPair(Arrays.copyOfRange(px, mid, n), pyr.toArray(new Point[n / 2]), n - (n / 2));
        double d = Math.min(closetPairLeftRes.dist, closetPairRightRes.dist);
        Result leftRightRes = closetPairLeftRes.dist < closetPairRightRes.dist ? closetPairLeftRes : closetPairRightRes;
        List<Point> stripPoints = new ArrayList<>();
        Arrays.stream(py).filter(e -> Math.abs(e.x - midPointX.x) < d).forEach(stripPoints::add);
        return solveStrip(stripPoints, leftRightRes);
    }

    public static void main(String[] args) {
        Point[] P = {new Point(2, 3), new Point(12, 30), new Point(40, 50),
                new Point(5, 1), new Point(12, 10), new Point(3, 4)};
        solve(P);
    }
}
