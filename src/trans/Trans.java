package trans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;

public class Trans {
	public static void main(String[] args) {
		
//		File f = new File("Data/teams");
//		File[] fl = f.listFiles();
//		for(File fff : fl) {
//			if(fff.getName().equals("teams")) continue;
//			System.out.println(fff.getAbsolutePath());
//			sss(fff.getAbsolutePath());
//		}
		
		
		
		
//		File f = new File("Data/teams");
//		File[] fl = f.listFiles();
//		for(File fff : fl) {
//			if(fff.getName().charAt(fff.getName().length() - 2) == 'n')
//				fff.delete();
//		}
	}
	
	public static void sss(String svgUrl) {
		String pngUrl = svgUrl.substring(0, svgUrl.length() - 3) + "png";
		
		File png = new File(pngUrl);
		FileOutputStream fos = null;
		try {
			png.createNewFile();
		} catch (IOException e) {
			System.out.println("imageBuffer create fail");
			e.printStackTrace();
		}
		try {
			fos = new FileOutputStream(png);
		} catch (FileNotFoundException e) {
			System.out.println("imageBuffer not found");
			e.printStackTrace();
		}
		convertToPNG(svgUrl, fos);
	}
	
	public static void convertToPNG(String url, OutputStream os) {
		File svg = new File(url);
		Document doc = null;
		try {
			doc = new SAXSVGDocumentFactory(
					XMLResourceDescriptor.getXMLParserClassName())
					.createDocument(svg.toURI().toString());
		} catch (IOException e) {
			System.out.println("document create fail");
			e.printStackTrace();
		}
		PNGTranscoder trans = new PNGTranscoder();
		TranscoderInput input = new TranscoderInput(doc);
		TranscoderOutput output = new TranscoderOutput(os);
		try {
			trans.transcode(input, output);
		} catch (TranscoderException e) {
			System.out.println("trans fail");
			e.printStackTrace();
		}
		try {
			os.flush();
		} catch (IOException e) {
			System.out.println("os flush fail");
			e.printStackTrace();
		}
		if (os != null)
			try {
				os.close();
			} catch (IOException e) {
				System.out.println("os close fail");
				e.printStackTrace();
			}

	}
}
