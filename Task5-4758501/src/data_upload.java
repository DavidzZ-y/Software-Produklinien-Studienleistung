import javax.swing.JButton; 
import javax.swing.JFileChooser; import javax.swing.filechooser.FileNameExtensionFilter; /**
 * TODO description
 */
public /**
 * TODO description
 */
class  data_upload {
	
	private static data_upload du;

	
	
	private JFileChooser fc = new JFileChooser();

	
    private JButton open = new JButton();

	
	
    public static void main( String[] args ) {
      du = new data_upload();
      du.startConfig();
    }

	
    
     private void  startConfig__wrappee__Data_upload  () {
		fc.setDialogTitle("Datei-Uploader");
		fc.setApproveButtonText("Upload");
		fc.setApproveButtonToolTipText("Upload choosed files");
		addFilter();
		uploadAmount();
		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			output();
		}
	}

	
    void startConfig() {
    	fc.setAcceptAllFileFilterUsed(false);
    	startConfig__wrappee__Data_upload();
    }

	
    
     private void  addFilter__wrappee__Supported_Datatypes  () {
    	
    }

	
	 private void  addFilter__wrappee__pdf  () {
		addFilter__wrappee__Supported_Datatypes();
		String filter_name = ".pdf";
	    String filter_datatype = "pdf";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}

	
	 private void  addFilter__wrappee__png  () {
		addFilter__wrappee__pdf();
		String filter_name = ".png";
	    String filter_datatype = "png";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}

	
	 private void  addFilter__wrappee__csv  () {
		addFilter__wrappee__png();
		String filter_name = ".csv";
	    String filter_datatype = "csv";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}

	
	 private void  addFilter__wrappee__jpeg  () {
		addFilter__wrappee__csv();
		String filter_name = ".jpeg";
	    String filter_datatype = "jpeg";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}

	
	void addFilter() {
		addFilter__wrappee__jpeg();
		String filter_name = ".mp3";
	    String filter_datatype = "mp3";
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filter_name, filter_datatype);
	    fc.addChoosableFileFilter(filter);
	}

	
	void uploadAmount  () {
		fc.setMultiSelectionEnabled(true);
	}

	
	 private void  output__wrappee__Output  () {
		System.out.println("Folgende Dateien wurden hochgeladen:");
	}

	
	void output() {
		output__wrappee__Output();
		for (int i = 0;i < fc.getSelectedFiles().length; i++) {
			System.out.println(fc.getSelectedFiles()[i]);
		}
	}


}
