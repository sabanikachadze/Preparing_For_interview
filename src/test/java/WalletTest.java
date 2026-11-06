import org.example.Pojos.Wallet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {

    @Test
    public void withdraw_throwsIllegalState_whenAmountExceedsBalance(){
        Wallet wallet = new Wallet(100);
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> wallet.withdraw(101));
        assertEquals("not enough money", ex.getMessage());
    }
}
