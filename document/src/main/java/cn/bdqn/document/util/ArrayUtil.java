package cn.bdqn.document.util;

import org.apache.commons.lang.StringUtils;

public class ArrayUtil {

	public static String toString(Integer[] array){
		if(array!=null){
			StringBuilder sb=new StringBuilder(5);
			for(int i=0;i<array.length;i++){
				sb.append(array[i]);
				if(i<array.length-1){
					sb.append(",");
				}				
			}
			return sb.toString();
		}
		return "";
	}
	
	//1,2,3
	public static Integer[] toArray(String str){
		Integer[] array=null;
		
		if(StringUtils.isNotEmpty(str)){
			String[] strs=str.split(",");
			array=new Integer[strs.length];
			
			for(int i=0;i<strs.length;i++){
				array[i]=Integer.valueOf(strs[i]);
			}			
		}
		
		return array;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
