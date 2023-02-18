package com.driver.services;


import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        List<Image> listOfImages = blog.getImageList();
        listOfImages.add(image);
        blog.setImageList(listOfImages);


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

        String imageDimension = image.getDimensions();
        String []imageArray= imageDimension.split("X");

        int screen_length = Integer.parseInt(screenArray[0]);
        int screen_breadth = Integer.parseInt(screenArray[1]);

        int image_length = Integer.parseInt(imageArray[0]);
        int image_breadth = Integer.parseInt(imageArray[1]);

        int leng = screen_length/image_length;
        int breadth =  screen_breadth/image_length;

        int ans = leng*breadth;
        return ans;



    }
}
