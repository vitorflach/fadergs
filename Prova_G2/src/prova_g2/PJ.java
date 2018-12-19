
package prova_g2;

public class PJ extends Pessoa implements Aniversario{
    
    private String cnpj;

    public PJ(String nome, int idade) {
        super(nome, idade);
    }
    
    public PJ(String nome, int idade, String cnpj) {
        super(nome, idade);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public void fazerAniversario(int i){
     super.setIdade(super.getIdade() + i);
    }
    
    @Override
    public void fazerAniversario(){
     super.setIdade(super.getIdade() + 1);
    }
    
    
    
    
}
