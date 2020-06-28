import javax.swing.JFileChooser;

public interface OutputPluginInterface {
	void setApplication(Application app);
	void getOutput(JFileChooser fc);
}