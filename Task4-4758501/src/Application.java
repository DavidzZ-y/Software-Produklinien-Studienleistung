import properties.PropertyManager;



import javax.swing.JFileChooser;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;

public class Application {
    private List<FilterPluginInterface> filterPlugins ;
    private List<MultiSelectionPluginInterface> msPlugins;
    private List<OutputPluginInterface> outputPlugins;
    
    private JFileChooser fc = new JFileChooser();
    private JButton open = new JButton();
    	
    public Application(List<FilterPluginInterface> filterPlugins,
    		List<MultiSelectionPluginInterface> msPlugins,
    		List<OutputPluginInterface >outputPlugins) throws Exception {
    
    	if(filterPlugins != null) {
    		this.filterPlugins = filterPlugins;
    	}
    	if(msPlugins != null) {
    		this.msPlugins = msPlugins;
    	}
    	if(outputPlugins != null) {
    		this.outputPlugins = outputPlugins;
    	}
    	validate();
    	init();
    }
	protected void init() throws Exception {
		startConfig();
		
		//set FilterPlugins 
		for(FilterPluginInterface plugin: filterPlugins) {
			FileNameExtensionFilter filter = plugin.getFilterArgument();
			fc.addChoosableFileFilter(filter);
	    }
				
		//set MultiSelectionPlugins
		for(MultiSelectionPluginInterface plugin: msPlugins) {
			fc.setMultiSelectionEnabled(plugin.getMultiSelectionValue());
		}
		
		//set OutputṔlugins 
		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			for(OutputPluginInterface plugin: outputPlugins) {
				plugin.getOutput(fc);
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
