import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * TODO description
 */
class data_upload {
	void addFilter() {
		original();
		String filter_name = ".csv";
	    String filter_datatype = "csv";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}
}