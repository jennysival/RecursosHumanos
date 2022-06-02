package br.com.zup.recursoshumanos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.recursoshumanos.databinding.ActivityMainBinding
import br.com.zup.recursoshumanos.fragments.CadastroFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, CadastroFragment())
            .commit()
    }
}