/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.DAO;

/**
 *
 * @author Antonio Junior
 */
public enum UnidadeDePersistencia{
    Derby("JPAAtividadeDerby");
    
   private String descricao;
//   private String descricao;
   
   private UnidadeDePersistencia(String descricao){
   this.setDescricao(descricao);
   }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
   
}