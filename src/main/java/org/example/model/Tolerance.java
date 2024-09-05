package org.example.model;

public interface Tolerance {

  default boolean equalsWithTolerance(double a, double b, double tolerance) {
    return Math.abs(a - b) < tolerance || (a == 0.0 && b == 0.0);
  }
}
