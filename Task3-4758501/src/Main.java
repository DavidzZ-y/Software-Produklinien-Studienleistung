import properties.PropertyManager;



import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;



public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		validate();
		JButton open = new JButton();
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		fc.setDialogTitle("Datei-Uploader");
		fc.setApproveButtonText("Upload");
		fc.setApproveButtonToolTipText("Upload choosed files");
		System.out.println("Folgende Dateien wurden hochgeladen: ");
			//#if Formdata
//@				fc.setMultiSelectionEnabled(false);
			//#endif
			//#if Multipart_Formdata
			fc.setMultiSelectionEnabled(true);
			JOptionPane.showMessageDialog(new JFrame(), "To upload multiple files, hold control-button when selecting Files", "Hint",
		    JOptionPane.INFORMATION_MESSAGE);
			//#endif
			
			
			//#if pdf
				String filter_name1 = ".pdf";
				String filter_datatype1 = "pdf";
				FileNameExtensionFilter pdf_filter = new FileNameExtensionFilter(filter_name1, filter_datatype1);
				fc.addChoosableFileFilter(pdf_filter);
			//#endif
			//#if mp_drei
				String filter_name2 = ".mp3";
				String filter_datatype2 = "mp3";
				FileNameExtensionFilter mp3_filter = new FileNameExtensionFilter(filter_name2, filter_datatype2);
				fc.addChoosableFileFilter(mp3_filter);
			//#endif
			//#if png
				String filter_name3 = ".png";
				String filter_datatype3 = "png";
				FileNameExtensionFilter png_filter = new FileNameExtensionFilter(filter_name3, filter_datatype3);
				fc.addChoosableFileFilter(png_filter);
			//#endif
			//#if jpeg
				String filter_name4 = ".jpeg";
				String filter_datatype4 = "jpg";
				FileNameExtensionFilter jpeg_filter = new FileNameExtensionFilter(filter_name4, filter_datatype4);
				fc.addChoosableFileFilter(jpeg_filter);
			//#endif
			//#if csv
				String filter_name5 = ".csv";
				String filter_datatype5 = "csv";
				FileNameExtensionFilter csv_filter = new FileNameExtensionFilter(filter_name5, filter_datatype5);
				fc.addChoosableFileFilter(csv_filter);
			//#endif

				
		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			//#if Multipart_Formdata
			for (int i = 0;i < fc.getSelectedFiles().length; i++) {
				System.out.println(fc.getSelectedFiles()[i]);
			}
			//#endif
			
			//#if Formdata
//@			System.out.println(fc.getSelectedFile());
			//#endif
		}
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
