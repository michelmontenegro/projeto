package br.com.projeto.repository.usuario;

import br.com.projeto.model.usuario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * - Repository é usado no lugar do padrão DAO.
 * - Seu uso por padrão é dentro do Controle
 */

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
