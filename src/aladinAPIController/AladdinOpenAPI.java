package aladinAPIController;

import java.net.URLEncoder;
import java.sql.*;
import java.util.*;

public class AladdinOpenAPI {
	private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemSearch.aspx?";// �ѷ��� �⺻ ������ URL
	
	final static String Driver = "oracle.jdbc.driver.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final static String user = "c##stmjdi04";
	final static String psw = "oracle";
	
	static Connection conn = null;
	static PreparedStatement pstmt1 = null, pstmt2 = null;
	static ResultSet rs = null;
	
	static void Connection() throws Exception{
		Class.forName(Driver);
		conn = DriverManager.getConnection(URL, user, psw);
		System.out.println("Connection Success");
	}
	
	static int findBid() throws Exception{
		pstmt1=conn.prepareStatement("select count(*) from booklist");
		int ret = 0;
		rs=pstmt1.executeQuery();
		while(rs.next()) ret=rs.getInt(1);
		
		return ret;
	}
	
	static String deciDiv(Item item) {
		String result1;
		if ((item.CategoryName).contains("�Ҽ�") && (item.CategoryName).contains("�ѱ�")) {
			result1 = "810";
		} else if ((item.CategoryName).contains("�Ҽ�") && (item.CategoryName).contains("�߱�")) {
			result1 = "820";
		} else if ((item.CategoryName).contains("�Ҽ�") && (item.CategoryName).contains("�Ϻ�")) {
			result1 = "830";
		} else if ((item.CategoryName).contains("�Ҽ�") && (item.CategoryName).contains("����")) {
			result1 = "840";
		} else if ((item.CategoryName).contains("�Ҽ�") && (item.CategoryName).contains("����")) {
			result1 = "850";
		} else if ((item.CategoryName).contains("�Ҽ�") && (item.CategoryName).contains("������")) {
			result1 = "860";
		} else if ((item.CategoryName).contains("�Ҽ�") && (item.CategoryName).contains("������")) {
			result1 = "870";
		} else if ((item.CategoryName).contains("�Ҽ�") && (item.CategoryName).contains("��Ż����")) {
			result1 = "880";
		} else if ((item.CategoryName).contains("�Ҽ�") && (item.CategoryName).contains("��Ÿ")) {
			result1 = "890";
		} else if ((item.CategoryName).contains("���̻���")) {
			result1 = "110";
		} else if ((item.CategoryName).contains("�νķ�") || (item.CategoryName).contains("�ΰ���")||(item.CategoryName).contains("�ΰ���")) {
			result1 = "120";
		} else if ((item.CategoryName).contains("ö��")&&(item.CategoryName).contains("ü��")) {
			result1 = "130";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "140";
		} else if ((item.CategoryName).contains("����") && ((item.CategoryName).contains("���")||(item.CategoryName).contains("ö��"))) {
			result1 = "150";
		} else if ((item.CategoryName).contains("����") && ((item.CategoryName).contains("���")||(item.CategoryName).contains("ö��"))) {
			result1 = "160";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "170";
		} else if ((item.CategoryName).contains("�ɸ���")) {
			result1 = "180";
		} else if ((item.CategoryName).contains("������") && ((item.CategoryName).contains("����ö��"))) {
			result1 = "190";
		} else if ((item.CategoryName).contains("������")) {
			result1 = "210";
		} else if ((item.CategoryName).contains("�ұ�")) {
			result1 = "220";
		} else if ((item.CategoryName).contains("�⵶��")) {
			result1 = "230";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "240";
		} else if ((item.CategoryName).contains("õ����")) {
			result1 = "250";
		} else if ((item.CategoryName).contains("�ŵ�")) {
			result1 = "260";
		} else if ((item.CategoryName).contains("���α�")||(item.CategoryName).contains("��󸸱�")) {
			result1 = "270";
		} else if ((item.CategoryName).contains("�̽�����")) {
			result1 = "280";
		} else if ((item.CategoryName).contains("��Ÿ")&&(item.CategoryName).contains("����")) {
			result1 = "290";
		} else if ((item.CategoryName).contains("�����")) {
			result1 = "310";
		} else if ((item.CategoryName).contains("������")) {
			result1 = "320";
		} else if ((item.CategoryName).contains("��ȸ��")||(item.CategoryName).contains("��ȸ����")) {
			result1 = "330";
		} else if ((item.CategoryName).contains("��ġ")) {
			result1 = "340";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "350";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "360";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "370";
		} else if ((item.CategoryName).contains("ǳ��")||(item.CategoryName).contains("����")||(item.CategoryName).contains("�μ���")) {
			result1 = "380";
		} else if ((item.CategoryName).contains("����")||(item.CategoryName).contains("����")) {
			result1 = "390";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "410";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "420";
		} else if ((item.CategoryName).contains("ȭ��")) {
			result1 = "430";
		} else if ((item.CategoryName).contains("õ��")||(item.CategoryName).contains("õü")) {
			result1 = "440";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "450";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "460";
		} else if ((item.CategoryName).contains("�������")||(item.CategoryName).contains("������")) {
			result1 = "470";
		} else if ((item.CategoryName).contains("�Ĺ�")) {
			result1 = "480";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "490";
		} else if ((item.CategoryName).contains("ȭ��")) {
			if((item.CategoryName).contains("����"))result1 = "570";
			else result1 = "510";
		} else if ((item.CategoryName).contains("���")) {
			result1 = "520";
		} else if ((item.CategoryName).contains("����")||(item.CategoryName).contains("����")) {
			result1 = "530";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "540";
		} else if ((item.CategoryName).contains("���")) {
			result1 = "550";
		} else if ((item.CategoryName).contains("����")||(item.CategoryName).contains("����")) {
			result1 = "560";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "580";
		} else if ((item.CategoryName).contains("��Ȱ����")) {
			result1 = "590";
		} else if ((item.CategoryName).contains("����")||(item.CategoryName).contains("����")) {
			result1 = "620";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "630";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "640";
		} else if ((item.CategoryName).contains("ȸȭ")||(item.CategoryName).contains("��ȭ")||(item.CategoryName).contains("������")) {
			result1 = "650";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "660";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "670";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "680";
		} else if ((item.CategoryName).contains("������")||(item.CategoryName).contains("����")) {
			result1 = "690";
		} else if ((item.CategoryName).contains("�ѱ���")) {
			result1 = "710";
		} else if ((item.CategoryName).contains("�߱���")) {
			result1 = "720";
		} else if ((item.CategoryName).contains("�Ϻ���")) {
			result1 = "730";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "740";
		} else if ((item.CategoryName).contains("���Ͼ�")) {
			result1 = "750";
		} else if ((item.CategoryName).contains("��������")) {
			result1 = "760";
		} else if ((item.CategoryName).contains("�����ξ�")) {
			result1 = "770";
		} else if ((item.CategoryName).contains("��Ż���ƾ�")) {
			result1 = "780";
		} else if ((item.CategoryName).contains("��Ÿ")&&(item.CategoryName).contains("��")) {
			result1 = "790";
		} else if ((item.CategoryName).contains("�ƽþ�")) {
			result1 = "910";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "920";
		} else if ((item.CategoryName).contains("������ī")) {
			result1 = "930";
		} else if ((item.CategoryName).contains("�ϾƸ޸�ī")) {
			result1 = "940";
		} else if ((item.CategoryName).contains("���Ƹ޸�ī")) {
			result1 = "950";
		} else if ((item.CategoryName).contains("�����ƴϾ�")) {
			result1 = "960";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "980";
		} else if ((item.CategoryName).contains("����")) {
			result1 = "990";
		} else result1 = "000";
		System.out.println(result1);
		String result2 = (item.Author).substring(0,1);
		Random random = new Random();//�����ѹ� �޾ƿ���
		int rannum = random.nextInt(9);
		getChosung chosung = new getChosung();
		String cho = chosung.chosung(item.Title);
		
		return result1 + "." + result2 + rannum + cho;
	}
	
