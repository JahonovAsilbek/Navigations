package uz.revolution.navigationumsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_tarif.view.*
import uz.revolution.navigationumsapp.adapters.SmsAdapter
import uz.revolution.navigationumsapp.models.Sms

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SmsFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    lateinit var root: View
    lateinit var adapter: SmsAdapter
    lateinit var data: ArrayList<Sms>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_sms, container, false)

        loadData()
        adapter = SmsAdapter(data)
        root.rv.adapter = adapter

        adapter.setOnClickListener(object : SmsAdapter.OnItemClickListener {
            override fun onClick(sms: Sms) {
                val bundle = Bundle()
                bundle.putSerializable("sms", sms)
                root.findNavController().navigate(R.id.sms2Fragment, bundle)
            }

        })

        return root
    }

    private fun loadData() {
        data = ArrayList()

        data.add(Sms("«SMS 100»", "*104*100#", resources.getString(R.string.sms100)))
        data.add(Sms("«SMS 300»", "*104*300#", resources.getString(R.string.sms300)))
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SmsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}