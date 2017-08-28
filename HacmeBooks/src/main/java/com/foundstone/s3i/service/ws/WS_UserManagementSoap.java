/**
 * WS_UserManagementSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.foundstone.s3i.service.ws;

public interface WS_UserManagementSoap extends java.rmi.Remote {
    public java.lang.String login(java.lang.String loginID, java.lang.String password) throws java.rmi.RemoteException;
    public com.foundstone.s3i.service.ws.ArrayOfAnyType listCurrentUsers(java.lang.String sessionID) throws java.rmi.RemoteException;
    public com.foundstone.s3i.service.ws.ArrayOfAnyType getUserDetail_using_userName(java.lang.String sessionID, java.lang.String userName) throws java.rmi.RemoteException;
    public com.foundstone.s3i.service.ws.ArrayOfAnyType getUserDetail_using_userID(java.lang.String sessionID, java.lang.String userID) throws java.rmi.RemoteException;
    public com.foundstone.s3i.service.ws.ArrayOfAnyType getUserDetail_using_loginID(java.lang.String sessionID, java.lang.String loginID) throws java.rmi.RemoteException;
    public void createUser(java.lang.String sessionID, java.lang.String userName, java.lang.String loginID, java.lang.String userPassword) throws java.rmi.RemoteException;
    public void updateUserDetails(java.lang.String sessionID, java.lang.String userID, java.lang.String userName, java.lang.String loginID, java.lang.String userPassword) throws java.rmi.RemoteException;
    public void changeUserPassword(java.lang.String sessionID, java.lang.String userID, java.lang.String newPassword) throws java.rmi.RemoteException;
    public int deleteUser(java.lang.String sessionID, java.lang.String userID) throws java.rmi.RemoteException;
}
