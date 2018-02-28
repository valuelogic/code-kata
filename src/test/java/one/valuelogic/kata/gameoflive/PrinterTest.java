package one.valuelogic.kata.gameoflive;

import org.junit.jupiter.api.Test;

class PrinterTest {

    @Test
    public void twoByTwo() {
        GameOfLive gameOfLive = new GameOfLive();

        Printer printer = new Printer(3);

        printer.print(gameOfLive.tick());
        printer.print(gameOfLive.tick());
        printer.print(gameOfLive.tick());
    }
}