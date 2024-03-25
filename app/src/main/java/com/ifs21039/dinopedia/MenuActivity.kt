package com.ifs21039.dinopedia


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21039.dinopedia.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity(), MyDinoAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMenuBinding
    private val dataDinos = ArrayList<MyDinoData>() // Menyimpan data dinosaurus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        // Inisialisasi RecyclerView
        val recyclerView = binding.recyclerviewTwoDinos
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Mendapatkan informasi family yang dipilih dari MainActivity
        val selectedFamily = intent.getStringExtra("family")

        // Menampilkan jenis-jenis dinosaurus berdasarkan family yang dipilih
        dataDinos.addAll(getTwoFamily(selectedFamily))
        val adapter = MyDinoAdapter(dataDinos)
        adapter.setOnItemClickListener(this) // Set listener
        recyclerView.adapter = adapter
    }

    override fun onItemClick(dino: MyDinoData) {
        // Menampilkan DetailActivity dengan mengirimkan data Dino
        val intent = Intent(this, DinoDetailActivity::class.java)
        intent.putExtra(DinoDetailActivity.EXTRA_DINO, dino)
        startActivity(intent)
    }


    private fun getTwoFamily(selectedDino: String?): List<MyDinoData> {
        return when (selectedDino) {
            "Theropoda" -> listOf(
                MyDinoData("Tyrannosaurus rex", R.drawable.tyrannosauridae, "Tyrannosaurus rex, atau T-rex, adalah dinosaurus karnivora yang hidup sekitar 68 hingga 66 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. T-rex adalah salah satu dinosaurus terbesar yang pernah ada, dengan panjang sekitar 12 meter dan tinggi sekitar 6 meter.", "Dinosaurus karnivora besar dengan rahang yang kuat, Memiliki tubuh yang besar dan berat, Merupakan predator puncak di ekosistemnya, Cenderung aktif mencari makanan dan berburu.", "Tyrannosauridae", "Darat, padang rumput, hutan", "Daging pemakan hewan lain, pemangsa karnivora", "Sekitar 12 - 13 meter", "Sekitar 4 - 6 meter", "Sekitar 5 - 9 ton", "Rasio otak-ke-tubuh yang rendah mungkin menghasilkan kecerobohan dalam perilaku berburu dan pertempuran."),
                MyDinoData("Velociraptor", R.drawable.anaschisma, "Velociraptor adalah dinosaurus karnivora yang hidup sekitar 75 hingga 71 juta tahun yang lalu di wilayah yang sekarang menjadi Mongolia. Velociraptor dikenal dengan cakarnya yang tajam dan kemampuan berburu secara berkelompok.", "Dinosaurus karnivora yang kecil dan lincah, Memiliki cakar-cakar yang tajam di kaki depannya yang digunakan untuk merobek daging mangsanya, Diperkirakan berburu secara berkelompok dan menggunakan strategi.", "Velociraptoridae", "Darat, padang rumput, hutan", "Daging pemakan hewan lain, pemangsa karnivora", "Sekitar 1.8 - 2 meter", "Sekitar 0.5 - 0.7 meter", "Sekitar 15 - 20 kg", "Kemungkinan memiliki keterbatasan dalam bertahan hidup di lingkungan yang berbeda atau dalam situasi di mana mangsa tersedia dalam jumlah terbatas."),
            )
            "Ornithopoda" -> listOf(
                MyDinoData("Iguanodon", R.drawable.batrachotomus, "Iguanodon adalah dinosaurus herbivora yang hidup sekitar 125 hingga 113 juta tahun yang lalu di wilayah yang sekarang menjadi Eropa dan Afrika. Iguanodon dikenal dengan cakar khas pada jari-jari depannya dan gigi-gigi yang cocok untuk mengunyah makanan tumbuhan.", "Dinosaurus herbivora dengan cakar khas pada jari-jari depannya, Memiliki gigi-gigi yang cocok untuk mengunyah makanan tumbuhan, Diperkirakan hidup secara damai dan mengonsumsi berbagai jenis tumbuhan.", "Iguanodontidae", "Darat, hutan, dataran rendah", "Daun, pucuk, dan tumbuhan tinggi", "Sekitar 10 - 13 meter", "Sekitar 3 - 4 meter", "Sekitar 3 - 4 ton", "Mungkin memiliki perilaku bertahan diri daripada berburu aktif."),
                MyDinoData("Parasaurolophus", R.drawable.arganodus, "Parasaurolophus adalah dinosaurus herbivora yang hidup sekitar 76 hingga 73 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Parasaurolophus dikenal dengan crests yang panjang di atas kepalanya, yang digunakan mungkin untuk pengaturan suara.", "Dinosaurus herbivora dengan crests panjang di atas kepalanya, Diperkirakan crests digunakan untuk pengaturan suara atau mungkin sebagai alat komunikasi antar anggota spesies", "Hadrosauridae", "", "Daun, tumbuhan rendah, dan pucuk", "Sekitar 9.5 - 10 meter", "Sekitar 2.5 - 3 meter", "Sekitar 4 - 6 ton", "Kemungkinan memiliki keterbatasan dalam kemampuan bergerak secara cepat, membuatnya rentan terhadap serangan predator.")
            )
            "Sauropodomorpha" -> listOf(
                MyDinoData("Brachiosaurus", R.drawable.bromsgroveia, "Brachiosaurus adalah dinosaurus herbivora yang hidup sekitar 154 hingga 153 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Brachiosaurus dikenal dengan leher panjangnya yang memungkinkannya mencapai dedaunan tinggi di pohon-pohon.", "Dinosaurus herbivora dengan leher panjang yang memungkinkannya mencapai dedaunan tinggi, Memiliki tubuh besar dan berat dengan kaki depan yang lebih panjang dari kaki belakang, Diperkirakan hidup secara damai dan mungkin bergerombol dalam kelompok-kelompok kecil.", "Sauropodomorpha", "Darat, dataran tinggi, hutan", "Daun, pucuk, dan tumbuhan tinggi", "Sekitar 18 - 22 meter", "Sekitar 9 - 12 meter", "Sekitar 30 - 60 ton", "Ukuran tubuh yang besar mungkin membuatnya rentan terhadap kelaparan karena membutuhkan banyak makanan."),
                MyDinoData("Diplodocus", R.drawable.anaschisma, "Diplodocus adalah dinosaurus herbivora yang hidup sekitar 154 hingga 152 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Diplodocus memiliki tubuh yang panjang dan leher yang fleksibel, serta ekor yang panjang dan ramping.", "Dinosaurus herbivora dengan tubuh panjang dan ekor yang ramping, Memiliki leher yang fleksibel dan kepala kecil dengan gigi-gigi yang sederhana, Diperkirakan mengonsumsi dedaunan tinggi dari pohon-pohon.", "Sauropodomorpha", "Darat, dataran tinggi, hutan", "Daun, pucuk, dan tumbuhan tinggi", "Sekitar 24 - 27 meter", "Sekitar 2.5 - 3 meter", "Sekitar 10 - 16 ton", "Leher yang panjang dan lembut mungkin membuatnya rentan terhadap cedera atau serangan predator."),)

            "Ceratopsidae" -> listOf(
                MyDinoData("Styracosaurus", R.drawable.ceratodus, "Styracosaurus adalah dinosaurus herbivora yang hidup sekitar 75 hingga 70 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Styracosaurus dikenal dengan cula-cula tajam yang menonjol dari tengkoraknya, yang digunakan mungkin untuk pertahanan atau tampilan.", "Dinosaurus herbivora dengan cula-cula tajam yang menonjol dari tengkoraknya, Cenderung hidup di daerah yang bersemak atau hutan-hutan, Diperkirakan menggunakan cula-cula untuk pertahanan atau mungkin dalam ritual perangkap.", "Ceratopsidae", "Darat, hutan, dataran rendah", "Daun, pucuk, dan tumbuhan tinggi", "Sekitar 5 - 5.5 meter", "Sekitar 2.5 - 3 meter", "Sekitar 6 - 12 ton", "Panjang tanduknya mungkin menjadi kaku dan kurang fleksibel, membatasi kemampuan untuk menghindari serangan predator."),
                MyDinoData("Triceratops", R.drawable.dromaeosauridae, "Triceratops adalah dinosaurus herbivora yang hidup sekitar 68 hingga 66 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Triceratops memiliki tiga tanduk di atas tengkoraknya dan frill yang besar di belakang kepalanya.", "Dinosaurus herbivora dengan tiga tanduk di atas tengkoraknya, Memiliki frill yang besar di belakang kepalanya yang mungkin digunakan untuk pertahanan atau tampilan, Diperkirakan hidup secara damai dan menghabiskan sebagian besar waktunya mencari makanan.", "Hadrosauridae", "Darat, padang rumput, hutan", "Daun, pucuk, dan tumbuhan tinggi", "Sekitar 7.9 - 9 meter", "Sekitar 2 - 2.5 meter", "Sekitar 2 - 3 ton", "Ukuran tubuh yang besar mungkin membuatnya rentan terhadap kekurangan makanan dan perubahan iklim."),
            )
            "Hadrosauridae" -> listOf(
                MyDinoData("Corythosaurus", R.drawable.sauropoda, "Corythosaurus adalah dinosaurus herbivora yang hidup sekitar 76 hingga 73 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Corythosaurus dikenal dengan crests yang panjang di atas kepalanya, yang mungkin digunakan untuk mengeluarkan suara dan sebagai alat komunikasi antar anggota spesies.", "Dinosaurus herbivora dengan crests panjang di atas kepalanya, Memiliki crests yang digunakan untuk mengeluarkan suara atau mungkin sebagai alat komunikasi antar anggota spesies", "Hadrosauridae", "", "Daun, tumbuhan rendah, dan pucuk", "Sekitar 9.5 - 10 meter", "Sekitar 2.5 - 3 meter", "Sekitar 4 - 6 ton", "Kemungkinan memiliki keterbatasan dalam kemampuan bergerak secara cepat, membuatnya rentan terhadap serangan predator."),
                MyDinoData("Edmontosaurus", R.drawable.anaschisma, "Edmontosaurus adalah dinosaurus herbivora yang hidup sekitar 73 hingga 65 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Edmontosaurus memiliki tubuh yang besar dengan kepala yang mirip bebek.", "Dinosaurus herbivora dengan tubuh besar dan kepala yang mirip bebek, Mungkin menghabiskan sebagian besar waktunya mencari makanan di daerah rawa-rawa atau lahan basah.", "Hadrosauridae", "Darat, padang rumput, hutan", "Daun, pucuk, dan tumbuhan tinggi", "Sekitar 9 - 13 meter", "Sekitar 2 - 2.5 meter", "Sekitar 1 - 2 ton", "Ukuran tubuh yang besar mungkin membuatnya rentan terhadap predator besar.")
            )
            "Stegosauridae" -> listOf(
                MyDinoData("Kentrosaurus", R.drawable.bromsgroveia, "Kentrosaurus adalah dinosaurus herbivora yang hidup sekitar 154 hingga 150 juta tahun yang lalu di wilayah yang sekarang menjadi Afrika. Kentrosaurus dikenal dengan duri-duri tajam di bagian punggungnya, yang digunakan mungkin untuk pertahanan.", "Dinosaurus herbivora dengan duri-duri tajam di bagian punggungnya, Mungkin digunakan untuk pertahanan terhadap predator atau dalam pertarungan antar individu.", "Stegosauridae", "Darat, hutan, dataran rendah", "Daun, tanaman rendah, mungkin juga serangga", "Sekitar 4 - 5 meter", "Sekitar 1.5 - 2 meter", "Sekitar 0.5 - 1 ton", "Ukuran relatif kecil dan bentuk tubuh yang kaku mungkin membuatnya rentan terhadap serangan predator."),
                MyDinoData("Stegosaurus", R.drawable.batrachotomus, "Stegosaurus adalah dinosaurus herbivora yang hidup sekitar 155 hingga 150 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara dan Eropa. Stegosaurus memiliki punggung yang dilapisi oleh sejumlah besar lempengan tulang yang disebut osteoderma, serta sepasang tanduk di ujung ekornya.", "Dinosaurus herbivora dengan punggung dilapisi oleh lempengan-lempengan tulang, Memiliki sepasang tanduk di ujung ekornya yang mungkin digunakan untuk pertahanan atau tampilan, Diperkirakan memiliki otak kecil dan mungkin mengandalkan strategi pertahanan daripada kecepatan untuk bertahan dari predator.", "Stegosauridae", "Darat, hutan, dataran rendah", "Daun, pucuk, dan tumbuhan tinggi", "Sekitar 9 - 9.5 meter", "Sekitar 2.75 - 3.5 meter", "Sekitar 2 - 3 ton", "Ukuran otak yang relatif kecil mungkin menghasilkan keterbatasan dalam perilaku dan respons terhadap ancaman.")
            )
            "Tyrannosauridae" -> listOf(
                MyDinoData("Daspletosaurus", R.drawable.arganodus, "Daspletosaurus adalah dinosaurus karnivora yang hidup sekitar 77 hingga 75 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Daspletosaurus merupakan kerabat dekat Tyrannosaurus rex dan memiliki rahang yang kuat dengan gigi-gigi yang tajam.", "Dinosaurus karnivora besar dengan gigi-gigi tajam dan rahang yang kuat, Diperkirakan berburu secara aktif dan mungkin berburu dalam kelompok kecil.", "Tyrannosauridae", "Darat, padang rumput, hutan", "Daging pemakan hewan lain, pemangsa karnivora", "Sekitar 8 - 9 meter", "Sekitar 3 - 3.5 meter", "Sekitar 2 - 4 ton", "Kemungkinan memiliki keterbatasan dalam kecepatan dan daya tahan, membuatnya rentan terhadap serangan kelompok mangsa atau predator yang lebih cepat."),
                MyDinoData("Albertosaurus", R.drawable.bromsgroveia, "Albertosaurus adalah dinosaurus karnivora yang hidup sekitar 70 hingga 65 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Albertosaurus merupakan kerabat dekat Tyrannosaurus rex dan juga memiliki rahang yang kuat dengan gigi-gigi yang tajam.", "Dinosaurus karnivora dengan rahang yang kuat dan gigi-gigi tajam, Diperkirakan berburu secara aktif dan mungkin berburu dalam kelompok kecil.", "Tyrannosauridae", "Darat, padang rumput, hutan", "Daging pemakan hewan lain, pemangsa karnivora", "Sekitar 9 - 10 meter", "Sekitar 2.5 - 3 meter", "Sekitar 2 - 4 ton", "Kemungkinan memiliki keterbatasan dalam kecepatan dan daya tahan, membuatnya rentan terhadap serangan kelompok mangsa atau predator yang lebih cepat."),
            )
            "Pterosauria" -> listOf(
                MyDinoData("Quetzalcoatlus", R.drawable.quetzalcoatlus, "Quetzalcoatlus adalah pterosaur yang hidup sekitar 68 hingga 66 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Quetzalcoatlus merupakan salah satu pterosaur terbesar yang pernah ada, dengan rentang sayap yang mencapai 10-11 meter.", "Pterosaur besar dengan rentang sayap yang luas, Mungkin memiliki kemampuan terbang jarak jauh dan mencari makanan di wilayah luas.", "Pterosauria", "Darat, pesisir, danau, rawa-rawa", "Daging pemakan ikan dan hewan kecil lainnya", "Sekitar 10-11 meter (rentang sayap)", "Sekitar 5-6 meter (panjang tubuh)", "Berat tubuh tidak pasti, tetapi diperkirakan beratnya sekitar 200-250 kg", "Rentang sayap yang besar memungkinkan terbang jarak jauh dan eksplorasi habitat yang luas."),
                MyDinoData("Pteranodon", R.drawable.pteranodon, "Pteranodon adalah pterosaur yang hidup sekitar 86 hingga 84 juta tahun yang lalu di wilayah yang sekarang menjadi Amerika Utara. Pteranodon dikenal dengan ciri khas sayapnya yang besar dan memiliki crests besar di bagian belakang kepalanya.", "Pterosaur dengan sayap besar dan crests besar di belakang kepala, Diperkirakan menggunakan crests sebagai alat untuk komunikasi dan mungkin sebagai tampilan.", "Pterosauria", "Laut, pantai, rawa-rawa", "Daging pemakan ikan dan mungkin hewan kecil lainnya", "Sekitar 7-9 meter (rentang sayap)", "Sekitar 3-4 meter (panjang tubuh)", "Berat tubuh tidak pasti, tetapi diperkirakan beratnya sekitar 20-25 kg", "Rentang sayap yang besar memungkinkan terbang jarak jauh dan mencari makanan di wilayah perairan."),
            )
            else -> emptyList()
        }
    }

}
