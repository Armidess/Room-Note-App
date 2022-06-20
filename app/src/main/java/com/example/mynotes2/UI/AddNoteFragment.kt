package com.example.mynotes2.UI



import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mynotes2.DB.Note
import com.example.mynotes2.DB.NoteDatabase
import com.example.mynotes2.R
import com.example.mynotes2.databinding.FragmentAddNoteBinding
class AddNoteFragment : Fragment() {

    lateinit var binding : FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.buttonSave.setOnClickListener(){
            val notetitle =binding.title.text.toString().trim()
            val notebody =binding.notebody.text.toString().trim()

            if(notetitle.isEmpty()){
                binding.title.error= "Title Required"
                binding.title.requestFocus()
                return@setOnClickListener
            }
            if(notebody.isEmpty()){
                binding.notebody.error = "Note Required"
                binding.notebody.requestFocus()
                return@setOnClickListener
            }
            val note = Note(notetitle,notebody)

            saveNote(note)


        }

    }
    private fun saveNote(note : Note){


        class SaveNote : AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg params: Void?): Void? {
                NoteDatabase(activity!!).getNoteDao().addNote(note)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(context,"Note Saved",Toast.LENGTH_LONG).show()
            }
        }
        SaveNote().execute();
    }

}

