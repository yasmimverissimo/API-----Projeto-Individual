package Atividade.ProjetoIndividual.repository;

import Atividade.ProjetoIndividual.entity.Veiculo;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
    Optional<Veiculo> findByPlaca(String placa);
    List<Veiculo> findByMarcaContainsIgnoreCaseOrModeloContainingIgnoreCase(String marca, String modelo);
}
