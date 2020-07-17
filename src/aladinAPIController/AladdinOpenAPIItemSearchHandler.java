package aladinAPIController;

import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

class Item {
	public String Title = "";// item 안의 제목 항목 받아올 준비(get ready to get "title")
	public String Author = "";// 저자 항목 받아올 준비
	public String Publisher = "";//출판사
	public String Cover ;//표지
	public String Isbn = "";//ISBN
	public String Description = "";//설명(축약)-short descriptions
	public String CategoryName = "";//카테고리
}

class AladdinOpenAPIItemSearchHandler extends DefaultHandler {
	public List<Item> Items;// 검색 결과인 아이템들을 받아와서 리스트로 정렬 (list of results)
	private Item currentItem;// 검색 결과로 받아온 아이템들(items belongs to results)
	private boolean inItemElement = false;
	private String tempValue;
	public AladdinOpenAPIItemSearchHandler() {
		Items = new ArrayList<Item>();
	}

	public void startElement(String namespace, String localName, String qName, Attributes atts) {
		if (localName.equals("item")) {//아이템들 받을 저장공간 생성(Opening space for saving items)
			currentItem = new Item();
			inItemElement = true;
		} else if (localName.equals("title")) {
			tempValue = "";
		} else if (localName.equals("author")) {
			tempValue = "";
		} else if (localName.equals("publisher")) {
			tempValue = "";
		} else if (localName.equals("isbn")) {
			tempValue = "";
		} else if (localName.equals("description")) {
			tempValue = "";
		} else if (localName.equals("cover")) {
			tempValue = "";
		} else if (localName.equals("categoryName")) {
			tempValue = "";
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		tempValue = tempValue + new String(ch, start, length);
	}

	public void endElement(String namespaceURI, String localName, String qName) {
		if (inItemElement) {//저장 공간에 아이템들 넣어주기(items injesct into space)
			if (localName.equals("item")) {
				Items.add(currentItem);
				currentItem = null;
				inItemElement = false;
			} else if (localName.equals("title")) {
				currentItem.Title = tempValue;
			} else if (localName.equals("author")) {
				currentItem.Author = tempValue;
			} else if (localName.equals("publisher")) {
				currentItem.Publisher = tempValue;
			} else if (localName.equals("isbn")) {
				currentItem.Isbn = tempValue;
			} else if (localName.equals("description")) {
				currentItem.Description = tempValue;
			} else if (localName.equals("cover")) {
				currentItem.Cover = tempValue;
			}else if (localName.equals("categoryName")) {
				currentItem.CategoryName = tempValue;
			}
		}
	}

	public void parseXml(String xmlUrl) throws Exception {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		ParserAdapter pa = new ParserAdapter(sp.getParser());
		pa.setContentHandler(this);
		pa.parse(xmlUrl);
	}
}