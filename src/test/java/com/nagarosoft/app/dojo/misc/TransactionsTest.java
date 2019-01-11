package com.nagarosoft.app.dojo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TransactionsTest {

    @Test void shouldReturnEmptyListIfThereIsNoTransactions() {
        assertThat(Transactions.findRejectedTransactions(new ArrayList<>(), 0).size(), is(0));
    }

    @Test void shouldReturnEmptyListIfThereIsATransactionWithinCreditLimit() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,200,TR0001");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions.size(), is(0));
    }

    @Test void shouldReturnTransactionThatIsOverCreditLimit() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,100,TR0001", "John,Doe,john@doe.com,101,TR0002");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions, is(Arrays.asList("TR0002")));
    }

    @Test void shouldReturnTransactionThatIsOverCreditLimit1() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,800,TR009",
                "John,Doe,john@doe.com,900,TR0026",
                "Dan,Rn,dan@rn.com,300,TR0027",
                "Dan,Rn,dan@rn.io,300,TR0035",
                "Dan,Rn,dan@rn.i,300,TR0045");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions, is(Arrays.asList("TR009", "TR0026", "TR0027", "TR0035", "TR0045")));
    }

}
