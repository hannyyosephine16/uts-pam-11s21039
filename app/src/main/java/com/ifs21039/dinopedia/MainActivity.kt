package com.ifs21039.dinopedia
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import android.content.Intent // Import Intent from android.content
import com.ifs21039.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataFamily = ArrayList<MyDinoFamily>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerviewdino.setHasFixedSize(true)
        dataFamily.addAll(getListFamily())
        showRecyclerView()
    }

    private fun getListFamily(): ArrayList<MyDinoFamily> {
        val listFamily = ArrayList<MyDinoFamily>()
        listFamily.add(MyDinoFamily("Theropoda", R.drawable.tyrannosauridarmv))
        listFamily.add(MyDinoFamily("Sauropodomorpha", R.drawable.tyrannosauridarmv))
        listFamily.add(MyDinoFamily("Ornithischia", R.drawable.tyrannosauridarmv))
        listFamily.add(MyDinoFamily("Ceratopsidae", R.drawable.tyrannosauridarmv))
        listFamily.add(MyDinoFamily("Hadrosauridae", R.drawable.tyrannosauridarmv))
        listFamily.add(MyDinoFamily("Stegosauridae", R.drawable.tyrannosauridarmv))
        listFamily.add(MyDinoFamily("Tyrannosauridae", R.drawable.tyrannosauridarmv))
        listFamily.add(MyDinoFamily("Velociraptoridae", R.drawable.tyrannosauridarmv))
        return listFamily
    }

    private fun showRecyclerView() {
        binding.recyclerviewdino.layoutManager = GridLayoutManager(this, 2)
        val listFamilyAdapter = MyDinoFamilyAdapter(dataFamily)
        binding.recyclerviewdino.adapter = listFamilyAdapter

        listFamilyAdapter.setOnItemClickCallback(object : MyDinoFamilyAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MyDinoFamily) {
                showDinosByFamily(data.namaFamily, data.iconFamily)
            }
        })
    }

    private fun showDinosByFamily(family: String, icon: Int) {
        val intent = Intent(this@MainActivity, MenuActivity::class.java)
        intent.putExtra("family", family)
        intent.putExtra("icon", icon)
        startActivity(intent)
    }
}

//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView

