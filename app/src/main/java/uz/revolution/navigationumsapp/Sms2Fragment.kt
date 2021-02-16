package uz.revolution.navigationumsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_rate.view.*
import uz.revolution.navigationumsapp.R
import uz.revolution.navigationumsapp.models.Sms
import uz.revolution.navigationumsapp.models.Tarif

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Sms2Fragment : Fragment() {
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


    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_sms2, container, false)

        val sms = arguments?.getSerializable("sms") as Sms

        root.name.text = sms.name
        root.description.text = sms.description

        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Sms2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}