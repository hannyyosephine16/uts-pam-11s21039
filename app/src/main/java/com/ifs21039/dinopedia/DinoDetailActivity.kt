package com.ifs21039.dinopedia


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ifs21039.dinopedia.databinding.ActivityDinoDetailBinding

class DinoDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDinoDetailBinding
    private var dino: MyDinoData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDinoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data dinosaurus dari intent
        dino = intent.getParcelableExtra(EXTRA_DINO)

        // Menampilkan tombol back di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (dino != null) {
            supportActionBar?.title = dino!!.dinoName
            loadData(dino!!)
        } else {
            // Jika data dinosaurus tidak ada, akhiri activity
            finish()
        }
    }

    private fun loadData(dino: MyDinoData) {
        // Menampilkan informasi dinosaurus
        binding.imgIcon.setImageResource(dino.dinoIcon)
        binding.tvNamaDetail.text = dino.dinoName
        binding.tvDeskripsi.text = dino.dinoDescription
        binding.tvKarakteristikDetail.text = dino.dinoCharacteristic
        binding.txtGrup.text = dino.dinoGroup
        binding.txtHabitat.text = dino.dinoHabitat
        binding.txtMakanan.text = dino.dinoFood
        binding.tvPanjangDetail.text = dino.dinoLength
        binding.tvTinggiDetail.text = dino.dinoHeight
        binding.txtBeratDino.text = dino.dinoWeight
        binding.tvKelemahanDino.text = dino.dinoWeakness
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Menangani klik tombol back di ActionBar
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_DINO = "extra_dino"
    }
}

//import android.os.Bundle
//import android.widget.TextView
//
//class DinoDetailActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_dino_detail)
//
//        // Ambil data dari intent
//        val dinoPeriod = intent.getStringExtra("dinoPeriod")
//        val dinoHabitat = intent.getStringExtra("dinoHabitat")
//        val dinoPhysicalCharacteristics = intent.getStringExtra("dinoPhysicalCharacteristics")
//        val dinoBehavior = intent.getStringExtra("dinoBehavior")
//        val dinoClassification = intent.getStringExtra("dinoClassification")
//
//        // Temukan TextView di layout dan set nilai-nilai yang sudah diambil
//        val dinoPeriodTextView: TextView = findViewById(R.id.dinoPeriodTextView)
//        val dinoHabitatTextView: TextView = findViewById(R.id.dinoHabitatTextView)
//        val dinoPhysicalCharacteristicsTextView: TextView = findViewById(R.id.dinoPhysicalCharacteristicsTextView)
//        val dinoBehaviorTextView: TextView = findViewById(R.id.dinoBehaviorTextView)
//        val dinoClassificationTextView: TextView = findViewById(R.id.dinoClassificationTextView)
//
//        dinoPeriodTextView.text = "Periode Hidup: $dinoPeriod"
//        dinoHabitatTextView.text = "Habitat dan Lingkungan: $dinoHabitat"
//        dinoPhysicalCharacteristicsTextView.text = "Karakteristik Fisik: $dinoPhysicalCharacteristics"
//        dinoBehaviorTextView.text = "Perilaku: $dinoBehavior"
//        dinoClassificationTextView.text = "Klasifikasi: $dinoClassification"
//    }
//
//    override fun hasWindowFocus(): Boolean {
//        return super.hasWindowFocus()
//    }
//}
