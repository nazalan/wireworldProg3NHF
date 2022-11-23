package wireworld.utils;


import wireworld.mvc.model.Wireworld;

import java.io.*;

public class FieldExporter {
	private static FieldExporter instance;

	private FieldExporter() { }

	public static FieldExporter getInstance() {
		if(instance == null) {
			synchronized (FieldExporter.class) {
				instance = new FieldExporter();
			}
		}
		return instance;
	}

	public void fieldExport(Wireworld wireworld, File file) throws IOException {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(file)));
			outputStream.writeObject(wireworld.getField());
		} finally {
			if(outputStream != null) {
				outputStream.flush();
				outputStream.close();
			}
		}

	}
}