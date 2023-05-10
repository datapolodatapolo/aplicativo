package com.leitor.usuariok

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.SparseArray
import android.view.SurfaceHolder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.util.isNotEmpty
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import com.leitor.usuariok.R.layout.activity_cam_barra
import com.leitor.usuariok.R.layout.activity_camera
import com.leitor.usuariok.databinding.ActivityCamBarraBinding

class Cam_Barra : AppCompatActivity() {
   // private lateinit var binding: ActivityMainBinding
   private lateinit var binding: ActivityCamBarraBinding
           private val requestCodeCameraPermission = 1001

    private lateinit var cameraSource: CameraSource
    private lateinit var detector: BarcodeDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  binding = ActivityMainBinding.inflate(layoutInflater)
        binding = ActivityCamBarraBinding.inflate(layoutInflater)
      setContentView(binding.root)
        setContentView(R.layout.activity_cam_barra)
       // setContentView(activity_cam_barra)
        if (ContextCompat.checkSelfPermission(
                this@Cam_Barra,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            askForCameraPermission()

        } else {
            setupControls()
        }
    }


    private fun setupControls() {

        detector = BarcodeDetector.Builder(this@Cam_Barra).build()
        cameraSource = CameraSource.Builder(this@Cam_Barra, detector)
            .setAutoFocusEnabled(true)
            .build()


        detector.setProcessor(processor)
    }


    private fun askForCameraPermission() {
        ActivityCompat.requestPermissions(
            this@Cam_Barra,
            arrayOf(android.Manifest.permission.CAMERA), requestCodeCameraPermission
        )

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == requestCodeCameraPermission && grantResults.isNotEmpty())
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupControls()

            } else {
                Toast.makeText(applicationContext, "Permissao Negada", Toast.LENGTH_LONG)
                    .show()
            }
    }

    private val surgaceCallback = object : SurfaceHolder.Callback {


        override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

        }

        override fun surfaceDestroyed(holder: SurfaceHolder) {
            cameraSource.stop()
        }

        override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
            if (ActivityCompat.checkSelfPermission(
                    this@Cam_Barra, Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            cameraSource.start(surfaceHolder)
            try {

            } catch (exception: Exception) {
                Toast.makeText(applicationContext, "Código de Barras invalido", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
    private val processor = object : Detector.Processor<Barcode> {
        override fun release() {

        }

        override fun receiveDetections(detections: Detector.Detections<Barcode>) {

            if (detections != null && detections.detectedItems.isNotEmpty()) {

                val qrCodes: SparseArray<Barcode> = detections.detectedItems
                val code = qrCodes.valueAt(0)
                val usuario1 = usuario()
                usuario1.cam = binding.ScanResult.toString()


            }


        }
    }
}

