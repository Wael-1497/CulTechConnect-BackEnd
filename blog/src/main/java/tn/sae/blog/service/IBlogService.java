package tn.sae.blog.service;

        import tn.sae.blog.entity.Blog;

        import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlogPosts();
    Blog getBlogPostById(Integer postId);
    Blog createBlogPost(Blog blogPost);
    Blog updateBlogPost(Integer postId, Blog updatedBlogPost);
    void deleteBlogPost(Integer postId);
}
