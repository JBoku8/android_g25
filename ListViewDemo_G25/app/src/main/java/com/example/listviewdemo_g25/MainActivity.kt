package com.example.listviewdemo_g25

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var mainListView: ListView
    val techsList = arrayOf<String>(
            "Java",
            "Kotlin",
            "Go",
            "Rust",
            "Javascript",
            "Java",
            "Kotlin",
            "Go",
            "Rust",
            "Javascript",
            "Java",
            "Kotlin",
            "Go",
            "Rust",
            "Javascript"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainListView = findViewById(R.id.main_listView)

        // val listViewColor = Color.parseColor("#64B6AC")
        // mainListView.setBackgroundColor(listViewColor)

         mainListView.adapter = TechAdapter(this, techsList)

        mainListView.setOnItemClickListener { _, _, position, _ ->
            Log.i("INFO", "Clicked position $position")
            Log.i("INFO", "Clicked tech ${techsList[position]}")
            val intent  = Intent()
            intent.setClass(this, TechDetailActivity::class.java)
            intent.putExtra(Constants.Selected_Tech, techsList[position])
            intent.putExtra(Constants.Selected_Tech_Index, position)

            startActivity(intent)


        }
    }

    private class TechAdapter(var context: Context, var dataSource: Array<String> ): BaseAdapter(){
        val number: Int  = 100;
        var text: String = "Demo Text";


        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        override fun getCount(): Int {
            return dataSource.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var rootLayout: View;

            if( convertView == null ) {
                // Log.i("FIndViewById", "create layout");
                val listViewLayout = LayoutInflater.from(context)
                rootLayout = listViewLayout.inflate(R.layout.listview_layout, parent, false);

                val textViewTitle = rootLayout.findViewById<TextView>(R.id.titleTextView)
                val textViewIndex = rootLayout.findViewById<TextView>(R.id.textViewIndex)

                val viewHolder = ViewHolder(textViewTitle, textViewIndex);

                rootLayout.tag = viewHolder;
            }
            else {
                rootLayout = convertView
            }

            val viewHolder = rootLayout.tag as ViewHolder
            viewHolder.textViewTitle.text = dataSource[position]
            viewHolder.textViewIndex.text = "Index Number: $position"

            return  rootLayout

        }

        private class ViewHolder(val textViewTitle: TextView, val textViewIndex: TextView);
    }

}