package org.example.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Egységtesztek a Coordinate osztályhoz.
 * Ellenőrzi a átalakító konverziós módszerek helyességét.
 */
public class CoordinateTest {

  /**
   * Teszteli egy ComplexNumber konvertálását Coordinate objectummá.
   * @param c a konvertálandó komplex szám.
   * @param expected a várt koordináta.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.CoordinateArguments#coordinateExample")
  void parseCoordinateTest(ComplexNumber c, Coordinate expected) {
    assertThat(Coordinate.parseCoordinate(c)).isEqualTo(expected);
  }

  /**
   * Teszteli egy PanelCoordinate konverzióját Coordinate objectummá.
   * meghatározott szélességi, magassági és mértékegységek használatával.
   * @param panelCoordinate konvertálandó panel koordinátáját.
   * @param width a panel szélessége.
   * @param height a panel magassága.
   * @param unitX az X tengely mértékegysége.
   * @param unitY az Y tengely mértékegysége.
   * @param expected a várt koordináta.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.CoordinateArguments#panelCoordinateExample")
  void parseComplexNumberTest(PanelCoordinate panelCoordinate, int width, int height, double unitX, double unitY, Coordinate expected) {
    assertThat(Coordinate.parseCoordinate(panelCoordinate, width, height, unitX, unitY)).isEqualTo(expected);
  }
}