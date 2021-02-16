package uz.revolution.navigationumsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_tarif.view.*
import uz.revolution.navigationumsapp.adapters.InternetAdapter
import uz.revolution.navigationumsapp.models.Internet

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class InternetFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
    lateinit var adapter: InternetAdapter
    lateinit var data: ArrayList<Internet>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_internet, container, false)

        loadData()
        adapter = InternetAdapter(data)
        root.rv.adapter = adapter

        adapter.setOnClickListener(object : InternetAdapter.OnItemClickListener {
            override fun onClick(internet: Internet) {
                val bundle = Bundle()
                bundle.putSerializable("internet", internet)
                root.findNavController().navigate(R.id.trafikFragment, bundle)
            }

        })


        return root
    }

    private fun loadData() {
        data = ArrayList()

        data.add(Internet("300 MB", "*102*300#", resources.getString(R.string.mb300)))
        data.add(Internet("500 MB", "*102*500#", resources.getString(R.string.mb500)))
        data.add(Internet("1000 MB", "*102*1000#", resources.getString(R.string.mb1000)))
        data.add(Internet("2000 MB", "*102*2000#", resources.getString(R.string.mb2000)))
        data.add(Internet("3000 MB", "*102*3000#", resources.getString(R.string.mb3000)))
        data.add(Internet("5000 MB", "*102*5000#", resources.getString(R.string.mb5000)))
        data.add(Internet("10000 MB", "*102*10000#", resources.getString(R.string.mb10000)))
        data.add(Internet("20000 MB", "*102*20000#", resources.getString(R.string.mb20000)))
        data.add(Internet("30000 MB", "*102*30000", resources.getString(R.string.mb30000)))
        data.add(Internet("50000 MB", "*102*50000#", resources.getString(R.string.mb50000)))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InternetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InternetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}