package uz.revolution.navigationumsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_rate.view.*
import uz.revolution.navigationumsapp.R
import uz.revolution.navigationumsapp.models.Daqiqa
import uz.revolution.navigationumsapp.models.Tarif


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MinuteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_minute, container, false)

        val daqiqa = arguments?.getSerializable("daqiqa") as Daqiqa

        root.name.text=daqiqa.name
        root.description.text=daqiqa.description

        return root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MinuteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}