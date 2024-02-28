package org.jetbrains.assignment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class Moves {
    @PostMapping("/moves")
    public List<Movement> moves(@RequestBody List<Coordinate> coordinates) {
        List<Movement> movements = new ArrayList<>();
        Iterator<Coordinate> coordinateIterator = coordinates.iterator();
        Coordinate current = coordinateIterator.next();
        while (coordinateIterator.hasNext()) {
            Coordinate next = coordinateIterator.next();
            Movement m = Movement.fromCoords(current, next);
            movements.add(m);
            current = next;
        }
        return movements;
    }
}
