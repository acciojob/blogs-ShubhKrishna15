package com.driver.services;


import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServices {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image();
        image.setDescription(description);
        image.setDimension(dimensions);
        List<Image> listOfImages = blog.getListOfImageInbBlog();
        listOfImages.add(image);
        blog.setListOfImageInbBlog(listOfImages);


        blogRepository2.save(blog);
        return image;


    }

    public void deleteImage(Integer id){
            imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[] screenArray = screenDimensions.split("X");
        Image image = imageRepository2.findById(id).get();

        String imageDimension = image.getDimension();
        String []imageArray= imageDimension.split("X");

        int screen_length = Integer.parseInt(screenArray[0]);
        int screen_breadth = Integer.parseInt(screenArray[1]);

        int image_length = Integer.parseInt(imageArray[0]);
        int image_breadth = Integer.parseInt(imageArray[1]);

        int screenArea = screen_length * screen_breadth;
        int imageArea = image_length * image_breadth;

        int ans = screenArea/imageArea;
        return ans;



    }
}
