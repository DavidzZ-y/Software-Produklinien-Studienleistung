import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * TODO description
 */
class data_upload {
	void addFilter() {
		original();
		String filter_name = ".pdf";
	    String filter_datatype = "pdf";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}
}