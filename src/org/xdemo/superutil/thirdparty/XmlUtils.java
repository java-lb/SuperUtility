package org.xdemo.superutil.thirdparty;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.xdemo.superutil.test.Order;
import org.xdemo.superutil.test.User;

/**
 * XML序列化与反序列化工具类
 * @author Mr.LB
 * 2015年2月28日
 * @see   <a href="http://simple.sourceforge.net/download/stream/doc/tutorial/tutorial.php">Simple-XML</a>
 */
public class XmlUtils {
	
	/**
	 * 将Bean转换成XML（需要Simple-XML提供的注解）
	 * @throws Exception 
	 */
	public static void beanToXml(Object o,String xmlFile) throws Exception{
		
		Serializer serializer = new Persister();
		File file = new File(xmlFile);
		serializer.write(o, file);
	}
	
	/**
	 * Xml转Bean
	 * @param xml
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public static Object xmlToBean(String xml,Object bean) throws Exception{
		File file = new File(xml);  
		Serializer serializer = new Persister();
		return serializer.read(bean,file);
	}
	
	public static void main(String[] args) throws Exception {
		User u=new User();
		u.setAddress("xxx");
		u.setName("GGG");
		u.setAge(22);
		List<Order> ss=new ArrayList<Order>();
		beanToXml(u, "D:\\x.xml");
		u=new User();
		xmlToBean("D:\\x.xml", u);
		System.out.println(u.getAddress());
	}

}
