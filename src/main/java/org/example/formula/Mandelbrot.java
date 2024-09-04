package org.example.formula;

import org.example.model.ComplexNumber;

import java.util.List;

public class Mandelbrot {

  private int recursive;
  private ComplexNumber c;

  public Mandelbrot(int recursive, ComplexNumber c) {
    this.recursive = recursive;
    this.c = c;
  }

  public void mandelbrotSet(List<ComplexNumber> list) {
    mandelbrotSet(list, new ComplexNumber(0.0, 0.0));
  }

  private void mandelbrotSet(List<ComplexNumber> list, ComplexNumber x) {
    list.add(x);
    if (list.size() < recursive) {
      mandelbrotSet(list, x.multiply(x).add(c));
    }
  }
}
