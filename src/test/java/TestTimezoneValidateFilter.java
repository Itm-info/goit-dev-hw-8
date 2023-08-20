import itm.HttpWorks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestTimezoneValidateFilter {
    @Test
    public void testTimezoneValidateFilterOnAbsentParamWorksOk() throws IOException {
        int actual = HttpWorks.httpGetResponseCode("http://localhost:8080/hw/time");
        int expected = 200;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTimezoneValidateFilterOnValidParamUCTPlusNumberWorksOk() throws IOException {
        int actual = HttpWorks.httpGetResponseCode("http://localhost:8080/hw/time?timezone=UTC+2");
        int expected = 200;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTimezoneValidateFilterOnValidParamNameWorksOk() throws IOException {
        int actual = HttpWorks.httpGetResponseCode("http://localhost:8080/hw/time?timezone=Europe/Kyiv");
        int expected = 200;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTimezoneValidateFilterOnInvalidParamWorksOk() throws IOException {
        int actual = HttpWorks.httpGetResponseCode("http://localhost:8080/hw/time?timezone=UTC-10000");
        int expected = 400;
        Assertions.assertEquals(expected, actual);
    }

}
