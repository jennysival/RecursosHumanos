package br.com.zup.recursoshumanos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.recursoshumanos.CHAVE_FUNCIONARIO
import br.com.zup.recursoshumanos.R
import br.com.zup.recursoshumanos.databinding.FragmentSalarioBinding
import br.com.zup.recursoshumanos.model.Funcionario

class SalarioFragment : Fragment() {
    private lateinit var binding: FragmentSalarioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSalarioBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receberDados()
    }

    private fun receberDados(){
        val funcionario = arguments?.getParcelable<Funcionario>(CHAVE_FUNCIONARIO)
        if(funcionario != null){
            val horas = buildString {
                append("Horas Trabalhadas: ")
                append(funcionario.getHoras().toInt().toString())
                append("h")
            }

            val salario = buildString {
                append("Salario a receber: R$ ")
                append(funcionario.getSalario().toString())
                append("0")
            }

            val valor = buildString {
                append("Valor por hora: R$ ")
                append(funcionario.getValor().toString())
                append("0")
            }

            binding.tvHoras.text = horas
            binding.tvSalario.text = salario
            binding.tvValor.text = valor
            binding.tvNomeUser.text = funcionario.getNome()
        }
    }

}