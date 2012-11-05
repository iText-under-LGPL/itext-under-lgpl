/*
 * $Id$
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itextdocs.lowagie.com/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */
package com.lowagie.examples.fonts;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Embedding True Type fonts.
 */
public class UnicodeExample {
    
    /**
     * Embedding True Type Fonts.
     * @param args no arguments needed
     */
    public static void main(String[] args) {
        
        System.out.println("True Types (embedded)");
        
        // step 1: creation of a document-object
        Document document = new Document();
        
        try {
            
            // step 2: creation of the writer-object
            PdfWriter.getInstance(document, new FileOutputStream("unicode.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4: we add content to the document
            BaseFont bfComic = BaseFont.createFont("c:\\windows\\fonts\\comic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bfComic, 12);
            String text1 = "This is the quite popular True Type font 'Comic'.";
            String text2 = "Some greek characters: \u0393\u0394\u03b6";
            String text3 = "Some cyrillic characters: \u0418\u044f";
            document.add(new Paragraph(text1, font));
            document.add(new Paragraph(text2, font));
            document.add(new Paragraph(text3, font));
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        
        // step 5: we close the document
        document.close();
    }
}
