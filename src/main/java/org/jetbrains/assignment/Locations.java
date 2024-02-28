package org.jetbrains.assignment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Locations {

    @PostMapping("/locations")
    public List<Coordinate> locations(@RequestBody List<Movement> directions) {
        List<Coordinate> coordinates = new ArrayList<>(List.of(new Coordinate(0, 0)));
        var currentLoc = coordinates.get(0);
        for (Movement direction: directions) {
            var newLoc = direction.move(currentLoc);
            coordinates.add(newLoc);
            currentLoc = newLoc;
        }
        return coordinates;
    }
}
