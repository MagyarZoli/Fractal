package org.example.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexNumberTest {

  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#addExample")
  void addTest(ComplexNumber a, ComplexNumber b, ComplexNumber expected) {
    assertThat(a.add(b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#subtractExample")
  void subtractTest(ComplexNumber a, ComplexNumber b, ComplexNumber expected) {
    assertThat(a.subtract(b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#multiplyExample")
  void multiplyTest(ComplexNumber a, ComplexNumber b, ComplexNumber expected) {
    assertThat(a.multiply(b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#divideExample")
  void divideTest(ComplexNumber a, ComplexNumber b, ComplexNumber expected) {
    assertThat(a.divide(b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#coordinateExample")
  void parseComplexNumberTest(Coordinate coordinate, ComplexNumber expected) {
    assertThat(ComplexNumber.parseComplexNumber(coordinate)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource(value = "org.example.model.ComplexNumberArguments#panelCoordinateExample")
  void parseComplexNumberTest(PanelCoordinate panelCoordinate, int width, int height, double unitX, double unitY, ComplexNumber expected) {
    assertThat(ComplexNumber.parseComplexNumber(panelCoordinate, width, height, unitX, unitY)).isEqualTo(expected);
  }
}