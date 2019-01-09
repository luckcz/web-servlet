package com.kaicom.servlet.reflex;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.kaicom.servlet.respose.HelloServlet;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Map<String,String> servletUrlPattern = getServlet();
		if(null != servletUrlPattern && servletUrlPattern.size() > 0 && !servletUrlPattern.isEmpty()){
			String servletClass = "/hello";
			if(servletUrlPattern.containsKey(servletClass)){
				Class<?> forName = Class.forName(servletUrlPattern.get(servletClass));
				HelloServlet helloServlet = (HelloServlet)forName.newInstance();
				helloServlet.reflex();
			}else{
				System.out.println("没有对应的映射关系");
			}
		}else{
			System.out.println("没有注册映射");
		}
	}
	
	public static Map<String,String> getServlet(){
		Map<String,String> map = new LinkedHashMap<>();
		SAXReader read = new SAXReader();
		try {
			Document document = read.read(new File("WebContent/WEB-INF/web.xml"));
			Element rootElement = document.getRootElement();
			List<Element> childElements = rootElement.elements();
			for(Element childElement : childElements){
				if("servlet".equals(childElement.getName())){
					String servletName = childElement.elementText("servlet-name");
					String servletClass = childElement.elementText("servlet-class");
					map.put(servletName,servletClass);
				}
				
				if("servlet-mapping".equals(childElement.getName())){
					String servletName = childElement.elementText("servlet-name");
					String urlPattern = childElement.elementText("url-pattern");
					String servlateClass = map.get(servletName);
					map.put(urlPattern, servlateClass);
					map.remove(servletName);
				}
			}
			System.out.println(map);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return map;
	}
}
