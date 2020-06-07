package nl.bestego.mocking;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

// step-1: annotate to use Mockito for running tests
@RunWith(MockitoJUnitRunner.class)
public class TestLogicJunit4 {

    // step-2: annotate the class(es) that need to be mocked
    @Mock
    Random rnd;

    // step-3: annotate "instantiation" of class under test
    @InjectMocks
    Logic systemUnderTest;

    @Test
    public void testRunResultLessThanOneThird() throws RandomException {
        String expected = "Random less than 1/3";
        // step-4: define the wanted response for the stubbed method
        given(rnd.random()).willReturn(false);

        // step-5: run the class under test
        String actual = systemUnderTest.run();

        // step-6: assert
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