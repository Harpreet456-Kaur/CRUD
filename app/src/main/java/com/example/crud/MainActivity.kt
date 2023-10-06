package com.example.crud

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.crud.databinding.ActivityMainBinding
import com.example.crud.databinding.AdditemsBinding
import com.example.crud.databinding.EdititemsBinding
import com.example.crud.databinding.ItemsBinding

class MainActivity : AppCompatActivity(), BAdapter.BInterface {
    lateinit var binding: ActivityMainBinding
    lateinit var bAdapter: BAdapter
    var BList = ArrayList<BModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fBtn.setOnClickListener {
            var dialogBinding = AdditemsBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)

            dialogBinding.addBtn.setOnClickListener {
                BList.add(
                    BModel(
                        dialogBinding.name.text.toString(),
                        dialogBinding.course.text.toString()
                    )
                )
                bAdapter = BAdapter(BList, this)
                binding.base.adapter = bAdapter

                dialog.dismiss()
            }
            dialog.show()
        }
    }

    override fun click(position: Int, list: ArrayList<BModel>) {
        var newDialogBinding = EdititemsBinding.inflate(layoutInflater)
        var dialogBox = Dialog(this)
        dialogBox.setContentView(newDialogBinding.root)

        newDialogBinding.name.setText(list[position].name.toString())
        newDialogBinding.course.setText(list[position].course.toString())

        newDialogBinding.btnEdit.setOnClickListener {
            BList.set(
                position, BModel(
                    newDialogBinding.name.text.toString(),
                    newDialogBinding.course.text.toString()
                )
            )
            bAdapter.notifyDataSetChanged()
            dialogBox.dismiss()
        }

        newDialogBinding.btnDelete.setOnClickListener {
            BList.removeAt(position)
            bAdapter.notifyDataSetChanged()
            dialogBox.dismiss()
        }
        dialogBox.show()
    }
}