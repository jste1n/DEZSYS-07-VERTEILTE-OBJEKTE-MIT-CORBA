package cb;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;
import org.omg.BiDirPolicy.*;
import org.omg.PortableServer.*;

/**
 * @author Hagen Aad Fock <hagen.fock@gmail.com>
 * @version 13.03.2015
 * 
 * Ruft die Echo Methode des C++ Servers auf und gibt einen String auf der Konsole aus.
 * Sollte ein Fehler aufgetreten sein, so wird eine Exception geworfen und eine Fehlermeldung zusammen mit dem Stracktrace auf der Konsole ausgegeben.
 */
public class Client extends CallBackPOA {
	public static void main(String[] args)  {
		Server ausgabe_js;
		try {
			
			/* Erstellen und intialisieren des ORB */
			ORB orb_js = ORB.init(args, null);
			
			/* Erhalten des RootContext des angegebenen Namingservices */
			Object obj_js = orb_js.resolve_initial_references("NameService");
			
			/* Verwenden von NamingContextExt */
			NamingContextExt context = NamingContextExtHelper.narrow(obj_js);
			
			/* Angeben des Pfades zum Echo Objekt */
			NameComponent[] name_js = new NameComponent[2];
			name_js[0] = new NameComponent("test","my_context");
			name_js[1] = new NameComponent("Echo", "Object");
			
			/* Aufloesen der Objektreferenzen  */
			ausgabe_js = ServerHelper.narrow(context.resolve(name_js));
			POA myRootPOA = (POA) orb_js.resolve_initial_references("RootPOA");
			myRootPOA.the_POAManager().activate();
			CallBack cb = CallBackHelper.narrow (myRootPOA.servant_to_reference (new Client()));
			ausgabe_js.one_time (cb, "Server: Heylo");
			short wait = 1;
			ausgabe_js.register(cb, "Client: How you doing?", wait);
			while (System.in.read() != '\n');
			System.err.println("Verbindung getrennt!");

		}	catch (Exception e)	{
			System.err.println("Fehlermeldung: " + e.getMessage());
			e.printStackTrace();
		}
	}
	@Override
	public void call_back (String msg){
		System.out.println("Client Callback: Nachricht erhalten: " +msg);
	}
}
