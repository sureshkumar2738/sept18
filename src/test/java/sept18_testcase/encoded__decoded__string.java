package sept18_testcase;

import org.apache.commons.codec.binary.Base64;

public class encoded__decoded__string {

	public static void main(String[] args) {
		
		String str = "testpassword";
		
		byte[] encodedString = Base64.encodeBase64(str.getBytes());
		
	System.out.println("EncodedString = "+new String(encodedString));
	
	byte[] decodedString = Base64.decodeBase64(encodedString);
	
	System.out.println("DecodedString = "+new String(decodedString));
		

	}

}
