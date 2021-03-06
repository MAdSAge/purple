package practest;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class ImagePC {	
	ArrayList<String> image_link_parser(String url) throws IOException {
		
		ArrayList<String> top= new ArrayList<String>();
		
		Document doc = Jsoup.connect(url).get();
		Elements newsHeadlines = doc.select("img");
		for (Element headline : newsHeadlines) {
		    top.add(headline.toString());		
		}
		return top;
		
	}

 	BufferedImage getResizedImage(String urlb,int bound_width,int bound_height ) throws IOException {

		
		URL url = new URL(urlb);
		BufferedImage p_image = ImageIO.read(url);
		
	    int original_width = p_image.getWidth();
	    int original_height = p_image.getHeight();
	    
	    int new_width = original_width;
	    int new_height = original_height;

	    if (original_width > bound_width) {	        
	        new_width = bound_width;	       
	        new_height = (new_width * original_height) / original_width;
	    }	 
	    if (new_height > bound_height) {	       
	        new_height = bound_height;	        
	        new_width = (new_height * original_width) / original_height;
	    }
	    
	    BufferedImage outputImage = new BufferedImage(new_width,new_height, p_image.getType());
	    
	    Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(p_image, 0, 0, new_width, new_height, null);
        g2d.dispose();
        
	    return outputImage;
	}
	
	
}
