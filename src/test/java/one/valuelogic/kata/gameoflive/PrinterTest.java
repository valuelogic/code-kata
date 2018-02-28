package one.valuelogic.kata.gameoflive;

import org.junit.jupiter.api.Test;

class PrinterTest {

    @Test
    void twoByTwo() {
        Printer printer = new Printer(2);

        boolean[][] world = new boolean[][] {
                new boolean[] {false, true},
                new boolean[] {true, false}
        };

        printer.print(world);
    }
}