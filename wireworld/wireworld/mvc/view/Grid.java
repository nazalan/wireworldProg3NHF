package wireworld.mvc.view;

import wireworld.core.Cell;
import wireworld.core.Field;
import wireworld.mvc.controller.*;
import wireworld.mvc.model.WorldCell;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel{
    private WorldCell[][] grid;
	private Boolean clickable=true;

    public Grid(){
        grid=new WorldCell[30][30];

		MouseListenerTest mouseListener = new MouseListenerTest(this);
		MouseListenerTest mouseListener2 = new MouseListenerTest(this);

        setLayout(new GridLayout(30, 30));
		
        for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				grid[i][j] = new WorldCell(i, j);
				grid[i][j].setOpaque(true);
				grid[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				grid[i][j].addMouseListener(mouseListener);
				
                Dimension cellSize = new Dimension(25, 25);
				grid[i][j].setPreferredSize(cellSize);
				add(grid[i][j]);
			}
		}
    }

	public void setClickable(Boolean b){
		clickable=b;
	}
	public Boolean getClickable(){
		return clickable;
	}

	public WorldCell[][] getWorldCell(){
		return grid;
	}

	public void labelPressed(WorldCell worldCell, Cell.State state) {
			worldCell.setState(state);

	}

	public void update(Field f) {
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				grid[i][j].setState(f.getCellState(i, j));
			}
		}
	}

}