	static String getAuthorName(String author) {
		StringBuffer sb = new StringBuffer();
		
		int idx=0;
		while(author.charAt(idx)!='(') sb.append(author.charAt(idx++));
		
		return sb.toString();
	}
	
	public static String GetUrl(String searchWord) throws Exception {
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("ttbkey", "ttbmomomo12051044002");
		hm.put("Query", URLEncoder.encode(searchWord, "UTF-8"));// UTF-8Ÿ������ ���ڵ�
		hm.put("QueryType", "Title");// ������ Ÿ�� : �������� ã��(searching by book title)
		hm.put("MaxResults", "100");// �ִ�� ������ ������ ����(Maximum resultsets)
		hm.put("start", "1");// �����ֱ� ������ ������� ��ȣ(1��° ���� �����ֱ�-showing from resultset no.1)
		hm.put("SearchTarget", "Book");// ã�ƺ� ī�װ�(���������� ã�� only lookup for books)
		hm.put("output", "xml");// ��¹��("JS"�� ���� JSON���� ���. Return type. if "JS", returns in JSON form)
		hm.put("Version", "20131101");// ����-�ֽŹ������� ����(ver.20131101 is latest)
		//����. ���� ������ �˻�����.(BE ADVISED. Only korean books can be found.)
		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String val = hm.get(key);
			sb.append(key).append("=").append(val).append("&");
		}
		return BASE_URL + sb.toString();
	}

	public static void main(String[] args) throws Exception {
		String url = GetUrl("����");//å�������� ã�� �� ���� Ű���� �Ǵ� ���� ��ü(Book's title or keyword)
		AladdinOpenAPIItemSearchHandler api1 = new AladdinOpenAPIItemSearchHandler();
		api1.parseXml(url);
		
		Connection();
		int bid = findBid()+1;

		for (Item item : api1.Items) {
			if ((item.Author).contains("")) {// �۰��� 1�� ���͸�. �۰��� �޾ƿ� ���ڿ��� �ִ����� Ȯ��.(First filter by author)
				if ((item.Publisher).contains("")) {// ���ǻ�� 2�� ���͸�. ���ǻ�� �޾ƿ� ���ڿ��� ���ԵǾ� �ִ���.(Second filter by Publisher)
					System.out.println(item.Isbn);

					String sql1 = "insert into booklist values(?,?,?,?,?,?,?,?,?,?,?)";
//					String sql2 = "select bid from (select * from booklist order by rownum desc) where rownum  = 1";
					
					
					try {
						pstmt1 = conn.prepareStatement(sql1);

						System.out.println("set start");
						System.out.println(bid);
						pstmt1.setInt(1, bid);
						pstmt1.setString(2, item.Title);
						pstmt1.setString(3, getAuthorName(item.Author));
						pstmt1.setString(4, item.Publisher);
						pstmt1.setString(5, item.Isbn);
						pstmt1.setString(6, item.CategoryName);
						pstmt1.setString(7, deciDiv(item));
						pstmt1.setInt(8, 0);
						pstmt1.setString(9, item.Description);
						pstmt1.setInt(10, 0);
						pstmt1.setString(11, item.Cover);

						int res = pstmt1.executeUpdate();
						System.out.println(res + "��");
						bid+=1;

					} catch (SQLException e) {
						System.out.println("SQL Error : " + e.getMessage());
					} finally {
						if (rs != null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
						if (pstmt1 != null) {try {pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}
//						if (conn != null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
						
					}
				}
			}
		}
	}
}