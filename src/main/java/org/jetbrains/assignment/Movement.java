package org.jetbrains.assignment;

public record Movement(Direction direction, int steps) {
    public static Movement fromCoords(Coordinate current, Coordinate next) {
        if (current.x() == next.x()) {
            if (next.y() > current.y()) {
                return new Movement(Direction.NORTH, next.y() - current.y());
            } else {
                return new Movement(Direction.SOUTH, current.y() - next.y());
            }
        } else {
            if (next.x() > current.x()) {
                return new Movement(Direction.EAST, next.x() - current.x());
            } else {
                return new Movement(Direction.WEST, current.x() - next.x());
            }
        }
    }

    public Coordinate move(Coordinate start) {
        return switch (direction) {
            case EAST -> new Coordinate(start.x() + steps, start.y());
            case WEST -> new Coordinate(start.x() - steps, start.y());
            case NORTH -> new Coordinate(start.x(), start.y() + steps);
            case SOUTH -> new Coordinate(start.x(), start.y() - steps);
        };
    }
}
