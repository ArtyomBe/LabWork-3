package coordinates;

import coordinates.exceptions.CoordinateOverMapException;

public record Point(int x, int y) {
    public Point {
        if ((-100 > x || x > 100) || (-100 > y || y > 100)) throw new CoordinateOverMapException(
                "Координаты не соответствуют введённым пределам"
        );
    }
}
