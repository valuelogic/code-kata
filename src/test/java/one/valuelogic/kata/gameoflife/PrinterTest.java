package one.valuelogic.kata.gameoflife;

import org.junit.jupiter.api.Test;

class PrinterTest {

    @Test
    public void twoByTwo() {
        GameOfLife gameOfLive = new GameOfLife();

        Printer printer = new Printer(3);

        printer.print(gameOfLive.tick());
        printer.print(gameOfLive.tick());
        printer.print(gameOfLive.tick());
    }
}