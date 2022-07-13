package br.senai.service;

import br.senai.model.Supermercado;
import br.senai.model.Usuario;
import br.senai.repository.SupermercadoRepository;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupermercadoServiceImpl implements SupermercadoService {

    @Autowired
    private SupermercadoRepository supermercadoRepository;

    @Override
    public List<Supermercado> findAll() {return supermercadoRepository.findAll();}

    @Override
    public Optional<Supermercado> findById(long id) {return supermercadoRepository.findById(id);}

    @Override
    public Supermercado create(Supermercado newSupermercado) {return supermercadoRepository.save(newSupermercado);}



    @Override
    public Supermercado update(Supermercado updatedSupermercado, long id) {
        return supermercadoRepository.findById(id)
                .map(supermercado -> {
                    supermercado.setNome(updatedSupermercado.getNome());
                    supermercado.setEndereco(updatedSupermercado.getEndereco());
                    return supermercadoRepository.save(supermercado);
                })
                .orElseGet(() ->{
                    updatedSupermercado.setId(id);
                    return  supermercadoRepository.save(updatedSupermercado);
                });
    }

    @Override
    public void delete(long id) {

    }
}
