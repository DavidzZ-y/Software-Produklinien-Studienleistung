import javax.swing.filechooser.FileNameExtensionFilter;

public class JpegPlugin implements FilterPluginInterface{

	public FileNameExtensionFilter getFilterArgument() {
		String filter_name = ".jpeg";
		String filter_datatype = "jpeg";
		FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
		return filter;
	}

}
