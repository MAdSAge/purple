package practest;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class soup_fun {
	
	String Q_mage(quesion_data a) {
		
		String q_mage = a.getImages();
		Document dot = Jsoup.parse(q_mage);  
		Element sot = dot.select("img").first();
		String mig = sot.attr("src");		
		
		return mig;		
	}
	
	ArrayList<String> E_images(quesion_data b) {
		ArrayList<String> list = new ArrayList<>();		
		String exp = b.getExplant();		
		Document dot = Jsoup.parse(exp);  
		Elements sot = dot.select("img");
		for(Element i1:sot) {			
			String mig = i1.attr("src");
			list.add(mig);
		}
		return list;
		
	}

}
