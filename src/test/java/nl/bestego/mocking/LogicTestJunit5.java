package nl.bestego.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)

public class LogicTestJunit5 {

    @Mock
    Random rnd;
    @InjectMocks
    Logic systemUnderTest;

    @Test
    public void testRunResultLessThanOneThird() throws RandomException {
        String expected = "Random less than 1/3";
        given(rnd.random()).willReturn(false);

        String actual = systemUnderTest.run();

//        then(actual).should().contains(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testRunResultMoreThanTwoThird() throws RandomException {
        String expected = "Random greater than 2/3";
        given(rnd.random()).willReturn(true);

        String actual = systemUnderTest.run();

//        then(actual).should().contains(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testRunResultInBetween() {
        String expected = "Random between 1/3 .. 2/3";
        try {
            given(rnd.random()).willThrow(RandomException.class);
        } catch (RandomException e) { }

        String actual = systemUnderTest.run();

        assertEquals(expected, actual);

    }
}