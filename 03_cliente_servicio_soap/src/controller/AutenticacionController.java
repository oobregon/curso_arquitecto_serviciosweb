/**
 * AutenticacionController.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package controller;

public interface AutenticacionController extends java.rmi.Remote {
    public javabeans.Cliente obtenerCliente(java.lang.String user, java.lang.String pwd) throws java.rmi.RemoteException;
    public boolean autenticar(java.lang.String user, java.lang.String pwd) throws java.rmi.RemoteException;
}