//class MainActivity : AppCompatActivity(), MyDinoAdapter.OnItemClickListener {
//
//    private val myDinoData = arrayOf(
//        MyDinoData(
//            "Dromaeosauridae",
//            "Dromaeosauridae adalah sebuah famili dinosaurus theropoda yang terkenal dengan anggota-anggotanya yang cakap berburu dan memiliki ciri khas cakar kaki yang besar dan tajam.",
//            R.drawable.dromaeosauridae,
//            "Periode Kapur",
//            "Dromaeosauridae memiliki ukuran tubuh yang sedang hingga kecil, memiliki cakar kaki yang besar dan tajam, gigi yang runcing, dan ekor yang panjang untuk keseimbangan.",
//            "Biasanya ditemukan di lingkungan darat, terutama hutan dan daerah terbuka. Mungkin juga mendiami daerah rawa atau pantai.",
//            "Dromaeosauridae adalah pemburu yang cerdas dan gesit. Mereka menggunakan cakar kaki yang besar dan tajam untuk menyerang dan membunuh mangsa.",
//            "Kelas Reptilia, Ordo Saurischia, Infraorder Coelurosauria, Famili yang mencakup Velociraptor, Deinonychus, dan lainnya."
//        ),
//        MyDinoData(
//            "Arganodus",
//            "Arganodus adalah genus dari ikan bertulang yang hidup pada periode Devonian, sekitar 400 juta tahun yang lalu. Genus ini termasuk dalam kelompok Actinopterygii atau ikan bertulang sejati, yang merupakan kelompok ikan paling maju dan beragam hingga saat ini.",
//            R.drawable.arganodus,
//            "Periode Devonian",
//            "Arganodus memiliki tubuh silindris, sirip dada dan perut yang besar, serta sirip ekor yang kuat untuk berenang. Mereka memiliki gigi-gigi kecil yang cocok untuk memakan plankton dan organisme kecil lainnya.",
//            "Umumnya ditemukan di perairan laut dangkal hingga sedang. Mungkin juga hidup di muara sungai atau estuari.",
//            "Arganodus adalah ikan pemakan plankton yang hidup secara filter-feeding. Mereka biasanya berenang dengan mulut terbuka untuk menangkap plankton yang lewat.",
//            "Kelas Actinopterygii, Subkelas Neopterygii, Superordo Actinopteri, Ordo Palaeonisciformes, Famili yang mencakup Arganodus dan spesies terkait lainnya."
//        ),
//        MyDinoData(
//            "Hidrosauridae",
//            "Hidrosauridae adalah famili dinosaurus bertubuh besar yang memiliki rahang yang teradaptasi dengan baik untuk mengunyah tanaman, terutama pada genera yang lebih besar.",
//            R.drawable.batrachotomus,
//            "Periode Kapur",
//            "Hidrosauridae memiliki tubuh besar dengan leher panjang dan rahang yang kuat. Gigi-gigi mereka dirancang untuk mengunyah tumbuhan yang keras.",
//            "Biasanya ditemukan di daerah dataran rendah, rawa, dan hutan tropis yang kaya akan tanaman. Mungkin juga hidup di daerah yang memiliki sumber air yang cukup.",
//            "Hidrosauridae adalah dinosaurus herbivora yang menghabiskan sebagian besar waktunya untuk mencari makan. Mereka dapat berpindah-pindah untuk mencari tanaman yang tersedia.",
//            "Kelas Reptilia, Ordo Ornithischia, Subordo Cerapoda, Infraorder Hadrosauriformes, Famili yang mencakup Parasaurolophus, Edmontosaurus, dan lainnya."
//        ),
//        MyDinoData(
//            "Ornithomimidae",
//            "Ornithomimidae adalah famili dinosaurus theropoda yang dikenal sebagai 'dinosaurus mirip burung' karena tubuh dan perilaku mereka yang menyerupai burung modern. Mereka adalah dinosaurus karnivora yang berlari cepat.",
//            R.drawable.anaschisma,
//            "Periode Kapur",
//            "Ornithomimidae memiliki tubuh kecil hingga sedang dengan kaki panjang dan ramping. Mereka memiliki cakar kecil dan tajam serta gigi-gigi kecil yang cocok untuk memakan daging.",
//            "Biasanya ditemukan di lingkungan darat, terutama daerah terbuka dan padang rumput. Mungkin juga berada di hutan yang lebih terbuka.",
//            "Ornithomimidae adalah pemburu yang gesit dan cepat. Mereka menggunakan kaki panjang mereka untuk berlari dan mengejar mangsa.",
//            "Kelas Reptilia, Ordo Saurischia, Infraorder Ornithomimosauria, Famili yang mencakup Ornithomimus, Gallimimus, dan lainnya."
//        ),
//        MyDinoData(
//            "Nodosauridae",
//            "Nodosauridae adalah famili dinosaurus bertubuh besar yang termasuk dalam ordo Ankylosauria. Mereka memiliki ciri khas berupa pelat-pelat atau tulang-sisik yang melindungi tubuh mereka, mirip dengan tetua berjalan ankylosauridae, tetapi tanpa alat pertahanan yang ekstrem seperti belah ketupat atau palu ekor yang dimiliki oleh ankylosauridae.",
//            R.drawable.bromsgroveia,
//            "Periode Kapur",
//            "Nodosauridae memiliki tubuh besar dengan pelat atau tulang-sisik yang kuat dan tebal. Mereka juga memiliki duri atau tonjolan yang membantu melindungi tubuh mereka dari serangan predator.",
//            "Biasanya ditemukan di lingkungan darat, terutama daerah hutan dan padang rumput. Mungkin juga bersembunyi di tempat-tempat terlindung seperti gua atau celah tebing.",
//            "Nodosauridae adalah dinosaurus herbivora yang cenderung soliter dan defensif. Mereka menggunakan pelat atau tulang-sisik mereka sebagai perlindungan dari predator.",
//            "Kelas Reptilia, Ordo Ornithischia, Subordo Ankylosauria, Infraorder Nodosauridae, Famili yang mencakup Pawpawsaurus, Edmontonia, dan lainnya."
//        ),
//        MyDinoData(
//            "Ceratopsidae",
//            "Ceratopsidae adalah famili dinosaurus herbivora yang mencakup dinosaurus bertanduk seperti Triceratops. Mereka memiliki tanduk di hidung dan kresta di tengkorak yang digunakan untuk mempertahankan diri atau mungkin untuk memikat pasangan.",
//            R.drawable.ceratodus,
//            "Periode Kapur",
//            "Ceratopsidae memiliki tubuh besar dengan tanduk di hidung dan kresta di tengkorak. Mereka juga memiliki gigi-gigi runcing di rahang yang digunakan untuk mengunyah tanaman.",
//            "Biasanya ditemukan di lingkungan darat, terutama daerah dataran tinggi dan hutan belantara yang kaya akan tanaman. Mungkin juga berada di daerah yang memiliki sumber air yang cukup.",
//            "Ceratopsidae adalah dinosaurus herbivora yang cenderung hidup secara berkelompok. Mereka menggunakan tanduk dan kresta mereka untuk komunikasi dan mempertahankan wilayah.",
//            "Kelas Reptilia, Ordo Ornithischia, Infraorder Ceratopsia, Famili yang mencakup Triceratops, Styracosaurus, dan lainnya."
//        )
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        val myDinoAdapter = MyDinoAdapter(myDinoData, this@MainActivity)
//        recyclerView.adapter = myDinoAdapter
//
//        myDinoAdapter.setOnItemClickListener(this)
//    }
//
//    override fun onItemClick(position: Int) {
//        val clickedDino = myDinoData[position]
//        val intent = Intent(this, DinoDetailActivity::class.java)
//        intent.putExtra("dinoPeriod", clickedDino.dinoPeriod)
//        intent.putExtra("dinoHabitat", clickedDino.dinoHabitat)
//        intent.putExtra("dinoPhysicalCharacteristics", clickedDino.dinoPhysicalCharacteristics)
//        intent.putExtra("dinoBehavior", clickedDino.dinoBehavior)
//        intent.putExtra("dinoClassification", clickedDino.dinoClassification)
//        startActivity(intent)
//    }
//
//    fun openAboutActivity() {
//        val intent = Intent(this, AboutActivity::class.java)
//        startActivity(intent)
//    }
//}