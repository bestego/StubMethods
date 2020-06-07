package nl.bestego.mocking;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

// step-1: annotate to use PowerMock for running tests
@RunWith(PowerMockRunner.class)

// step-2: annotate the class(es) that need to be mocked
@PrepareForTest({StaticRandom.class,Random.class})

public class TestLogicStaticJunit4 {

    //step-3: instantiation class under test
    Logic systemUnderTest = new Logic();

    @Test
    public void testRunResultLessThanOneThird() throws RandomException {
        String expected = "Random less than 1/3";
        // step-4: indicate that you are going to define a static mock
        mockStatic(StaticRandom.class);
        // step-5: define the wanted response for the stubbed method
        given(StaticRandom.random()).willReturn(false);

        // step-6: run the class under test
        String actual = systemUnderTest.runStatic();

//        then(actual).should().contains(expected);
        // - step-7: assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRunResultMoreThanTwoThird() throws RandomException {
        String expected = "Random greater than 2/3";
        mockStatic(StaticRandom.class);
        given(StaticRandom.random()).willReturn(true);

        String actual = systemUnderTest.runStatic();

//        then(actual).should().contains(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testRunResultInBetween() {
        String expected = "Random between 1/3 .. 2/3";
        try {
            mockStatic(StaticRandom.class);
            given(StaticRandom.random()).willThrow(RandomException.class);
        } catch (RandomException e) { }

        String actual = systemUnderTest.runStatic();

        Assertions.assertEquals(expected, actual);
    }

}