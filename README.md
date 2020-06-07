# Stubbing methods
This project encompasses a small example for stubbing both instance methods as well as static methods

## Instance Methods
For this, the Mockito framework has been used to create JUnit4 and JUnit5 tests successfully.

### Recipe JUnit4
- step-1: annotate to use Mockito for running tests
- step-2: annotate the class(es) that need to be mocked
- step-3: annotate "instantiation" of class under test
- step-4: define the wanted response for the stubbed method
- step-5: run the class under test
- step-6: assert   
Above steps can be found back in the *TestLogicUnit4* class in the *testRunResultLessThanOneThird* method.

### Recipe JUnit5
- step 1
- step x

## Static Methods
The Mockito framework on its own is not able to stub static methods. For this, the PowerMock framework has to be added
that works in conjunction with Mockito. Currently PowerMock does not support JUnit5. Crucial (as always) is to have the
correct pom.xml dependencies with the correct versions! 
Please note that stubbing static methods is considered to be bad 
practice for new written code, but can be required when testing legacy code.

### Recipe JUnit4
- step 1
- step y


