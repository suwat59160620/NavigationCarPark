package buu.informatics.s59160620.carparking


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160620.carparking.databinding.FragmentLoginBinding

import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class loginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        binding.btnLogin.setOnClickListener{view ->
            binding.apply {
                var username01 = editUsername.text.toString()
                var password02 = password.text.toString()
                if(username01 == "suwat" && password02 == "111222333"){
                    view.findNavController()
                        .navigate(R.id.action_loginFragment3_to_carpark4)
                }else{
                    Toast.makeText(getActivity(), "Username หรือ Password ไม่ถูกต้อง",
                        Toast.LENGTH_LONG).show();
                }
            }
            val context = this.getContext()
            val inputMethodManager =
                context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
        binding.btnCancel.setOnClickListener {
            binding.apply {
                editUsername.getText().clear();
                password.getText().clear();
            }
        }

        return binding.root
    }

}

