package wireworld;

import wireworld.mvc.controller.*;
import wireworld.mvc.model.*;
import wireworld.mvc.view.*;

import java.awt.*;

public class Main {

  public static void main(String[] args) {

    Grid grid = new Grid();
    Wireworld wireworld=Wireworld.getInstance();
    Simulation simulation = new Simulation(wireworld, grid);
    GUI frame = new GUI(simulation, grid, wireworld);
    
    frame.setVisible(true);
    
    frame.getContentPane().add(grid, BorderLayout.CENTER);
    frame.pack();
    frame.setResizable(false);
    
  }
}
