package wireworld.mvc.model;


import wireworld.core.Cell;

import javax.swing.*;
import java.awt.*;


public class WorldCell extends JLabel{
    private int x, y;
    private Cell.State state;

    public WorldCell(int x, int y) {
		this.x = x;
		this.y = y;
		setState(Cell.State.EMPTY);
	}

    public int getRow() {
		return x;
	}

    public int getCol() {
		return y;
	}

    public void setState(Cell.State s) {
		state = s;
		switch (state) {
			case ELECTRON_HEAD: setBackground(Color.BLUE); break;
			case ELECTRON_TAIL: setBackground(Color.RED); break;
			case CONDUCTOR: setBackground(Color.YELLOW); break;
			default: setBackground(Color.BLACK);
		}
	}

    public Cell.State getState() {
		return state;
	}
    
}
