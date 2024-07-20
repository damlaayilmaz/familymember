package org.example.famtree.MemberRepository;
import org.example.famtree.model.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<member, Long> {
    Optional<member> findByName(String name);
    Optional<member> findByEmail(String email);
    Optional<member> findById();
}
