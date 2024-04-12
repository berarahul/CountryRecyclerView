package com.example.countryrecylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
lateinit var  myrecyclerview:RecyclerView
lateinit var  myarray:ArrayList<datamodel>
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myrecyclerview=findViewById(R.id.recyclerView)

       val countryimage= arrayOf(
           R.drawable.india,
           R.drawable.austraia,
           R.drawable.argentina,
           R.drawable.brazil,
           R.drawable.canada,
           R.drawable.england,
           R.drawable.pakisthan,
           R.drawable.southafrica,
           R.drawable.srilanka,
           R.drawable.usa
       )
        val text= arrayOf("INDIA","Australia","Argentina","Brazil","Canada","England","Pakistan","South Africa","SriLanka","United State")
        myrecyclerview.layoutManager= LinearLayoutManager(this)
         myarray= arrayListOf<datamodel>()
        for (eachindex in countryimage.indices){

            val data = datamodel(countryimage[eachindex],text[eachindex])
            myarray.add(data)

        }
        myrecyclerview.adapter= MyAdapter(myarray,this)
    }
}