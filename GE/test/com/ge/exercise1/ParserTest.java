package com.ge.exercise1;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    Parser parser;

    @Before
    public void setUp() {
        try {
            Class parserClass = Class.forName("com.ge.exercise1.MyParser");
            parser = (Parser) parserClass.newInstance();
        } catch (Exception e) {
            Assume.assumeNoException(e);
        }
    }

    @Test
    public void parseApplicationDataSimpleTest() {
        String simpleTestData = "Application(id: 0,name: MyApp,users:[User(id: 2,name: Beth Jones)],groups:[Group(id: 1,name: SimpleGroup,users:[User(id: 2,name: Beth Jones)])])";
        Application app = parser.parseApplicationData(simpleTestData);

        assertEquals("SimpleGroup", app.getGroup("1").getName());
        
        // statement commented
        //reason - incorrect statement , because app.getGroup("1") will return single Group object 
        //& we can call size() method on single object here
        //assertEquals("SimpleGroup", app.getGroup("1").size()); 
        
        assertEquals(1, app.getGroups().size());

        assertEquals("Beth Jones", app.getUser("2").getName());
    }
}