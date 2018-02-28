package one.valuelogic.kata.gameoflive;

import java.util.WeakHashMap;

public class GameOfLive {
    GameOfLive() {
        this.world = getInitialState();
    }

    Cell[][] world;

    Cell[][] getInitialState() {
        return new Cell[][] {
                new Cell[] {new Cell(), new Cell(true), new Cell()},
                new Cell[] {new Cell(), new Cell(true), new Cell()},
                new Cell[] {new Cell(), new Cell(true), new Cell()}
        };
    }

    Cell[][] tick() {
        Cell[][] tmpWorld = world;

        for(int x=0; x < world.length; x++){
            for(int y = 0; y < world[x].length; y++){
                //world[x][y].neighboursCount;

                Cell currentCell = world[x][y];

                int neighboursCount = currentCell.getNeighboursCount(x, y);

                if (currentCell.isAlive && (neighboursCount < 2 || neighboursCount > 3)) {
                    currentCell.shouldDie();
                }
                if (!currentCell.isAlive && neighboursCount == 3) {
                    currentCell.shouldAlive();
                }
            }
        }

        for(int x=0; x < world.length; x++){
            for(int y = 0; y < world[x].length; y++) {
                world[x][y].nextGen();
            }
        }

        return world;
    }

    class Cell {
        Cell() {}

        Cell(boolean isAlive) {
            this.isAlive = isAlive;
        }


        public boolean isAlive;
        public boolean shouldDie;
        private boolean shouldAlive;

        public int getNeighboursCount(int x, int y) {
            int neighboursCount = 0;

            neighboursCount += topLeft(x,y);
            neighboursCount += top(x,y);
            neighboursCount += topRight(x,y);
            neighboursCount += left(x,y);
            neighboursCount += right(x,y);
            neighboursCount += bottomLeft(x,y);
            neighboursCount += bottom(x,y);
            neighboursCount += bottomRight(x,y);

            return neighboursCount;
        }

        private int top(int x, int y) {
            if (x == 0 || y == 0) {
                return 0;
            } else {
                return world[x][y-1].isAlive ? 1 : 0;
            }        }

        private int topLeft(int x, int y) {
            if (x == 0 || y == 0) {
                return 0;
            } else {
                return world[x-1][y-1].isAlive ? 1 : 0;
            }
        }
        private int topRight(int x, int y) {
            if (x == world.length - 1 || y == 0)  {
                return 0;
            } else {
                return world[x+1][y-1].isAlive ? 1 : 0;
            }
        }
        private int right(int x, int y) {
            if (x == world.length - 1) {
                return 0;
            } else {
                return world[x+1][y].isAlive ? 1 : 0;
            }
        }

        private int left(int x, int y) {
            if (x == 0) {
                return 0;
            } else {
                return world[x-1][y].isAlive ? 1 : 0;
            }
        }

        private int bottomLeft(int x, int y) {
            if (x == 0 || y == world.length-1) {
                return 0;
            } else {
                return world[x-1][y+1].isAlive ? 1 : 0;
            }
        }

        private int bottomRight(int x, int y) {
            if (x == world.length-1 || y == world.length-1) {
                return 0;
            } else {
                return world[x+1][y+1].isAlive ? 1 : 0;
            }
        }

        private int bottom(int x, int y) {
            if (x == 0 || y == world.length - 1) {
                return 0;
            } else {
                return world[x-1][y+1].isAlive ? 1 : 0;
            }
        }

        public void shouldDie() {
            shouldDie = true;
        }

        public void shouldAlive() {
            shouldAlive = true;
        }

        public void nextGen() {
            if(shouldDie){
                this.isAlive = false;
            }
            if(shouldAlive){
                this.isAlive = true;
            }

            shouldAlive = false;
            shouldDie = false;
        }
    }
}
