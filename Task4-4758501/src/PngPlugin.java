import javax.swing.filechooser.FileNameExtensionFilter;

public class PngPlugin implements FilterPluginInterface{

	public FileNameExtensionFilter getFilterArgument() {
		String filter_name = ".png";
		String filter_datatype = "png";
		FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
		return filter;
	}

}
