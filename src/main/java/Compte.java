public class Compte {
    private double solde;

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    public void debiter(double mnt){
        solde-=mnt;
    }
    public void approvisionner(double mnt){
        solde+=mnt;
    }
}
