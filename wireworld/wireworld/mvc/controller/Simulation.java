package wireworld.mvc.controller;

import wireworld.mvc.model.Wireworld;
import wireworld.mvc.view.Grid;

public class Simulation extends Thread{
    private boolean pauseThreadFlag = true;
    private final Object MONITOR = new Object();
    private Wireworld wireworld;
    private Grid grid;


    public Simulation(Wireworld ww, Grid g) {
        wireworld=ww;
        grid=g;
        
        start();
	}

    public void run() {
        int i=0;
        while (true) {
            checkForPaused();
            System.out.println("Hello"+i++);
            //System.out.println(wireworld.getInstance().getField().getCellState(1, 1));
            wireworld.tick();
            grid.update(wireworld.getField());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
	}

    private void checkForPaused() {
        synchronized (MONITOR) {
			while (pauseThreadFlag) {
				try {
					MONITOR.wait();
				} catch (Exception ignored) {}
			}
		}
	}

    public void pauseThread() throws InterruptedException {
        pauseThreadFlag = true;
        grid.setClickable(true);
	}

    public void resumeThread() {
        wireworld.update(grid);
		synchronized(MONITOR) {
			pauseThreadFlag = false;
            grid.setClickable(false);
			MONITOR.notify();
		}
	}

}
