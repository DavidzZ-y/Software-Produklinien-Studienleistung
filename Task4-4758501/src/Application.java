import properties.PropertyManager;



import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;

public class Application {
    private MultiSelectionPlugin multiSelectionPlugin;
    private FilterPlugin filterPlugin;
    private OutputPlugin outputPlugin;
    
    private JFileChooser fc = new JFileChooser();
    private JButton open = new JButton();
    	
    public Application(MultiSelectionPlugin p1, FilterPlugin p2, OutputPlugin p3) throws Exception {
    	multiSelectionPlugin = p1;
    	filterPlugin = p2;
    	outputPlugin = p3;	
    	if (multiSelectionPlugin != null) {
    		multiSelectionPlugin.setApplication(this);
    	}
    	if (filterPlugin != null) {
    		filterPlugin.setApplication(this);
    	}
    	if (outputPlugin != null) {
    		outputPlugin.setApplication(this);
    	}
    	validate();
    	init();
    }
	protected void init() throws Exception {
		startConfig();
		
		//get MultiSelectionPlugin information
		if (multiSelectionPlugin != null) {
		fc.setMultiSelectionEnabled(multiSelectionPlugin.getMultiSelectionValue());
		}
		
		//get FilterPlugin information
		if (filterPlugin != null) {
			FileNameExtensionFilter[] filter = (filterPlugin.getFilterArguments());
			for(int i = 0; i< filter.length; i++) {
				fc.addChoosableFileFilter(filter[i]);
			}
		}
		
		//get OutputṔlugin information
		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			if (outputPlugin != null) {
				outputPlugin.getOutput(fc);
			}
		}
	}
	
	public void startConfig() {
		fc.setAcceptAllFileFilterUsed(false);
		fc.setDialogTitle("Datei-Uploader");
		fc.setApproveButtonText("Upload");
		fc.setApproveButtonToolTipText("Upload choosed files");
	}
	
	public static void validate() throws Exception {
		if (PropertyManager.getProperty("pdf") || PropertyManager.getProperty("csv")) {
			if (!(PropertyManager.getProperty("UTF_acht") || PropertyManager.getProperty("ASCII"))) {
				JOptionPane.showMessageDialog(new JFrame(), "When you choose pdf or csv, you also need UTF-8 or ASCII decoding", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
		}
		if (PropertyManager.getProperty("jpeg") || PropertyManager.getProperty("png")) {
			if (!PropertyManager.getProperty("Base")) {
				JOptionPane.showMessageDialog(new JFrame(), "When you choose png or jepg, you also need Base decoding", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
		}
		if (PropertyManager.getProperty("mp_drei")) {
			if (!PropertyManager.getProperty("Audio_codec")) {
				JOptionPane.showMessageDialog(new JFrame(), "When you choose mp3, you also need audio_codec decoding", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
		}
		if (PropertyManager.getProperty("Formdata")) {
			if (PropertyManager.getProperty("Multipart_Formdata")) {
				JOptionPane.showMessageDialog(new JFrame(), "You can only choose Formdata or Multipart_Formdata", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
		}
		if (PropertyManager.getProperty("Multipart_Formdata")) {
			if (PropertyManager.getProperty("Formdata")) {
				JOptionPane.showMessageDialog(new JFrame(), "You can only choose Formdata or Multipart_Formdata", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
		}
	}
}
