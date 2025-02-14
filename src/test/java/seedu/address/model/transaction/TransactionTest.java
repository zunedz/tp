package seedu.address.model.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TransactionUtil.TRANSACTION_ONE;
import static seedu.address.testutil.TransactionUtil.TRANSACTION_ONE_INCOMPLETE;
import static seedu.address.testutil.TransactionUtil.TRANSACTION_TWO;
import static seedu.address.testutil.TransactionUtil.VALID_AMOUNT_ONE;
import static seedu.address.testutil.TransactionUtil.VALID_ID;
import static seedu.address.testutil.TransactionUtil.VALID_TRANSACTION_DATE_ONE;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void constructor_null_throwsNullArgumentException() {
        assertThrows(NullPointerException.class, () -> new Transaction((Collection<TransactionField>) null, VALID_ID));
    }

    @Test
    public void constructor_missingRequiredField_throwsIllegalArgumentException() {
        // Missing Transaction Date Field
        List<TransactionField> incompleteArgumentsOne = List.of(
                new Amount(VALID_AMOUNT_ONE)
        );
        assertThrows(IllegalArgumentException.class, () -> new Transaction(incompleteArgumentsOne, VALID_ID));

        // Missing Amount Field
        List<TransactionField> incompleteArgumentsTwo = List.of(
                    new TransactionDate(VALID_TRANSACTION_DATE_ONE)
        );
        assertThrows(IllegalArgumentException.class, () -> new Transaction(incompleteArgumentsTwo, VALID_ID));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Transaction transactionCopy = new Transaction(TRANSACTION_ONE);
        assertEquals(TRANSACTION_ONE, transactionCopy);

        // same object -> returns true
        assertEquals(TRANSACTION_ONE, TRANSACTION_ONE);

        // null -> returns false
        assertNotEquals(null, TRANSACTION_ONE);

        // different type -> returns false
        assertNotEquals("TRANSACTION_ONE", TRANSACTION_ONE);

        // different Transaction -> returns false
        assertNotEquals(TRANSACTION_ONE, TRANSACTION_TWO);

        // some fields are missing -> return false
        assertNotEquals(TRANSACTION_ONE, TRANSACTION_ONE_INCOMPLETE);
    }
}
