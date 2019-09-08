package mask;

public class HashData {
	public String doHash(int hashData) {
		
		String strhashData = Integer.toString(hashData);
		
		return SHA256(strhashData);
	}
	
	public String doHash(String hashData) {
		
		return SHA256(hashData);
	}
	
	private String SHA256(String hashData) {
		
		
		
		return "";
	}
}
