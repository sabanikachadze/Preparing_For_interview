package org.example.casual;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transfer {

    static void transfer(Connection con, long from, long to, BigDecimal amount)
            throws SQLException {
        String account1 = "UPDATE account SET balance = balance - ? WHERE id = ?";
        String account2 = "UPDATE account SET balance = balance + ? WHERE id = ?";

        boolean conState = con.getAutoCommit();
        try (PreparedStatement debit = con.prepareStatement(account1);
             PreparedStatement credit = con.prepareStatement(account2)) {
            con.setAutoCommit(false);

            debit.setObject(1, amount);
            debit.setLong(2, from);
            debit.executeUpdate();

            credit.setObject(1, amount);
            credit.setLong(2, to);
            credit.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(conState);
        }

    }

}
