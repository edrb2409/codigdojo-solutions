package com.nagarosoft.app.dojo.misc;

import java.util.*;

public class Transactions {

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        if(transactions.isEmpty()) return new ArrayList<>();

        List<String> transactionRejected = new LinkedList<>();
        Map<String, Integer> customersWithCreditLine = new HashMap<>();

        transactions.stream()
                .map(Transactions::parse)
                .forEachOrdered(trx -> {
                    if(!customersWithCreditLine.containsKey(trx.getCustomer()))
                        customersWithCreditLine.put(trx.getCustomer(), creditLimit);

                    int currentCreditLimit = customersWithCreditLine.get(trx.getCustomer());

                    if(trx.getValue() > currentCreditLimit)
                        transactionRejected.add(trx.getId());
                    else
                        customersWithCreditLine.put(trx.getCustomer(), currentCreditLimit - trx.getValue());

                });

        return transactionRejected;
    }

    private static Transaction parse(final String transaction) {
        final String[] values = transaction.split(",");

        final String customer = new StringBuilder(values[0]).append(values[1]).append(values[2]).toString();

        return new Transaction(values[4], customer, Integer.valueOf(values[3]));
    }

    private static class Transaction {

        private final String id;

        private final String customer;

        private final Integer value;

        Transaction(String id, String customer, Integer value) {
            this.id = id;
            this.customer = customer;
            this.value = value;
        }

        String getCustomer() {
            return customer;
        }

        String getId() {
            return id;
        }

        Integer getValue() {
            return value;
        }
    }





}
