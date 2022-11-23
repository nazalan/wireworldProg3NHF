package wireworld.mvc.model;

import java.util.*;
import wireworld.core.*;
import wireworld.mvc.view.Grid;

public class Wireworld {
    private Field field;
	private static Wireworld instance;

    public Wireworld() {
		field = new Field();
	}

    public void setCell(int x, int y, Cell.State state) {
		field.setCellState(x, y, state);
	}

    public void setField(Field f) {
		field = f;
	}
    public Field getField() {
		return field;
	}

	public static Wireworld getInstance() {
		if(instance == null) {
			synchronized (Wireworld.class) {
				instance = new Wireworld();
			}
		}
		return instance;
	}

    public void tick() {
		field.countNeighbourgs();
		Collection<Cell> cells = field.getField().values();

 		for(Cell cell : cells) {
			switch (cell.getState()) {
				case ELECTRON_HEAD:
					cell.setState(Cell.State.ELECTRON_TAIL);
					break;
				case ELECTRON_TAIL:
					cell.setState(Cell.State.CONDUCTOR);
					break;
				case CONDUCTOR:
					if (cell.getNeighbourgs() == 1 || cell.getNeighbourgs() == 2)
						cell.setState(Cell.State.ELECTRON_HEAD);
					break;
				default:
			}
		}
	}

	public void update(Grid g){
		WorldCell[][] wc = new WorldCell[30][30];
		wc=g.getWorldCell();
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				setCell(i, j, wc[i][j].getState());
			}
		}

	}
}
