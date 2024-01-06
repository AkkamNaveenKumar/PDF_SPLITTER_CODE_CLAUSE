package codeclouseproject.pdfsplitter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFSplitRange {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		File oldFile = new File("C:\\Users\\parthu.pj\\Downloads\\react notes utube.pdf"); // INPUT FILE PATH
		PDDocument document = PDDocument.load(oldFile);
		File newFileDestination = new File("D:\\PDF_SPLITTER"); // OUTPUT FILE PATH
		// newFileDestination.mkdirs();

		Splitter splitter = new Splitter();

		// SET RANGE
	    System.out.println("Enter the starting range");
	    int start = scan.nextInt();
	    System.out.println("Enter the Ending Range");
	    int end = scan.nextInt();
		splitter.setStartPage(start); // START RANGE
		
		splitter.setEndPage(end); // END RANGE

		List<PDDocument> splitPages = splitter.split(document);

		PDDocument newDoc = new PDDocument();
		for (PDDocument mydoc : splitPages) {
			newDoc.addPage(mydoc.getPage(0));
		}
		newDoc.save(newFileDestination + "/split.pdf");// SPLIT FILE NAME
		newDoc.close();
		System.out.println("PDF Splitted");
	}

}
