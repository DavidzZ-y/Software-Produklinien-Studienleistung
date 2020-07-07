import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * TODO description
 */
class data_upload {
	void addFilter() {
		original();
		String filter_name = ".jpeg";
	    String filter_datatype = "jpeg";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}
}