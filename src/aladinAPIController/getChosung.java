package aladinAPIController;

public class getChosung {
	public String chosung(String title) {
	        char b =title.charAt(0);
	        String chosung = null;
	        int first = (b - 44032 ) / ( 21 * 28 );
	         switch(first){
	             case 0:
	             case 1:
	                 chosung="ぁ";
	                 break;
	             case 2:
	                 chosung="い";
	                 break;
	             case 3:
	             case 4:
	                 chosung="ぇ";
	                 break;
	             case 5:
	                 chosung="ぉ";
	                 break;
	             case 6:
	                 chosung="け";
	                 break;
	             case 7:
	             case 8:
	                 chosung="げ";
	                 break;
	             case 9:
	             case 10:
	                 chosung="さ";
	                 break;
	             case 11:
	                 chosung="し";
	                 break;
	             case 12:
	             case 13:
	                 chosung="じ";
	                 break;
	             case 14:
	                 chosung="ず";
	                 break;
	             case 15:
	                 chosung="せ";
	                 break;
	             case 16:
	                 chosung="ぜ";
	                 break;
	             case 17:
	                 chosung="そ";
	                 break;
	             case 18:
	                 chosung="ぞ";
	                 break;
	             default:
	            	 chosung=Character.toString(b);
	         }     
	      return chosung;
	}
}