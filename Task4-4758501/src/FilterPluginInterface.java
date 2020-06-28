import javax.swing.filechooser.FileNameExtensionFilter;

public interface FilterPluginInterface {
	void setApplication(Application app);
	FileNameExtensionFilter[] getFilterArguments();
}
