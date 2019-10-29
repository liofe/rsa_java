package hoang.rsa.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.swing.JFileChooser;

public class Data {
	JFileChooser chooser = new JFileChooser();
	
	public Data() {
		
	}
	public void OutputWrite (File saveLocation, BigInteger EncryptCodes,BigInteger N, String name)
			throws FileNotFoundException{
				PrintWriter file = new PrintWriter(new FileOutputStream(new File(saveLocation, name)));
				file.println(EncryptCodes);
				file.println(N);
				file.close();
			}
	
	public File getSaveLocation() {
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		if(chooser.showSaveDialog(chooser) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}else return null;
	}
	public File getOpenLocation() {
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		if(chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}else return null;
	}

}
