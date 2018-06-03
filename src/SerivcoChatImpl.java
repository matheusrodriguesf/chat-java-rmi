
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public class SerivcoChatImpl extends UnicastRemoteObject implements ServicoChat {

    private static final long serialVersionUID = 5179276649815567504L;
    private String nickname = null;
    private String messagem = null;
    private List<ServicoChat> listClientes = new ArrayList<ServicoChat>();

    protected SerivcoChatImpl() throws RemoteException {
        super();
        System.out.println("Instancia Servidor criada");
    }

    @Override
    public void setnickName(String nickname) throws RemoteException {
        this.nickname = nickname;
    }

    @Override
    public String getnickName() throws RemoteException {
        return this.nickname;
    }

    @Override
    public void setmensagem(String mensagem) throws RemoteException {
        this.messagem = mensagem;
    }

    @Override
    public String getmensage() throws RemoteException {
        return this.messagem;
    }

    @Override
    public void addCliente(ServicoChat cliente) throws RemoteException {
        send(getnickName() + " - " + "Conectado");
        listClientes.add(cliente);
    }

    @Override
    public void removeCliente(ServicoChat cliente) throws RemoteException {
        send(getnickName() + " - " + "Desconectado");
        listClientes.remove(cliente);

    }

    @Override
    public void editCliente() throws RemoteException {
        List<ServicoChat> aux_list = listClientes;
        for (ServicoChat lista : aux_list) {
            if (lista.equals(null)) {
                removeCliente(lista);
            }
        }
    }

    @Override
    public void send(String s) throws RemoteException {
        System.out.println(s);
    }

    @Override
    public List<ServicoChat> getlistClientes() throws RemoteException {
        return this.listClientes;
    }
}
