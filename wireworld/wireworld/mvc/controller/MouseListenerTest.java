package wireworld.mvc.controller;

import wireworld.core.Cell;
import wireworld.mvc.model.WorldCell;
import wireworld.mvc.view.Grid;


import java.awt.event.*;

public class MouseListenerTest implements MouseListener{
    private Grid grid;
	public MouseListenerTest(Grid g) {
		grid = g;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		WorldCell worldCell = (WorldCell) e.getSource();
		if(e.getButton() == MouseEvent.BUTTON1 && grid.getClickable()==true) {
			if(worldCell.getState() == Cell.State.CONDUCTOR) {
				grid.labelPressed(worldCell, Cell.State.ELECTRON_HEAD);
			} else if (worldCell.getState() == Cell.State.ELECTRON_HEAD) {
				grid.labelPressed(worldCell, Cell.State.ELECTRON_TAIL);
			} else if(worldCell.getState() == Cell.State.ELECTRON_TAIL){
				grid.labelPressed(worldCell, Cell.State.EMPTY);
			}else {
				grid.labelPressed(worldCell, Cell.State.CONDUCTOR);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
