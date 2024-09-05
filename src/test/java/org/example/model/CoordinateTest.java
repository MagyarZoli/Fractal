package org.example.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateTest {

  @ParameterizedTest
  @MethodSource(value = "org.example.model.CoordinateArguments#coordinateExample")
  void parseCoordinateTest(ComplexNumber c, Coordinate expected) {
    assertThat(Coordinate.parseCoordinate(c)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource(value = "org.example.model.CoordinateArguments#panelCoordinateExample")
  void parseComplexNumberTest(PanelCoordinate panelCoordinate, int width, int height, double unitX, double unitY, Coordinate expected) {
    assertThat(Coordinate.parseCoordinate(panelCoordinate, width, height, unitX, unitY)).isEqualTo(expected);
  }
}