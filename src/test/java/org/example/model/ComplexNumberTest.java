package org.example.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Egységtesztek a ComplexNumber osztályhoz.
 * Ellenőrzi a különböző matematikai műveletek helyességét komplex számokkal.
 * Teszteli a Coordinate és a PanelCoordinate objektumok átalakítása ComplexNumber -re.
 */
public class ComplexNumberTest {

  /**
   * Teszteli az összeadási műveletet.
   * @param a az első komplex szám.
   * @param b a második komplex szám.
   * @param expected a két komplex szám összeadása után várható eredmény.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#addExample")
  void addTest(ComplexNumber a, ComplexNumber b, ComplexNumber expected) {
    assertThat(a.add(b)).isEqualTo(expected);
  }

  /**
   * Teszteli az kivonás műveletet.
   * @param a az első komplex szám.
   * @param b a második komplex szám.
   * @param expected a két komplex szám kivonása után várható eredmény.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#subtractExample")
  void subtractTest(ComplexNumber a, ComplexNumber b, ComplexNumber expected) {
    assertThat(a.subtract(b)).isEqualTo(expected);
  }

  /**
   * Teszteli a szorzási műveletet.
   * @param a az első komplex szám.
   * @param b a második komplex szám.
   * @param expected a két komplex szám szorzása után várható eredmény.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#multiplyExample")
  void multiplyTest(ComplexNumber a, ComplexNumber b, ComplexNumber expected) {
    assertThat(a.multiply(b)).isEqualTo(expected);
  }

  /**
   * Teszteli a osztás műveletet.
   * @param a az első komplex szám.
   * @param b a második komplex szám.
   * @param expected a két komplex szám osztás után várható eredmény.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#divideExample")
  void divideTest(ComplexNumber a, ComplexNumber b, ComplexNumber expected) {
    assertThat(a.divide(b)).isEqualTo(expected);
  }

  /**
   * Teszteli egy Coordinate konvertálását ComplexNumber számmá.
   * @param coordinate a konvertálandó koordinátát.
   * @param expected a várt komplex szám.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#coordinateExample")
  void parseComplexNumberTest(Coordinate coordinate, ComplexNumber expected) {
    assertThat(ComplexNumber.parseComplexNumber(coordinate)).isEqualTo(expected);
  }

  /**
   * Teszteli egy PanelCoordinate konverzióját ComplexNumber számmá,
   * meghatározott szélességi, magassági és mértékegységek használatával.
   * @param panelCoordinate konvertálandó panel koordinátáját.
   * @param width a panel szélessége.
   * @param height a panel magassága.
   * @param unitX az X tengely mértékegysége.
   * @param unitY az Y tengely mértékegysége.
   * @param expected a várt komplex szám.
   */
  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#panelCoordinateExample")
  void parseComplexNumberTest(PanelCoordinate panelCoordinate, int width, int height, double unitX, double unitY, ComplexNumber expected) {
    assertThat(ComplexNumber.parseComplexNumber(panelCoordinate, width, height, unitX, unitY)).isEqualTo(expected);
  }
}