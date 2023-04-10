package lk.ijse.dep9.repo;

import lk.ijse.dep9.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
