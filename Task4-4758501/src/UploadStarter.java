import java.util.ArrayList;
import java.util.List;

public class UploadStarter {

	public static void main(String[] args) throws Exception {
	
		List<FilterPluginInterface> filterPlugins = new ArrayList<FilterPluginInterface>();
		//#if csv 
//@		filterPlugins.add(new CsvPlugin());
		//#endif
		//#if jpeg 
//@		filterPlugins.add(new JpegPlugin());
		//#endif
		//#if mp_drei 
		filterPlugins.add(new Mp3Plugin());
		//#endif
		//#if pdf
//@		filterPlugins.add(new PdfPlugin());
		//#endif
		//#if png
//@		filterPlugins.add(new PngPlugin());
		//#endif
		
		List<MultiSelectionPluginInterface> msPlugins= new ArrayList<MultiSelectionPluginInterface>();
		//#if Formdata
		msPlugins.add(new SingleSelectPlugin());
		//#endif
		//#if Multipart_Formdata	
//@		msPlugins.add(new MultiSelectPlugin());
		//#endif
		
		List<OutputPluginInterface> outputPlugins= new ArrayList<OutputPluginInterface>();
		//#if Output && Multipart_Formdata
//@		outputPlugins.add(new MultiOutputPlugin());
		//#endif
	    //#if Output && Formdata
		outputPlugins.add(new SingleOutputPlugin());
		//#endif
		
		Application uploader = new Application(
				filterPlugins, 
				msPlugins,         
				outputPlugins);       
	}
}
