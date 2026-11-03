package br.com.ordensservico.aberturaordensservico.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;


import br.com.ordensservico.aberturaordensservico.model.Equipamento;

import br.com.ordensservico.aberturaordensservico.repository.EquipamentoRepository;

@Service 

public class EquipamentoService {
   private final EquipamentoRepository equipamentosRepository;

    public EquipamentoService(EquipamentoRepository equipamentosRepository) {
        this.equipamentosRepository = equipamentosRepository;
    }

    public Equipamento cadastrar(Equipamento equipamento) {
        return equipamentosRepository.save(equipamento);
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
