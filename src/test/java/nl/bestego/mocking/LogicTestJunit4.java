package nl.bestego.mocking;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class LogicTestJunit4 {

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

        Assertions.assertEquals(expected, actual);
    }
}