package mission2;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssembleTest {

    void testExit() {
        // arrange
        AssembleCar assemble = mock(AssembleCar.class);

        // act
        assemble.assembleCar();

        // assert
    }
}