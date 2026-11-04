package br.com.ordensservico.aberturaordensservico.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import br.com.ordensservico.aberturaordensservico.model.Setor;
import br.com.ordensservico.aberturaordensservico.dto.EquipamentoRequest;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;

import br.com.ordensservico.aberturaordensservico.repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.repository.SetorRepository;

@Service 

public class EquipamentoService {
   private final EquipamentoRepository equipamentosRepository;

    private final SetorRepository SetorRepository;

    public EquipamentoService(EquipamentoRepository equipamentosRepository, SetorRepository setorRepository) {
        this.equipamentosRepository = equipamentosRepository;
        this.SetorRepository = setorRepository;
    }

    public Optional <Equipamento> cadastrar(EquipamentoRequest equipamentoRequest) {
        Optional<Setor> setorEncontrado = SetorRepository.findById(equipamentoRequest.getSetorId());

        if (setorEncontrado.isEmpty()) {
            return Optional.empty();
        }
        Equipamento equipamento = new Equipamento();
        equipamento.setNome(equipamentoRequest.getNome());
        equipamento.setNumeroPatrimonio(equipamentoRequest.getNumeroPatrimonio());
        equipamento.setSetor(setorEncontrado.get());

        return Optional.of(equipamentosRepository.save(equipamento));

    }

    public List<Equipamento> listar() {
        return equipamentosRepository.findAll();
    }

    public Optional<Equipamento> buscarPorId(Integer id) {
        return equipamentosRepository.findById(id);
    }

    public Optional<Equipamento> atualizar(
            Integer id, Equipamento novosDadosEquipamento) {
        Optional<Equipamento> equipamentoEncontrado = equipamentosRepository.findById(id);

        if (equipamentoEncontrado.isEmpty()) {
            return Optional.empty();
        }
        Equipamento equipamento = equipamentoEncontrado.get();
        equipamento.setNome(novosDadosEquipamento.getNome());
        return Optional.of(equipamentosRepository.save(equipamento));
    }

    public boolean excluir(Integer id) {

        if (!equipamentosRepository.existsById(id)) {
            return false;
        }
        equipamentosRepository.deleteById(id);
        return true;
    }
}
