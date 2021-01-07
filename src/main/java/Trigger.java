import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Trigger implements ApplicationListener<ContextRefreshedEvent> {
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Client client = new Client();
        Compte cpt = new Compte();
        client.setCp(cpt);
        client.verser(5000.0);
        client.retirer(2300.0);
        System.out.println("Le client :"+client.getNom() + "a un solde de : " +client.getCp().getSolde());
    }
}
