package org.example.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PanelCoordinateTest {

  @ParameterizedTest
  @MethodSource(value = "org.example.model.PanelCoordinateArguments#complexNumberExample")
  void parseCoordinateTest(ComplexNumber c, int width, int height, double unitX, double unitY, PanelCoordinate expected) {
    assertThat(PanelCoordinate.parsePanelCoordinate(c, width, height, unitX, unitY)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource(value = "org.example.model.PanelCoordinateArguments#coordinateExample")
  void parseComplexNumberTest(Coordinate coordinate, int width, int height, double unitX, double unitY, PanelCoordinate expected) {
    assertThat(PanelCoordinate.parsePanelCoordinate(coordinate, width, height, unitX, unitY)).isEqualTo(expected);
  }
}