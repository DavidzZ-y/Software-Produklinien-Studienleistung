import javax.swing.filechooser.FileNameExtensionFilter;

public class Mp3Plugin implements FilterPluginInterface{

	public FileNameExtensionFilter getFilterArgument() {
		String filter_name = ".mp3";
		String filter_datatype = "mp3";
		FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
		return filter;
	}

}
