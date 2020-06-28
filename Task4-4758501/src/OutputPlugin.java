import javax.swing.JFileChooser;

public class OutputPlugin implements OutputPluginInterface {
	private Application application;
	private JFileChooser fc;
	
	public void setApplication(Application app) {
		this.application = app;
	}
	
	public void getOutput(JFileChooser fc) {
		System.out.println("Folgende Dateien wurden hochgeladen");
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
