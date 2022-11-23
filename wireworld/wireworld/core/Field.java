package wireworld.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class Field implements Serializable{
	private HashMap<Coordinate, Cell> field;

	public Field() {
		field =  new HashMap<Coordinate, Cell>();
	}


	public HashMap<Coordinate, Cell> getField() {
		return field;
	}

	public void setCellState(int x, int y, Cell.State s) {
		field.put(new Coordinate(x, y), new Cell(s));
	}

	public Cell.State getCellState(int x, int y) {
		Cell cell = field.get(new Coordinate(x, y));
		if(cell==null){
			//System.out.println("neszopassmar");
			return Cell.State.EMPTY;
		} else{
			return cell.getState();
		}
	}

	public Cell getCell(int x, int y) {
		return field.get(new Coordinate(x, y));
	}

	public void countNeighbourgs() {
		
		Collection<Coordinate> coordinates = field.keySet();
		for(Coordinate c : coordinates) {
			Cell cell = field.get(c); // resets counter
			cell.setNeighbourgs(0);
			// since only a conduction can become an electron head
			//   i count only neighbours for conductor
			if(cell.getState() == Cell.State.CONDUCTOR) {
				int n = 0;
				for(int i=-1; i<2; i++){
					for(int j=-1; j<2; j++){
						if(getCellState(c.getX() + i, c.getY() + j) == Cell.State.ELECTRON_HEAD) n++;
					}
				}
				cell.setNeighbourgs(n);
				field.put(c, cell);
			}
		}
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Field)) return false;

		Field grid1 = (Field) o;

		if (!field.equals(grid1.field)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return field.hashCode();
	}

	@Override
	public String toString() {
		return "Grid{" +
				"grid=" + field +
				'}';
	}
}
