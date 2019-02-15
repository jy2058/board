package kr.or.ddit.util;

public class CookieUtil {

	private String[] cookieArray;
	
	public CookieUtil(String cookieString) {
		cookieArray = cookieString.split("; ");
	}

	/**
	* Method : getCookieValue
	* 작성자 : PC08
	* 변경이력 :
	* @param string
	* @return
	* Method 설명 : 쿠키 이름에 해당하는 쿠키 값을 조회
	*/
	public String getCookieValue(String cookieName) {
		
		String cookieValue ="";
		for(String cookie : cookieArray){
			if(cookieName.equals(cookie.split("=")[0])){
				cookieValue = cookie.split("=")[1];
				break;
			}
		}
		return cookieValue;
	}
}
