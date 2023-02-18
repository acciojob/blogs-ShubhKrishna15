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
        image.setBlog(blog);
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
//        Image image = imageRepository2.findById(id).get();
//        String dimensionOfImage = image.getDimensions();
//        int dimensionOfImageInInteger = ( Integer.parseInt(String.valueOf(dimensionOfImage.charAt(0))))*(Integer.parseInt(String.valueOf(dimensionOfImage.charAt(2))));
//        int screenDimensionsInInteger = ( Integer.parseInt(String.valueOf(screenDimensions.charAt(0))))*(Integer.parseInt(String.valueOf(screenDimensions.charAt(2))));
//       // int ans = 0;
//
//          int  ans = screenDimensionsInInteger/dimensionOfImageInInteger;
//        return ans;

        String [] scrarray = screenDimensions.split("X"); //A=Length   X    B=Breadth
//        if(!imageRepository2.findById(id).isPresent()){
//            throw new Exception();
//        }
        Image image = imageRepository2.findById(id).get();

        String imageDimensions = image.getDimensions();
        String [] imgarray = imageDimensions.split("X");

        int scrl = Integer.parseInt(scrarray[0]); //A -- > integer
        int scrb = Integer.parseInt(scrarray[1]); //B -- > integer

        int imgl = Integer.parseInt(imgarray[0]); //A -- > integer
        int imgb = Integer.parseInt(imgarray[1]); //B -- > integer

        return no_Images(scrl,scrb,imgl,imgb);

    }

    private int no_Images(int scrl, int scrb, int imgl, int imgb) {
        int lenC = scrl/imgl; //
        int lenB = scrb/imgb;
        return lenC*lenB;
    }





}
