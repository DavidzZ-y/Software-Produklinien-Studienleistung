import properties.PropertyManager;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		validate();
		if (PropertyManager.getProperty("Multi_Single_Data")) {
			System.out.println("Uploader mit ");
			if (PropertyManager.getProperty("Formdata")) {
				System.out.println("einer Datei ");
			}
			if (PropertyManager.getProperty("Multipart_Formdata")) {
				System.out.println("mehreren Dateien");
			}
		}
		if (PropertyManager.getProperty("Supported_Datatypes")) {
			System.out.println("und Unterstützung von ");
			if (PropertyManager.getProperty("pdf")) {
				System.out.println("pdf");
			}
			if (PropertyManager.getProperty("mp_drei")) {
				System.out.println("mp3");
			}
			if (PropertyManager.getProperty("png")) {
				System.out.println("png");
			}
			if (PropertyManager.getProperty("jpeg")) {
				System.out.println("jpeg");
			}
			if (PropertyManager.getProperty("csv")) {
				System.out.println("csv");
			}
		}
		if (PropertyManager.getProperty("Decoding")) {
			System.out.println("und Dekodierung mit");
			if (PropertyManager.getProperty("ASCII")) {
				System.out.println("ASCII");
			}
			if (PropertyManager.getProperty("Base")) {
				System.out.println("Base");
			}
			if (PropertyManager.getProperty("UTF_acht")) {
				System.out.println("UTF_acht");
			}
			if (PropertyManager.getProperty("Audio_codec")) {
				System.out.println("Audio_codec");
			}
		}
	}
	public static void validate() throws Exception {
		if(PropertyManager.getProperty("pdf") ||PropertyManager.getProperty("csv") ) {
			if (!(PropertyManager.getProperty("UTF_acht")|| PropertyManager.getProperty("ASCII"))) {
				throw new Exception("When you choose pdf or csv, you also need UTF-8 or ASCII decoding");
			}
		}
		if(PropertyManager.getProperty("jpeg") ||PropertyManager.getProperty("png") ) {
			if (!PropertyManager.getProperty("Base")) {
				throw new Exception("When you choose png or jepg, you also need Base decoding");
			}
		}
		if(PropertyManager.getProperty("mp_drei")) {
			if (!PropertyManager.getProperty("Audio_codec")) {
				throw new Exception("When you choose mp3, you also need audio_codec decoding");
			}
		}
		if(PropertyManager.getProperty("Formdata")) {
			if (PropertyManager.getProperty("Multipart_Formdata")) {
				throw new Exception("You can only choose Formdata or Multipart_Formdata");
			}
		}
		if(PropertyManager.getProperty("Multipart_Formdata")) {
			if (PropertyManager.getProperty("Formdata")) {
				throw new Exception("You can only choose Formdata or Multipart_Formdata");
			}
		}
	}
}
