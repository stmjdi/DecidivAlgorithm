package aladinAPIController;

public class getChosung {
	public String chosung(String title) {
	        char b =title.charAt(0);
	        String chosung = null;
	        int first = (b - 44032 ) / ( 21 * 28 );
	         switch(first){
	             case 0:
	             case 1:
	                 chosung="��";
	                 break;
	             case 2:
	                 chosung="��";
	                 break;
	             case 3:
	             case 4:
	                 chosung="��";
	                 break;
	             case 5:
	                 chosung="��";
	                 break;
	             case 6:
	                 chosung="��";
	                 break;
	             case 7:
	             case 8:
	                 chosung="��";
	                 break;
	             case 9:
	             case 10:
	                 chosung="��";
	                 break;
	             case 11:
	                 chosung="��";
	                 break;
	             case 12:
	             case 13:
	                 chosung="��";
	                 break;
	             case 14:
	                 chosung="��";
	                 break;
	             case 15:
	                 chosung="��";
	                 break;
	             case 16:
	                 chosung="��";
	                 break;
	             case 17:
	                 chosung="��";
	                 break;
	             case 18:
	                 chosung="��";
	                 break;
	             default:
	            	 chosung=Character.toString(b);
	         }     
	      return chosung;
	}
}