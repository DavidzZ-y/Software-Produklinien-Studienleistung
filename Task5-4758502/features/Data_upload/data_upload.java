import javax.swing.JButton;
import javax.swing.JFileChooser;
/**
 * TODO description
 */
public class data_upload {
	private static data_upload du;
	
	private JFileChooser fc = new JFileChooser();
    private JButton open = new JButton();
	
    public static void main( String[] args ) {
      du = new data_upload();
      du.startConfig();
    }
    
    void startConfig() {
		fc.setDialogTitle("Datei-Uploader");
		fc.setApproveButtonText("Upload");
		fc.setApproveButtonToolTipText("Upload choosed files");
		addFilter();
		uploadAmount();
		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			output();
		}
	}
    void output() {
    	System.out.println("aasas");
    }
}