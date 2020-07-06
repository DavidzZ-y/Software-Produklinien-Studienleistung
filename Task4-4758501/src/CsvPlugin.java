import javax.swing.filechooser.FileNameExtensionFilter;

public class CsvPlugin implements FilterPluginInterface{
	
	public FileNameExtensionFilter getFilterArgument() {
		String filter_name = ".csv";
		String filter_datatype = "csv";
		FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
		return filter;
	}

}
