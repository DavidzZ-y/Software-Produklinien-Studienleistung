/**
 * TODO description
 */
class data_upload {
	void output() {
		original();
		for (int i = 0;i < fc.getSelectedFiles().length; i++) {
			System.out.println(fc.getSelectedFiles()[i]);
		}
	}
}
