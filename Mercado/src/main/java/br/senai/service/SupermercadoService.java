package br.senai.service;

import br.senai.model.Supermercado;
import br.senai.model.Usuario;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;
import java.util.Optional;

public interface SupermercadoService {

    public List<Supermercado> findAll();
    public Optional<Supermercado> findById(long id);
    public Supermercado create(Supermercado newSupermercado);
    public Supermercado update(Supermercado updatedSupermercado, long id);
    public void delete(long id);
}
