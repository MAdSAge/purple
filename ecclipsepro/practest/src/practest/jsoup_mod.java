package practest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class jsoup_mod {
	
	public static void main(String[] arg) {
		jsoup_mod in = new jsoup_mod();
		in.pepper();
	}
	
	String pepper() {
		
		String exp = "<img src=\\\"https://cdn1.dailyrounds.org/uploads/03221c0d0eaf4245bad579b47d636a6c.JPEG\\\" >";
		Document doc = Jsoup.parse(exp);
		Element div = doc.select("img").first();
		String sop = div.attr("src");
		sop+=" width=100";
		Element pop = doc.prependElement("img").attr("src", "https://cdn1.dailyrounds.org/uploads/03221c0d0eaf4245bad579b47d636a6c.JPEG");

		System.out.println(pop);
		
		

		
		
		
		return null;
	}

}
