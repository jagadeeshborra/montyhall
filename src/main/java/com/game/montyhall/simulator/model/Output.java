package com.game.montyhall.simulator.model;

public class Output {
    public int iteration;
    public int [] doors;
    public int selected;
    public boolean switched;
    public boolean win;

    public Output(int iteration, int[] doors, int selected, boolean switched, boolean win) {
        this.iteration = iteration;
        this.doors = doors;
        this.selected = selected;
        this.switched = switched;
        this.win = win;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public int[] getDoors() {
        return doors;
    }

    public void setDoors(int[] doors) {
        this.doors = doors;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public boolean isSwitched() {
        return switched;
    }

    public void setSwitched(boolean switched) {
        this.switched = switched;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

}
