
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mathe
 */
public interface ServicoChat extends Remote {

    public String getnickName() throws RemoteException;
    public void setnickName(String nickname) throws RemoteException;
    public void setmensagem(String mensagem) throws RemoteException;
    public String getmensage() throws RemoteException;
    public void addCliente(ServicoChat cliente) throws RemoteException;
    public void removeCliente(ServicoChat cliente) throws RemoteException;
    public void editCliente() throws RemoteException;
    public void send(String s) throws RemoteException;
    public List<ServicoChat> getlistClientes() throws RemoteException;
}
