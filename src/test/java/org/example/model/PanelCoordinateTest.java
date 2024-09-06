package org.example.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Egységtesztek a PanelCoordinate osztályhoz.
 * Teszteli az objektumok konverzióját,
 * különböző panelméretek és egységméretezési tényezők használatával.
 */
public class PanelCoordinateTest {

  /**
   * Teszteli egy ComplexNumber konverzióját PanelCoordinate -vé.
   * @param c A konvertálandó komplex szám.
   * @param width A panel szélessége.
   * @param height A panel magassága.
   * @param unitX Az X tengely mértékegysége.
   * @param unitY Az Y tengely mértékegysége
   * @param expected a várt panel koordináta.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.PanelCoordinateArguments#complexNumberExample")
  void parseCoordinateTest(ComplexNumber c, int width, int height, double unitX, double unitY, PanelCoordinate expected) {
    assertThat(PanelCoordinate.parsePanelCoordinate(c, width, height, unitX, unitY)).isEqualTo(expected);
  }

  /**
   * Teszteli egy Coordinate konverzióját PanelCoordinate -vé.
   * @param coordinate A konvertálandó koordináta.
   * @param width A panel szélessége.
   * @param height A panel magassága.
   * @param unitX Az X tengely mértékegysége.
   * @param unitY Az Y tengely mértékegysége
   * @param expected a várt panel koordináta.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.PanelCoordinateArguments#coordinateExample")
  void parseComplexNumberTest(Coordinate coordinate, int width, int height, double unitX, double unitY, PanelCoordinate expected) {
    assertThat(PanelCoordinate.parsePanelCoordinate(coordinate, width, height, unitX, unitY)).isEqualTo(expected);
  }
}