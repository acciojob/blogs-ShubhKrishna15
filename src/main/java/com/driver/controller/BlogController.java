package com.driver.controller;
import com.driver.services.BlogServices;
import com.driver.models.Blog;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogServices blogServices;

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestParam Integer userId ,
                                     @RequestParam String title,
                                     @RequestParam String content) {
        Blog blog=blogServices.createAndReturnBlog(userId,title,content);
        return new ResponseEntity<>(blog,HttpStatus.CREATED);
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int blogId) {
        blogServices.deleteBlog(blogId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




