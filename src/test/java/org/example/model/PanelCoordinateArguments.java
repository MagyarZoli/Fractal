package org.example.model;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Tesztadatokat biztosít a következöhőz: {@link PanelCoordinateTest}.
 * Ez az osztály argumentumokat generál az átalakításainak teszteléséhez.
 */
public class PanelCoordinateArguments {

  /**
   * Példaadatokat ad a komplex szám konvertálás teszteléséhez.
   * @return Egy argumentumfolyam, ahol egy komplex szám,
   *         panel szélessége és magassága, x és y tengely méretarányának mértékegysége
   *         és egy várható panel koordinátátt tartalmazza.
   */
  private static Stream<Arguments> complexNumberExample() {
    return Stream.of(
        Arguments.of(
            new ComplexNumber((3 / 5.0), (2 / 5.0)),
            800, 800, 2.0, 2.0,
            new PanelCoordinate(640, 240)
        ),
        Arguments.of(
            new ComplexNumber(0.0, 0.0),
            800, 800, 2.0, 2.0,
            new PanelCoordinate(400, 400)
        ),
        Arguments.of(
            new ComplexNumber(-1.0, 1.0),
            800, 800, 2.0, 2.0,
            new PanelCoordinate(0, 0)
        ),
        Arguments.of(
            new ComplexNumber(1.0, -1.0),
            800, 800, 2.0, 2.0,
            new PanelCoordinate(800, 800)
        )
    );
  }

  /**
   * Példaadatokat ad a koordináta konvertálás teszteléséhez.
   * @return Egy argumentumfolyam, ahol egy koordináta,
   *         panel szélessége és magassága, x és y tengely méretarányának mértékegysége
   *         és egy várható panel koordinátátt tartalmazza.
   */
  private static Stream<Arguments> coordinateExample() {
    return Stream.of(
        Arguments.of(
            new Coordinate((3 / 5.0), (2 / 5.0)),
            800, 800, 2.0, 2.0,
            new PanelCoordinate(640, 240)
        ),
        Arguments.of(
            new Coordinate(0.0, 0.0),
            800, 800, 2.0, 2.0,
            new PanelCoordinate(400, 400)
        ),
        Arguments.of(
            new Coordinate(-1.0, 1.0),
            800, 800, 2.0, 2.0,
            new PanelCoordinate(0, 0)
        ),
        Arguments.of(
            new Coordinate(1.0, -1.0),
            800, 800, 2.0, 2.0,
            new PanelCoordinate(800, 800)
        )
    );
  }
}
