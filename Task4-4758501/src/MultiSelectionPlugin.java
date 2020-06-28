public class MultiSelectionPlugin implements MultiSelectionPluginInterface {
private Application application;
	
	public void setApplication(Application app) {
		this.application = app;
	}
	public boolean getMultiSelectionValue() {
		//#if Formdata
//@		return false;
		//#endif
		
		//#if Multipart_Formdata
		return true;
		//#endif
	}
}
