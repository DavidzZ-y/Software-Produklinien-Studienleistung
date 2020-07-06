import javax.swing.JFileChooser;

public class MultiOutputPlugin implements OutputPluginInterface {

	public void getOutput(JFileChooser fc) {
		System.out.println("Folgende Dateien wurden hochgeladen:");
		for (int i = 0;i < fc.getSelectedFiles().length; i++) {
			System.out.println(fc.getSelectedFiles()[i]);
		}
	}


}
