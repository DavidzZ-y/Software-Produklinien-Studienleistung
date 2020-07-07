import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * TODO description
 */
class data_upload {
	void addFilter() {
		original();
		String filter_name = ".mp3";
	    String filter_datatype = "mp3";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}
}