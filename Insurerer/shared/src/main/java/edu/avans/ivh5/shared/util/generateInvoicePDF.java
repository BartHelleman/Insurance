/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.util;

import java.io.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import edu.avans.ivh5.shared.models.Client;
import java.io.FileOutputStream;
import edu.avans.ivh5.shared.models.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.UUID;

/**
 *
 * @author oguzhan
 */
public class generateInvoicePDF {

    public static String getInvoicePDF(Invoice invoice)
    {
        try {
            Document document = new Document(PageSize.A4);
            Document treatmentPage = new Document(PageSize.A4);
            Document clientPage = new Document(PageSize.A4);
            Document insuranceCompanyPage = new Document(PageSize.A4);
            String fileName = UUID.randomUUID().toString();
            FileOutputStream stream = new FileOutputStream(fileName + ".pdf");
            PdfWriter.getInstance(document, stream);
            document.open();

            addMetaData(document);
            addTitlePage(document, invoice);

            document.close();
            return fileName;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private static void createTable(Paragraph preface, Invoice invoice) {
        PdfPTable table = new PdfPTable(2);

        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        table.addCell("Klantgegevens");
        table.addCell("Bedrijfsgegevens");
        table.addCell(invoice.getClientName());
        table.addCell(invoice.getCompanyName());
        table.addCell(invoice.getClientAddress());
        table.addCell(invoice.getCompanyAddress());
        table.addCell(invoice.getClientPostcodeCity());
        table.addCell(invoice.getCompanyPostcodeCity());
        table.addCell("");
        table.addCell("KVK nummer: " + invoice.getCompanyKVK());
        //table.addCell("");
        //table.addCell("Bankgegevens bedrijf");
        //table.addCell("");
        //table.addCell("BTW-nummer bedrijf");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);
    }

    private static void createTable2(Paragraph preface, Invoice invoice) {
        PdfPTable table = new PdfPTable(1);

        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        table.addCell(" Factuur nummer: " + invoice.getInvoiceNumber());
        table.addCell(" Factuuratum: " + DateFormatter.dateToString(invoice.getDate()));
        table.addCell(" Vervaldatum: " + DateFormatter.dateToString(invoice.getExpirationDate()));
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);
    }

    private static void createTable3(Paragraph preface, Invoice invoice) {
        PdfPTable table = new PdfPTable(4);

        //PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        //cell.setColspan(3);
        // table.addCell(cell);
        table.addCell(" Behandelcode ");
        table.addCell(" Aantal sessies ");
        table.addCell(" Prijs per sessie ");
        table.addCell(" Totaal ");
        table.addCell(invoice.getTreatmentCode());
        table.addCell(invoice.getAmountSessions());
        table.addCell(" € " + invoice.getPricePerSession());
        table.addCell(" € " + invoice.getTotalPrice().toString());
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);
    }

    private static void createTable4(Paragraph preface, Invoice invoice) {
        PdfPTable table = new PdfPTable(2);

        //PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        //cell.setColspan(3);
        // table.addCell(cell);
        
        table.addCell("Oude eigenrisico");
        table.addCell("Vergoede bedrag");
        table.addCell("€ " + invoice.getOldDeductible().toString());
        table.addCell("€ " + invoice.getAmountReimbursed());
        table.addCell("Huidige eigenrisco");
        table.addCell("Te betalen");
        table.addCell("€ " + invoice.getDeductible().toString());
        table.addCell("€ " + invoice.getAmountToPay().toString());
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);

    }

    private static void createTable5(Paragraph preface) {
        PdfPTable table = new PdfPTable(1);

        //PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        //cell.setColspan(3);
        // table.addCell(cell);
        table.addCell("Gelieve te betalen binnen 30 dagen");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);
    }

    private BaseFont bfBold;
    private BaseFont bf;
    private int pageNumber = 0;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public generateInvoicePDF(Treatment treatment, Client client, InsuranceCompany insuranceCompany) throws Exception {
        /*try {
            Document document = new Document(PageSize.A4);
            Document treatmentPage = new Document(PageSize.A4);
            Document clientPage = new Document(PageSize.A4);
            Document insuranceCompanyPage = new Document(PageSize.A4);

            PdfWriter.getInstance(document, new FileOutputStream("Factuur.pdf"));
            document.open();

            addMetaData(document);
            addTitlePage(document, treatment, client, insuranceCompany);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Oguzhan Babaarslan");
        document.addCreator("Oguzhan Babaarslan");
    }

    private static void addTitlePage(Document document, Invoice invoice)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        // addEmptyLine(preface, (int) 0.5);
        // Lets write a big header
        preface.add(new Paragraph("Factuur"));

        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, (int) 1);
        preface.add(paragraph);

        createTable(preface, invoice);

        createTable2(preface, invoice);

        createTable3(preface, invoice);

        createTable4(preface, invoice);

        createTable5(preface);

        document.add(preface);
        // Start a new page
        document.newPage();
    }

    private static void addContent(Document document) throws DocumentException {
        Anchor anchor = new Anchor("Factuur12", catFont);
        anchor.setName("Factuur");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
        
        // add a list
        //createList(subCatPart);
        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, (int) 1);
        catPart.add(paragraph);

        // add a table
        createTable(catPart);

        createTable2(catPart);

        createTable3(catPart);

        createTable4(catPart);

        createTable5(catPart);

        // now add all this to the document
        document.add(catPart);

    }

    private static void createTable(Section preface)
            throws BadElementException {

        PdfPTable table = new PdfPTable(2);

        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        table.addCell("Naam klant");
        table.addCell("Naam bedrijf");
        table.addCell("Adres Klant");
        table.addCell("Adres Bedrijf");
        table.addCell("Postcode + Plaats klant ");
        table.addCell("Postcode + Plaats klant");
        table.addCell("");
        table.addCell("telefoonnummer bedrijf");
        table.addCell("");
        table.addCell("Bankgegevens bedrijf");
        table.addCell("");
        table.addCell("BTW-nummer bedrijf");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);

    }

    private static void createTable2(Section preface)
            throws BadElementException {

        PdfPTable table = new PdfPTable(1);

        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        table.addCell("Factuur nummer");
        table.addCell("Factuuratum");
        table.addCell("Vervaldatum");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);

    }

    private static void createTable3(Section preface)
            throws BadElementException {

        PdfPTable table = new PdfPTable(4);

        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        table.addCell("Behandelcode");
        table.addCell("Aantal sessies");
        table.addCell("Prijs per sessie");
        table.addCell("Totaal");
        table.addCell("AAA01CS");
        table.addCell("2");
        table.addCell("€ 30");
        table.addCell("€ 60");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);

    }

    private static void createTable4(Section preface)
            throws BadElementException {

        PdfPTable table = new PdfPTable(2);

        //PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        //cell.setColspan(3);
        // table.addCell(cell);
        table.addCell("Eigenrisco");
        table.addCell("Te betalen");
        table.addCell("€ 140");
        table.addCell("€ 0");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);

    }

    private static void createTable5(Section preface)
            throws BadElementException {

        PdfPTable table = new PdfPTable(1);

        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        table.addCell("Gelieve te betalen binnen 30 dagen");
        table.addCell(" ");
        table.addCell(" ");

        preface.add(table);

    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }

    }
}
