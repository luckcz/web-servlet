package com.kaicom.servlet.dom;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jSaxRead {
	public static void main(String[] args) {
		//获得document
		SAXReader saxRead = new SAXReader();
		try {
			Document document = saxRead.read(new File("WebContent\\WEB-INF/web.xml"));
			Element rootElement = document.getRootElement();
			System.out.println(rootElement.attributeValue("version"));
			
			//获取所有的子元素
			List<Element> childElements = rootElement.elements();
			for(Element element : childElements){
				//获取元素名
				System.out.println("元素名称"+element.getName());
				
				//处理Servlet标签，并且获得字标签内容
				if("servlet".equals(element.getName())){
					//方式一：获取元素对象，然后获取文本
					Element servletNameElement = element.element("servlet-name");
					System.out.println(servletNameElement.getText());
					
					//方式二：获取元素文本值
					String servletClassElement = element.elementText("servlet-class");
					System.out.println(servletClassElement);
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
