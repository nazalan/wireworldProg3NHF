package wireworld.utils;


import wireworld.core.Field;

import java.io.*;

public class FieldImporter {
	private static FieldImporter instance;

	private  FieldImporter() {}

	public static FieldImporter getInstance() {
		if(instance == null) {
			synchronized (FieldImporter.class) {
				instance = new FieldImporter();
			}
		}
		return instance;
	}

	public Field fieldImport(File file) throws IOException, ClassNotFoundException {
		
		ObjectInputStream inputStream = null;
		try {
			inputStream =
					new ObjectInputStream(
							new BufferedInputStream(
									new FileInputStream(file)));
			return (Field) inputStream.readObject();
		} finally {
			if(inputStream != null)	inputStream.close();
		}

	}
}