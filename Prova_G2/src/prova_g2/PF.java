/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_g2;

/**
 *
 * @author alu201815484
 */
public class PF  extends Pessoa implements Aniversario  {
    
    private String cpf;

    public PF(String nome, int idade) {
        super(nome, idade);
    }
    
    public PF(String nome, int idade, String cpf) {
        super(nome, idade);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
