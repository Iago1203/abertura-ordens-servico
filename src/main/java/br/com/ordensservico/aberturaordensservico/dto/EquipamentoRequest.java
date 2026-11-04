package br.com.ordensservico.aberturaordensservico.dto;


public class EquipamentoRequest {
    private Integer setorId;
    

    public EquipamentoRequest() {
    }

    public Integer getSetorId() {
        return setorId;
    }

    public void setSetorId(Integer setorId) {
        this.setorId = setorId;
    }


     private String nome;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   

    private String numeroPatrimonio;
    
    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }
}


    
