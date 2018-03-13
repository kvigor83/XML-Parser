package test.by.kastsiuchenka.third;

import by.kastsiuchenka.third.dom.ToysDOMBuilder;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class TestDom {
    private final String FILE_NAME_DOM = "data/toys.xml";


    @Test(enabled = true, priority=1)
    public void testDOM() {
        ToysDOMBuilder domBuilder = new ToysDOMBuilder();
        domBuilder.buildSetToys(FILE_NAME_DOM);
        System.out.println(domBuilder.getToys());
        int numberСreatedToys  = domBuilder.getToys().size();
        AssertJUnit.assertEquals(16, numberСreatedToys);

    }
}
