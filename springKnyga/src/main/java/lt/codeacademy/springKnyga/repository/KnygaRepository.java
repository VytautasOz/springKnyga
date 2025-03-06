package lt.codeacademy.springKnyga.repository;

import lt.codeacademy.springKnyga.entity.Knyga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnygaRepository extends JpaRepository<Knyga, Integer> {
    Knyga findById(int id);
    void deleteById(int id);

    @Query("SELECT DISTINCT k.zanras FROM Knyga k")
    List<String> findDistinctGenres();

    List<Knyga> findByZanras(String zanras);

}
