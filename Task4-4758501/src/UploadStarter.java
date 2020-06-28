public class UploadStarter {

	public static void main(String[] args) throws Exception {
		
		Application uploader = new Application(
		new MultiSelectionPlugin(), //Plugin which specifies if multiple file upload is allowed or not 
		new FilterPlugin(),         //Plugin which specifies the input data type
		new OutputPlugin());        //Plugin which gives a console output after upload 
	}
}
