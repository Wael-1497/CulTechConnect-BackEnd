package tn.sae.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sae.blog.entity.Blog;

@Repository

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
