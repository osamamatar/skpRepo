package com.osama.skp.dao;

import com.osama.skp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    void deleteAllByIdIn(Collection<Long> ids);
}
