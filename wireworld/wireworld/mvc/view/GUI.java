package wireworld.mvc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import wireworld.mvc.controller.Simulation;
import wireworld.mvc.model.Wireworld;
import wireworld.utils.*;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.IOException;


public class GUI extends JFrame implements ActionListener{
    private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem imp, exp;
	private boolean started=false;
	private Grid grid;
	private Wireworld wireworld;

    public GUI(Simulation simulation, Grid grid, Wireworld wireworld) {
	
	this.grid=grid;
	this.wireworld=wireworld;
	
	setTitle("Wireworld");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	JButton startstopButton = new JButton("Start/Stop");
	startstopButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!started) {
				started = true;
				simulation.resumeThread();
			  } else {
				started = false;
				try {
					simulation.pauseThread();
				} catch (InterruptedException e1) {
				  e1.printStackTrace();
				}
			  }
		}
	}
	);
	
	add(startstopButton, BorderLayout.EAST);


	menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);

		file = new JMenu("File");
		menuBar.add(file);

		imp = new JMenuItem("Import");
		imp.addActionListener(this);
		file.add(imp);

		exp = new JMenuItem("Export");
		exp.addActionListener(this);
		file.add(exp);

    }

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileFilter() {

			public String getDescription() {
				return "Wireworld file (*.w)";
			}

			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".w");
				}
			}
		});

		if(source == imp) {
			int status = fileChooser.showOpenDialog(this);
			if(status == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				FieldImporter importer = FieldImporter.getInstance();
				Wireworld wireworld = Wireworld.getInstance();

				try {
					wireworld.setField(importer.fieldImport(file));
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			grid.update(wireworld.getField());


		} else if (source == exp) {
			int status = fileChooser.showSaveDialog(this);
			if(status == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				FieldExporter exporter = FieldExporter.getInstance();
				try {
					exporter.fieldExport(Wireworld.getInstance(), file);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			wireworld.update(grid);
		}
		
	}
}
