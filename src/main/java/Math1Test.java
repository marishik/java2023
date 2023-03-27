import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Math1Test {
    @Test
    void factOfNegativeIsZero() {
        int n = -1;
        long expected = 0;

        long actual = Math1.fact(n);

        assertEquals(expected, actual);
    }

    @Test
    void factOfZeroIsOne() {
        int n = 0;
        long expected = 1;
        long actual = Math1.fact(n);
        assertEquals(expected, actual);
    }

    @Test
    void factOfOneIsOne() {
        int n = 1;
        long expected = 1;
        long actual = Math1.fact(n);
        assertEquals(expected, actual);
    }

    @Test
    void factOfVariable() {
        int n = 5;
        long expected = 120;
        long actual = Math1.fact(n);
        assertEquals(expected, actual);
    }

    @Test
    void signOfNegativeIsNegativeOne() {
        int n = -50;
        long expected = -1;
        long actual = Math1.sign(n);
        assertEquals(expected, actual);
    }
    @Test
    void signOfPositiveIsOne() {
        int n = 50;
        long expected = 1;
        long actual = Math1.sign(n);
        assertEquals(expected, actual);
    }

    @Test
    void signOfZeroIsZero() {
        int n = 0;
        long expected = 0;
        long actual = Math1.sign(n);
        assertEquals(expected, actual);
    }
}