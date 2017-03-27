package cn.bdqn.document.util;

public class PasswordUtil {

	//随机生成“盐”
	public static String getSalt(){
		StringBuilder sb=new StringBuilder(10);
		for(int i=0;i<10;i++){
			int c=(int)(Math.random()*(122-48)+48);
			if(c=='\\'){
				i--;
				continue;
			}
			sb.append((char)c);
		}
		return sb.toString();
	}
	
	//在密码中掺入“盐”
	public static String addSalt(String password,String salt){
		return salt+"_"+password+"_"+salt;
	}

}




