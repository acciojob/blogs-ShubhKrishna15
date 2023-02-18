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
        Image image = imageRepository2.findById(id).get();
        String dimensionOfImage = image.getDimensions();
        int dimensionOfImageInInteger = ( Integer.parseInt(String.valueOf(dimensionOfImage.charAt(0))))*(Integer.parseInt(String.valueOf(dimensionOfImage.charAt(2))));
        int screenDimensionsInInteger = ( Integer.parseInt(String.valueOf(screenDimensions.charAt(0))))*(Integer.parseInt(String.valueOf(screenDimensions.charAt(2))));
       // int ans = 0;

          int  ans = screenDimensionsInInteger/dimensionOfImageInInteger;
        return ans;




    }
}
