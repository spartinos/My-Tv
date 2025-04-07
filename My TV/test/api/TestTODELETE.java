package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * THIS TEST CAN BE DELETED
 */

public class TestTODELETE {

    User u1;
    Movie m1;

    @Before
    public void setUp() throws Exception
    {
        u1 = new User("Mark","Zuckerberg","MarkZuck","iOwnYourData");
        m1 = new Movie("Mario Bros","Wa-hoo",true,2022,156,"Comedy","Mario Luigi");
    }


    @Test
    public void userTest()
    {
        assertEquals("Mark",u1.getName());
        assertEquals("Zuckerberg",u1.getLastName());
        assertEquals("MarkZuck",u1.getUsername());
    }

    @Test
    public void movieTest()
    {
        assertEquals("Mario Bros",m1.getTitle());
        assertEquals("Wa-hoo",m1.getDescription());
        assertTrue(m1.getAppropriation());
        assertEquals("Comedy",m1.getGenre());
        assertEquals(2022,m1.getDateOfRelease());
        assertEquals(156,m1.getDuration());
    }
}