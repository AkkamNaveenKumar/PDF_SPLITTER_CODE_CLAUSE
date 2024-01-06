package codeclouseproject.pdfsplitter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFSplitSingle {
	public static void main(String[] args) throws IOException {
        File oldFile = new File("///home/vishwajeet/Desktop/PDF/sample.PDF");
        PDDocument document = PDDocument.load(oldFile);

        Splitter splitter = new Splitter();
        List<PDDocument> splitPages = splitter.split(document);
        int num = 1;
        for(PDDocument mydoc : splitPages)
        {
            mydoc.save("///home/vishwajeet/Desktop/PDF/extract/split_0"+num+".pdf");
            num++;
            mydoc.close();
        }
        System.out.println("Split Done");

    }

}
