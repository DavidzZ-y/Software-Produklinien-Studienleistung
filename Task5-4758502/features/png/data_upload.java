import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * TODO description
 */
class data_upload {
	void addFilter() {
		original();
		String filter_name = ".png";
	    String filter_datatype = "png";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}
}