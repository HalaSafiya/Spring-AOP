public class Client {

    private String nom;
    private Compte cp;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Compte getCp() {
        return cp;
    }

    public void setCp(Compte cp) {
        this.cp = cp;
    }

    @LogClient
    public void retirer(double mnt){
        cp.debiter(mnt);
    }
    @LogClient
    public void verser(double mnt){
        cp.approvisionner(mnt);
    }
}
