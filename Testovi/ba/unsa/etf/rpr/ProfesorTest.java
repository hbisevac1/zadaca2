package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfesorTest {

    @Test
    void testEquals() {
        Osoba p1 = new Profesor("Severus", "Snape", "1");
        Osoba p2 = new Profesor("Minerva", "McGonagal", "2");
        Osoba p3 = new Profesor("Poppy", "Pomfrey", "1");
        assertAll(
                ()->assertFalse(p1.equals(p2)),
                ()->assertTrue(p1.equals(p3))
        );
    }
}