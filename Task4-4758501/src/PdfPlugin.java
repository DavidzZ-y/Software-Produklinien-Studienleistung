import javax.swing.filechooser.FileNameExtensionFilter;

public class PdfPlugin implements FilterPluginInterface{

	public FileNameExtensionFilter getFilterArgument() {
		String filter_name = ".pdf";
		String filter_datatype = "pdf";
		FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
		return filter;
	}
}
