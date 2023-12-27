import java.util.ArrayList;

public class Shape {
    private ArrayList<Point> points;

    public Shape() {
        this.points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        int numPoints = points.size();

        for (int i = 0; i < numPoints; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % numPoints);
            perimeter += currentPoint.distanceTo(nextPoint);
        }

        return perimeter;
    }

    public double getLongest() {
        double longestSide = 0;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());
            double currentDistance = currentPoint.distanceTo(nextPoint);

            if (currentDistance > longestSide) {
                longestSide = currentDistance;
            }
        }

        return longestSide;
    }

    public double getAverageSide() {
        double totalLength = 0;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());
            totalLength += currentPoint.distanceTo(nextPoint);
        }

        return totalLength / points.size();
    }
}

