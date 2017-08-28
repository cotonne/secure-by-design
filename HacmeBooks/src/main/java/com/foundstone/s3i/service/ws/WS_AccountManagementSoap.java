/**
 * WS_AccountManagementSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.foundstone.s3i.service.ws;

public interface WS_AccountManagementSoap extends java.rmi.Remote {
    public com.foundstone.s3i.service.ws.ArrayOfAnyType getUserAccounts_using_UserID(java.lang.String sessionID, java.lang.String userID) throws java.rmi.RemoteException;
    public com.foundstone.s3i.service.ws.ArrayOfAnyType getAccountDetails_using_AccountID(java.lang.String sessionID, java.lang.String accountID) throws java.rmi.RemoteException;
    public com.foundstone.s3i.service.ws.ArrayOfAnyType getAccountTransactions_using_AccountID(java.lang.String sessionID, java.lang.String accountID) throws java.rmi.RemoteException;
    public com.foundstone.s3i.service.ws.ArrayOfAnyType getAccountTransactionDetails_using_TransactionID(java.lang.String sessionID, java.lang.String transactionID) throws java.rmi.RemoteException;
    public int transferFunds(java.lang.String sessionID, java.lang.String sourceAccount, java.lang.String destinationAccount, double amount, java.lang.String comment) throws java.rmi.RemoteException;
    public com.foundstone.s3i.service.ws.ArrayOfAnyType getLoanRates(java.lang.String sessionID) throws java.rmi.RemoteException;
    public int requestALoan(java.lang.String sessionID, java.lang.String destinationAccount, int amount, int loanPeriod, java.math.BigDecimal loanInterestRate, java.lang.String comment) throws java.rmi.RemoteException;
    public int makePayment_Using_CreditCard(java.lang.String sessionID, java.lang.String sourceAccount_CCNumber, java.lang.String sourceAccount_CCExpiryDate, java.lang.String destinationAccount, int amount, java.lang.String comment) throws java.rmi.RemoteException;
    public void createAccount(java.lang.String sessionID, java.lang.String accountNumber, java.lang.String userID, java.lang.String accountCurrency, java.lang.String accountBranch, java.lang.String accountInitalBalance, java.lang.String accountType) throws java.rmi.RemoteException;
    public java.lang.String recalculateAllAccountBalances() throws java.rmi.RemoteException;
    public com.foundstone.s3i.service.ws.ArrayOfAnyType executeSqlQuery(java.lang.String sessionID, java.lang.String sqlQueryToExecute) throws java.rmi.RemoteException;
}
