
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class ClienteChat {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Scanner leia = new Scanner(System.in);
        List<ServicoChat> list_clientes = new ArrayList<ServicoChat>();
        ServicoChat cliente = new SerivcoChatImpl();
        System.out.println("Entre com o nickname: ");
        String nickname = leia.nextLine();
        cliente.setnickName(nickname);
        ServicoChat server = (ServicoChat) Naming.lookup("//localhost/Chat");
        System.out.println("Chat Aberto");
        server.addCliente(cliente);
        while (true) {
            String message = leia.nextLine();
            server.setmensagem(message);
            server.send("Messagem: " + server.getmensage() + server.getnickName());
            server.editCliente();
            list_clientes = server.getlistClientes();
            for (ServicoChat lista : list_clientes) {
                if (!lista.equals(cliente)) {
                    lista.send(message);
                }
            }
        }

    }
}
