package com.leitor.usuariok;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Camera extends AppCompatActivity {
    Button btn_scan;
    TextView visual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);




        btn_scan = findViewById(R.id.scanner);
        visual = findViewById(R.id.visualiza);

    //    File file = new File("cli.TXT");
    //    Scanner scan;
    //    try {
    //        scan = new Scanner(file);
     //       while (scan.hasNextLine()){
       //         System.out.println(scan.nextLine());

      //      }
     //   } catch (FileNotFoundException e) {
      //      throw new RuntimeException(e);
      //  }

        btn_scan.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(Camera.this);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setPrompt("Posicione no QR Code/Código");
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                intentIntegrator.initiateScan();

            }
        });
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(intentResult != null){
            String contents = intentResult.getContents();
            if(contents != null){
            visual.setText(intentResult.getContents());


            Intent navegarSegundaTela = new Intent(Camera.this, MainActivity.class);
             //   val n = Intent(this, MainActivity::cass.java)

                startActivity(navegarSegundaTela);


            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }


    }
}