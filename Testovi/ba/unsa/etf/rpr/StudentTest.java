package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testEquals() {
        Student s1 = new Student("Hana", "Bisevac", "18628");
        Student s2 = new Student("Nezla", "Bisevac", "18628");
        Student s3 = new Student("Hana", "Bisevac", "18621");

        assertAll(
                ()-> assertTrue(s1.equals(s2)),
                ()->assertFalse(s1.equals(s3))
        );
    }

    @Test
    void testToString() {
        Student s1 = new Student("Hana", "Bisevac", "18628");
        String rez="Ime i prezime: Hana Bisevac\nBroj indeksa: 18628\n";
        assertEquals(rez, s1.toString());
    }
}