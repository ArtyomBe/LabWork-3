package coordinates;

import coordinates.exceptions.LocationWithThoseCoordinatesAlreadyExistException;
import coordinates.exceptions.ObjectAlreadyExistInMapException;
import coordinates.exceptions.ObjectDoesNotExistInMapException;

import java.util.HashMap;
import java.util.Objects;

public class CoordinatesMap<T> {
    HashMap<T, Point> objectsMap = new HashMap<>();
    HashMap<Point, Location> locationMap = new HashMap<>();

    public void addLocation(Location location){
        Point locationCoordinates = location.coordinates();
        if (locationMap.get(locationCoordinates) != null) throw new LocationWithThoseCoordinatesAlreadyExistException(
                String.format("Точка с такими координатами уже существует."));
        locationMap.put(locationCoordinates, location);
    }

    public String getLocationName(Point coordinates){
        Location location = locationMap.get(coordinates);
        if (location == null) return null;
        return location.name();
    }

    public void addObject(T object, Point point) {
        if (objectsMap.putIfAbsent(object, point) != null) { throw new ObjectAlreadyExistInMapException(
                String.format("Объект был на карте был создан ранее. "));
        }
    }

    public Point getCoordinates(T object){
        Point coordinates = objectsMap.get(object);
        return coordinates;
    }

    public int getX(T object){
        return getCoordinates(object).x();
    }
    public int getY(T object){
        return getCoordinates(object).y();
    }

    public void moveTo(T object, Point point) {
        while (point.equals(getCoordinates(object))) {
            if (getX(object) < point.x()) {
                objectsMap.replace(object, new Point(getX(object) + 1, getY(object)));
                } else if (getX(object) > point.x()) {
                objectsMap.replace(object, new Point(getX(object) - 1, getY(object)));
            } else if (getX(object) < point.y()) {
                objectsMap.replace(object, new Point(getX(object), getY(object) + 1));
            } else if (getX(object) > point.y()) {
                objectsMap.replace(object, new Point(getX(object), getY(object) - 1));
            }
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(objectsMap, locationMap);
    }
}
