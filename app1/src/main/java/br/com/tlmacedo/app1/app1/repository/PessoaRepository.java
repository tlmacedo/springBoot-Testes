package br.com.tlmacedo.app1.app1.repository;

import br.com.tlmacedo.app1.app1.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
