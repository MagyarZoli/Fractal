package org.example.model;

/**
 * A Tolerance interfész lehetővé teszi, hogy különböző osztályok egyszerűen hozzáadhassák
 * a lebegőpontos számok közötti összehasonlítást egy megadott tolerancia érték mellett
 */
public interface Tolerance {

  /**
   * Összehasonlít két értéket annak ellenőrzésére,
   * hogy egy meghatározott tűréshatáron belül egyenlőek-e.
   * @param a Az első összehasonlítandó érték.
   * @param b A második összehasonlítandó érték.
   * @param tolerance az a tűrés, amelyen belül a két érték egyenlőnek tekinthető.
   * @return true ha az értékek közötti abszolút különbség kisebb, mint a tűrés,
   *         vagy ha mindkét érték pontosan nulla, ellenkező esetben false.
   */
  default boolean equalsWithTolerance(double a, double b, double tolerance) {
    return Math.abs(a - b) < tolerance || (a == 0.0 && b == 0.0);
  }
}
