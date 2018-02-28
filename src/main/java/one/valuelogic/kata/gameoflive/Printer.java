package one.valuelogic.kata.gameoflive;

import java.time.LocalTime;

public class Printer {

    private int frameNo = 0;
    private int size;

    public Printer(int size) {
        this.size = size;
    }

    private boolean isWorldSquare(GameOfLive.Cell[][] world) {
        if (world.length != this.size) {
            return false;
        }

        for (GameOfLive.Cell[] row : world) {
            if (row.length != this.size) {
                return false;
            }
        }

        return true;
    }

    public void print(GameOfLive.Cell[][] world) {
        if (world == null || !isWorldSquare(world)) {
            throw new IllegalArgumentException("Invalid world");
        }

        LocalTime now = LocalTime.now();

        System.out.println(String.format("Frame %d, at time %2$tH:%2$tM:%2$tS", ++frameNo, now));

        printBounds();
        for (GameOfLive.Cell[] row: world) {
            printRow(row);
        }
        printBounds();
    }

    private void printBounds() {
        System.out.print("+");
        for (int i = 0; i < this.size; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    private void printRow(GameOfLive.Cell[] row) {
        System.out.print("|");
        for (int i = 0; i < this.size; i++) {
            System.out.print(row[i].isAlive ? 'X' : ' ');
        }
        System.out.println("|");
    }
}
