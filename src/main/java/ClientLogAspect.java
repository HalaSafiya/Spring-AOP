import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@Aspect
public class ClientLogAspect {
    private static final Logger logger = LogManager.getLogger(String.valueOf(ClientLogAspect.class));

    @Around("@annotation(LogClient)")
    void logMethod(ProceedingJoinPoint joinPoint)throws Throwable {

        Client client = (Client) joinPoint.getTarget();
        logger.info(new StringBuilder().append("Le client").append(client.getNom()).append("a effectue loperation")
                .append(joinPoint.getSignature().getName()).append(" d'un montant de")
                .append(joinPoint.getArgs()[0].toString()).toString());
        logger.info("Solde avant " + client.getCp().getSolde());
        double start = System.nanoTime();
        joinPoint.proceed( new Client[] {client});
        logger.info("Solde apres"+client.getCp().getSolde());
        logger.info("Le temps d'execution de l'operation est: "+(((System.nanoTime()) - start)/1000000));
    }
}