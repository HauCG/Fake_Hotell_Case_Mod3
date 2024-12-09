package org.example.temporary.controller;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PdfExportExample {
    public static void main(String[] args) {
        // Đường dẫn fil e PDF xuất ra
        String dest = "output.pdf";

        try {
            // Khởi tạo PdfWriter để ghi nội dung vào file
            PdfWriter writer = new PdfWriter(dest);

            // Tạo PdfDocument và liên kết với PdfWriter
            PdfDocument pdfDoc = new PdfDocument(writer);

            // Tạo Document để thêm nội dung
            Document document = new Document(pdfDoc);

            // Thêm nội dung vào tài liệu PDF
            document.add(new Paragraph("Hello, this is a PDF created with iText."));
            document.add(new Paragraph("Đây là đoạn văn bản thứ hai trong tài liệu."));

            // Đóng tài liệu
            document.close();

            System.out.println("PDF created successfully! File saved at: " + dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}