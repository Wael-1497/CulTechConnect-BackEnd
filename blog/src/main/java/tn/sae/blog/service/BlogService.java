package tn.sae.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.sae.blog.entity.Blog;
import tn.sae.blog.repository.BlogRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    @Autowired
    BlogRepository blogRepository;

    public List<Blog> getAllBlogPosts() {
        return blogRepository.findAll();
    }

    public Blog getBlogPostById(Integer postId) {
        Optional<Blog> blogPost = blogRepository.findById(postId);
        return blogPost.orElse(null);
    }

    public Blog createBlogPost(Blog blogPost) {
        return blogRepository.save(blogPost);
    }

    public Blog updateBlogPost(Integer postId, Blog updatedBlogPost) {
        Optional<Blog> existingBlogPost = blogRepository.findById(postId);
        if (existingBlogPost.isPresent()) {
            updatedBlogPost.setId(existingBlogPost.get().getId());
            return blogRepository.save(updatedBlogPost);
        }
        return null;
    }

    public void deleteBlogPost(Integer postId) {
        blogRepository.deleteById(postId);
    }
}
