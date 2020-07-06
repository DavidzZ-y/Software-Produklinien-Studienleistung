import javax.swing.JFileChooser;

public class SingleOutputPlugin implements OutputPluginInterface{
	
	public void getOutput(JFileChooser fc) {
		System.out.println("Folgende Dateien wurden hochgeladen:");
		System.out.println(fc.getSelectedFile());
	}
}
