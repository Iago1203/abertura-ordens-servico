package br.com.ordensservico.aberturaordensservico.service;

import java.util.List;
import java.util.Optional;

import br.com.ordensservico.aberturaordensservico.model.Setor;
import br.com.ordensservico.aberturaordensservico.repository.SetorRepository;

public class SetorService {
    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public Setor cadastrarSetor(Setor setor) {
        return setorRepository.save(setor);
    }

    public List<Setor> listar() {
        return setorRepository.findAll();
    }

    public Optional<Setor> buscarPorId(int id) {
        return setorRepository.findById(id);
    }

    public Optional<Setor> atualizar(
            Integer id, Setor novosdadosSetor) {
        Optional<Setor> setorEncontrado = setorRepository.findById(id);

        if (setorEncontrado.isEmpty()) {
            return Optional.empty();
        }
        Setor setor = setorEncontrado.get();
        setor.setNome(novosdadosSetor.getNome());
        return Optional.of(setorRepository.save(setor));

    }

    public boolean excluir(Integer id) {

        if (!setorRepository.existsById(id)) {
            return false;
        }
        setorRepository.deleteById(id);
        return true;
    }

}