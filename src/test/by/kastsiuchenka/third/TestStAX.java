package test.by.kastsiuchenka.third;

import by.kastsiuchenka.third.stax.ToyStAXBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TestStAX {
    private static Logger testLogger = LogManager.getRootLogger();
    private final String FILE_NAME_STAX = "data/toys.xml";


    @Test(enabled = true, priority = 1)
    public void testSAX() {
        ToyStAXBuilder staxBuilder = new ToyStAXBuilder();
        staxBuilder.buildSetToys(FILE_NAME_STAX);
        int numberСreatedToys = staxBuilder.getToys().size();
        testLogger.info(staxBuilder.getToys());
        AssertJUnit.assertEquals(7, numberСreatedToys);
    }

}
