package davidebraghi.U5_W3_D1_Davide_Braghi.repositories;

import davidebraghi.U5_W3_D1_Davide_Braghi.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);

    Optional<Employee> findByEmail(String email);
}
