package kr.or.ddit.util;

public class PartUtil {

/*	public static String getFileNameFromPart(String contentDisposition) {
		// form-data; name=\"uploadFile\"; filename=\"7.jpg\"
		String[] split1 = contentDisposition.split("; ");
		for (String split2 : split1) {
			if (split2.substring(0,7).equals("filename")) {
				String[] result = split2.split("=");
				return result[1];
			}

		}
		return null;

	}*/
	
	public static String getFileNameFromPart(String contentDisposition) {
		// form-data; name=\"uploadFile\"; filename=\"cony.png\"
		String[] splits = contentDisposition.split("; ");
		String filename="";
		for (String split : splits) {
			if (split.startsWith("filename=")) {
				filename = split.substring(split.indexOf("\"")+1, split.lastIndexOf("\""));
			}
		}
		return filename;
	}
}
