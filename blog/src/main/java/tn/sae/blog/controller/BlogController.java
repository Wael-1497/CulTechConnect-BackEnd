package tn.sae.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sae.blog.entity.Blog;
import tn.sae.blog.service.BlogService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired

    private BlogService blogService;

    @GetMapping("/postss")
    public List<Blog> getAllBlogPosts() {
        return blogService.getAllBlogPosts();
    }

    @GetMapping("/posts/{postId}")
    public Blog getBlogPostById(@PathVariable Integer postId) {
        return blogService.getBlogPostById(postId);
    }

    @PostMapping("/posts")
    public Blog createBlogPost(@RequestBody Blog blogPost) {
        return blogService.createBlogPost(blogPost);
    }

    @PutMapping("/posts/{postId}")
    public Blog updateBlogPost(@PathVariable Integer postId, @RequestBody Blog updatedBlogPost) {
        return blogService.updateBlogPost(postId, updatedBlogPost);
    }

    @DeleteMapping("/posts/{postId}")
    public void deleteBlogPost(@PathVariable Integer postId) {
        blogService.deleteBlogPost(postId);
    }
}
