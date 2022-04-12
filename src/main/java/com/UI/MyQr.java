package com.UI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class MyQr {

    // Function to create the QR code
    public static void createQR(String data,String outputFile) throws Exception{
  
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 1000,1000);

    // Write to file image
    
    Path path = FileSystems.getDefault().getPath(outputFile);
    MatrixToImageWriter.writeToPath(matrix, "PNG", path);
    }

    // Driver code
    public static void main(String[] args)
            throws WriterException, IOException,
            NotFoundException {

      
    }
}
