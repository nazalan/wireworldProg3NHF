package wireworld.core;

import java.io.Serializable;


public class Cell implements Serializable {
	public static enum State {
		EMPTY,
		ELECTRON_HEAD,
		ELECTRON_TAIL,
		CONDUCTOR
	}

	private State state;
	private int neighbourgs=0;

	public Cell() {
		state = State.EMPTY;
	}

	public Cell(State s) {
		state = s;
	}
	
	/*public Cell(Cell cell) {
		this.state = cell.state;
	}*/

	public void setState(State s) {
		state = s;
	}

	public State getState() {
		return state;
	}

	public void setNeighbourgs(int n) {
		neighbourgs = n;
	}

	public int getNeighbourgs() {
		return neighbourgs;
	}

	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Cell)) return false;
		if (this == obj) return true;
		Cell cell = (Cell) obj;
		return this.state.equals(cell.state);
	}

	public int hashCode() {
		return this.state.hashCode();
	}

	public String toString() {
		return this.state.toString();
	}
}