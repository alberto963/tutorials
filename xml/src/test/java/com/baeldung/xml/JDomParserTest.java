package com.baeldung.xml;

import org.jdom2.Element;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class JDomParserTest {
	
	private final String fileName = "src/test/resources/example.xml";

	private JDomParser parser;
	
	@Test
	public void getFirstElementListTest() {
		parser = new JDomParser(new File(fileName));
		List<Element> firstList = parser.getAllTitles();

		assertNotNull(firstList);
		assertTrue(firstList.size() == 4);
		assertTrue(firstList.get(0).getAttributeValue("type").equals("java"));
	}
	
	@Test
	public void getElementByIdTest() {
		parser = new JDomParser(new File(fileName));
		Element el = parser.getNodeById("03");
		
		String type = el.getAttributeValue("type");
		assertEquals("android", type);
	}
	
}
