package org.example.model;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CoordinateArguments {

  private static Stream<Arguments> coordinateExample() {
    return Stream.of(
        Arguments.of(
            new ComplexNumber(3.0, 2.0),
            new Coordinate(3.0, 2.0)
        ),
        Arguments.of(
            new ComplexNumber(0.0, 0.0),
            new Coordinate(0.0, 0.0)
        ),
        Arguments.of(
            new ComplexNumber(-1.0, -1.0),
            new Coordinate(-1.0, -1.0)
        )
    );
  }

  private static Stream<Arguments> panelCoordinateExample() {
    return Stream.of(
        Arguments.of(
            new PanelCoordinate(640, 240),
            800, 800, 2.0, 2.0,
            new Coordinate((3 / 5.0), (2 / 5.0))
        ),
        Arguments.of(
            new PanelCoordinate(400, 400),
            800, 800, 2.0, 2.0,
            new Coordinate(0.0, 0.0)
        ),
        Arguments.of(
            new PanelCoordinate(0, 0),
            800, 800, 2.0, 2.0,
            new Coordinate(-1.0, 1.0)
        ),
        Arguments.of(
            new PanelCoordinate(800, 800),
            800, 800, 2.0, 2.0,
            new Coordinate(1.0, -1.0)
        )
    );
  }
}
