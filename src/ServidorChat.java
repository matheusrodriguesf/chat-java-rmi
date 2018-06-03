
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class ServidorChat {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Scanner leia = new Scanner(System.in);
        ServicoChat obj = new SerivcoChatImpl();
        List<ServicoChat> clientes = new ArrayList<ServicoChat>();
        System.out.println("Servidor de Chat funcionando!!!");
        System.out.println("Entre com o seu nickname: ");
        String nickname = leia.nextLine();
        obj.setnickName(nickname);
        Naming.rebind("Chat", obj);
        while (true) {
            String msg = leia.nextLine();
            obj.setmensagem(msg);
            obj.editCliente();
            if (!obj.getnickName().isEmpty()) {
                msg = "Mensagem - " + obj.getnickName() + ": " + msg;

                clientes = obj.getlistClientes();
                for (ServicoChat lista : clientes) {
                    lista.send(msg);
                }
            }
        }
    }
}
