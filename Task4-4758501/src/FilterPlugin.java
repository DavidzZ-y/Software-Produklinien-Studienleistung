import javax.swing.filechooser.FileNameExtensionFilter;

public class FilterPlugin implements FilterPluginInterface{
private Application application;
	
	public void setApplication(Application app) {
		this.application = app;
	}
	
	public FileNameExtensionFilter[] getFilterArguments() {
		FileNameExtensionFilter[] filters = new FileNameExtensionFilter[5];	
		//#if pdf
						String filter_name1 = ".pdf";
						String filter_datatype1 = "pdf";
						filters[0] = new FileNameExtensionFilter(filter_name1, filter_datatype1);
		//#endif
		//#if mp_drei
						String filter_name2 = ".mp3";
						String filter_datatype2 = "mp3";
						filters[1] = new FileNameExtensionFilter(filter_name2, filter_datatype2);
		//#endif
		//#if png
						String filter_name3 = ".png";
						String filter_datatype3 = "png";
						filters[2] = new FileNameExtensionFilter(filter_name3, filter_datatype3);
		//#endif
		//#if jpeg
						String filter_name4 = ".jpeg";
						String filter_datatype4 = "jpg";
						filters[3] = new FileNameExtensionFilter(filter_name4, filter_datatype4);
		//#endif
		//#if csv
						String filter_name5 = ".csv";
						String filter_datatype5 = "csv";
						filters[4] = new FileNameExtensionFilter(filter_name5, filter_datatype5);
	    //#endif
		return filters;
	}
}
